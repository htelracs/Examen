package JHUserInterface.JHForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import JHBusinessLogic.JHHormigueroBL;
import JHDataAccess.JHHormigeroDAO;
import JHDataAccess.JHDTO.JHHormigeroDTO;
import JHUserInterface.JHEstilo;
import JHUserInterface.JHCustomerCntrol.JHButton;
import JHUserInterface.JHCustomerCntrol.JHPanel;

import java.awt.*;
import java.util.List;


public class JHHormigueroP extends JHPanel {

    private JTable tablaHormigas;
    private JHHormigeroDAO hormigaDAO;
    private JHHormigueroBL hormigaBL; 


    public JHHormigueroP() {
        super(20, Color.BLUE); 
        hormigaDAO = new JHHormigeroDAO();
        hormigaBL = new JHHormigueroBL(); 
        

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.05;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel logoLabel = new JLabel(new ImageIcon(JHEstilo.URL_LOGO));
        add(logoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.25;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel titleLabel = new JLabel("  Hormiguero virtual", JLabel.LEFT);
        titleLabel.setFont(JHEstilo.FONT_BOLD);
        add(titleLabel, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.EAST;
        JHButton createAntButton = new JHButton("Crear hormiga larva", false, JHEstilo.FONT_SMALL);
        createAntButton.setPreferredSize(new Dimension(150, 25));
        createAntButton.setBackground(Color.BLUE); 
        add(createAntButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        tablaHormigas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tablaHormigas);
        add(scrollPane, gbc);

        cargarHormigas();
    }

    public void cargarHormigas() {
        try {
            List<JHHormigeroDTO> hormigas = hormigaDAO.jhReadAll();
            DefaultTableModel model = new DefaultTableModel(
                    new String[] { "Nombre", "Sexo", "GenoAlimento", "IngestaNativa", "Provincia", "Tipo Hormiga" }, 0);

            for (JHHormigeroDTO hormiga : hormigas) {
                
                ;
            }

            tablaHormigas.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar hormigas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JHHormigeroDTO obtenerHormigaSeleccionada() {
        int selectedRow = tablaHormigas.getSelectedRow();
        if (selectedRow != -1) {
            String nombreHormiga = (String) tablaHormigas.getValueAt(selectedRow, 0);
            try {
                return hormigaDAO.jhReadAll().stream()
                        .filter(h -> h.TipoHormiga().equals(nombreHormiga))
                        .findFirst().orElse(null);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al obtener la hormiga seleccionada", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    public void actualizarHormigaEnTabla(JHHormigeroDTO hormiga) {
        int selectedRow = tablaHormigas.getSelectedRow();
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

