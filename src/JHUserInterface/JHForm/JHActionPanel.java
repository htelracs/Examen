package JHUserInterface.JHForm;
import java.util.List;
import javax.swing.JOptionPane;

import JHDataAccess.JHGenoAlimentoDAO;
import JHDataAccess.JHHormigeroDAO;
import JHDataAccess.JHIngestaNativaDAO;
import JHDataAccess.JHDTO.JHCatalogoDTO;
import JHDataAccess.JHDTO.JHHormigeroDTO;
import JHUserInterface.JHEstilo;
import JHUserInterface.JHCustomerCntrol.JHButton;
import JHUserInterface.JHCustomerCntrol.JHComboBox;
import JHUserInterface.JHCustomerCntrol.JHPanel;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JHActionPanel extends JHPanel {

    private JHHormigeroDAO hormigaDAO;
    private JHComboBox genoAlimentoComboBox;
    private JHComboBox ingestaNativaComboBox;
    private JHHormigueroP hormigueroPanel;

    public JHActionPanel(JHHormigueroP hormigueroPanel) {
        super(20, JHEstilo.COLOR_BORDER); 
        this.hormigueroPanel = hormigueroPanel;

    
        hormigaDAO = new JHHormigeroDAO();

        JHIngestaNativaDAO ingestaDAO = new JHIngestaNativaDAO();
        JHGenoAlimentoDAO genoAlimentoDAO = new JHGenoAlimentoDAO();

        List<String> ingestaItems;
        List<String> genoAlimentoItems;

        try {
            ingestaItems = ingestaDAO.jhReadAll().stream().map(ingesta -> ingesta.getNombre()).toList();
            genoAlimentoItems = genoAlimentoDAO.jhReadAll().stream().map(genoAlimento -> genoAlimento.getNombre())  .toList();
        } catch (Exception e) {
            e.printStackTrace();
            ingestaItems = List.of("Error al cargar");
            genoAlimentoItems = List.of("Error al cargar");
        }

        genoAlimentoComboBox = new JHComboBox(genoAlimentoItems, "GenoAlimento");
        ingestaNativaComboBox = new JHComboBox(ingestaItems, "IngestaNativa");

        JHButton buttonAlimentarGA = new JHButton("Alimentar con Genoalimento", false, JHEstilo.FONT_SMALL);
        JHButton buttonAlimentarIN = new JHButton("Alimentar con Ingesta Nativa", false, JHEstilo.FONT_SMALL);

        buttonAlimentarGA.setBackground(JHEstilo.COLOR_BORDER); 
        buttonAlimentarIN.setBackground(JHEstilo.COLOR_BORDER); 
        buttonAlimentarGA.addActionListener(e -> alimentarHormiga("GenoAlimento"));
        buttonAlimentarIN.addActionListener(e -> alimentarHormiga("IngestaNativa"));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(genoAlimentoComboBox, gbc);

        gbc.gridx = 1;
        add(buttonAlimentarGA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(ingestaNativaComboBox, gbc);

        gbc.gridx = 1;
        add(buttonAlimentarIN, gbc);
    }

    private void alimentarHormiga(String tipoAlimento) {
        JHHormigeroDTO hormiga = hormigueroPanel.obtenerHormigaSeleccionada();
        if (hormiga == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una hormiga antes de alimentarla.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (tipoAlimento.equals("GenoAlimento")) {
            int idGenoAlimento = obtenerIdGenoAlimento(genoAlimentoComboBox.getSelectedItem().toString());
            hormiga.setIdCatalogoGenoAlimento(idGenoAlimento);
        } else if (tipoAlimento.equals("IngestaNativa")) {
            int idIngestaNativa = obtenerIdIngestaNativa(ingestaNativaComboBox.getSelectedItem().toString());
            hormiga.setIdCatalogoIngestaNativa(idIngestaNativa);
        }

        try {
            hormigaDAO.jhUpdate(hormiga);
            hormigueroPanel.actualizarHormigaEnTabla(hormiga); 
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el alimento de la hormiga", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerIdGenoAlimento(String nombreGenoAlimento) {
        JHGenoAlimentoDAO genoAlimentoDAO = new JHGenoAlimentoDAO();
        try {
            List<JHCatalogoDTO> genoAlimentos = genoAlimentoDAO.jhReadAll();
            for (JHCatalogoDTO genoAlimento : genoAlimentos) {
                if (genoAlimento.getNombre().equals(nombreGenoAlimento)) {
                    return genoAlimento.getIdCatalogo();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; 
    }

    private int obtenerIdIngestaNativa(String nombreIngestaNativa) {
        JHIngestaNativaDAO ingestaNativaDAO = new JHIngestaNativaDAO();
        try {
            List<JHCatalogoDTO> ingestaNativas = ingestaNativaDAO.jhReadAll();
            for (JHCatalogoDTO ingestaNativa : ingestaNativas) {
                if (ingestaNativa.getNombre().equals(nombreIngestaNativa)) {
                    return ingestaNativa.getIdCatalogo();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; 
    }

}
