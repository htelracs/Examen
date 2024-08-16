package JHUserInterface.JHForm;

import java.awt.*;
import javax.swing.JLabel;

import JHUserInterface.JHEstilo;
import JHUserInterface.JHCustomerCntrol.JHPanel;
import JHUserInterface.JHCustomerCntrol.JHTextBox;

public class JHCedulaP extends JHPanel {
    public String mlNombre = "Scarleth Jarrin";
    public String mlCedula = "1004770598";

    public JHCedulaP() {
        
        super(20, JHEstilo.COLOR_BORDER); 

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

       
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel cedulaLabel = new JLabel("Cedula del alumno:");
        cedulaLabel.setFont(JHEstilo.FONT_SMALL); 
        cedulaLabel.setForeground(Color.WHITE);
        add(cedulaLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        JHTextBox cedulaField = new JHTextBox();
        cedulaField.setFont(JHEstilo.FONT_SMALL); 
        cedulaField.setText(mlCedula); 
        cedulaField.setEditable(false); 
        cedulaField.setPreferredSize(new Dimension(200, 25)); 
        add(cedulaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel nombresLabel = new JLabel("Nombres completos del alumno:");
        nombresLabel.setFont(JHEstilo.FONT_SMALL); 
        nombresLabel.setForeground(Color.WHITE);
        add(nombresLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        JHTextBox nombresField = new JHTextBox();
        nombresField.setFont(JHEstilo.FONT_SMALL); 
        nombresField.setText(mlNombre); 
        nombresField.setEditable(false); 
        nombresField.setPreferredSize(new Dimension(200, 25)); 
        add(nombresField, gbc);
    }
}
