package JHUserInterface.JHForm;

import java.awt.*;

import javax.swing.JOptionPane;

import JHDataAccess.JHHormigeroDAO;
import JHDataAccess.JHDTO.JHHormigeroDTO;
import JHUserInterface.JHEstilo;
import JHUserInterface.JHCustomerCntrol.JHButton;
import JHUserInterface.JHCustomerCntrol.JHPanel;

public class JHBottomPanel extends JHPanel {
    private JHHormigueroP hormigueroPanel;
    private JHHormigeroDAO hormigaDAO;

    public JHBottomPanel(JHHormigueroP hormigueroPanel) {
        super(15, JHEstilo.COLOR_BORDER);

        this.hormigueroPanel = hormigueroPanel;
        hormigaDAO = new JHHormigeroDAO();

        JHButton buttonEliminar = new JHButton("Eliminar", false, JHEstilo.FONT_SMALL);
        JHButton buttonGuardar = new JHButton("Guardar", false, JHEstilo.FONT_SMALL);

        buttonEliminar.setBackground(Color.PINK);
        buttonGuardar.setBackground(Color.DARK_GRAY);

        buttonGuardar.addActionListener(e -> guardarCambios());
        buttonEliminar.addActionListener(e -> eliminarHormiga());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttonEliminar, gbc);

        gbc.gridx = 1;
        add(buttonGuardar, gbc);
    }

    private void guardarCambios() {
        JHHormigeroDTO hormiga = hormigueroPanel.obtenerHormigaSeleccionada();
        if (hormiga != null) {
            try {
                hormigaDAO.jhUpdate(hormiga);
                JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente", "Guardar",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarHormiga() {
        JHHormigeroDTO hormiga = hormigueroPanel.obtenerHormigaSeleccionada();
        if (hormiga != null) {
            try {
                hormigaDAO.jhDelete(hormiga.getIdHormiga());
                hormigueroPanel.cargarHormigas(); 
                JOptionPane.showMessageDialog(this, "Eliminada exitosamente", "Eliminar",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
