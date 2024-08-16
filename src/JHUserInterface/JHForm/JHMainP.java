package JHUserInterface.JHForm;
import javax.swing.*;
import JHUserInterface.JHEstilo;
import java.awt.*;

public class JHMainP extends JPanel {
    public JHMainP() {
        setBackground(JHEstilo.COLOR_BORDER);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;

        JHHormigueroP hormigueroPanel = new JHHormigueroP();
        JHActionPanel actionPanel = new JHActionPanel(hormigueroPanel);
        JHBottomPanel bottomPanel = new JHBottomPanel(hormigueroPanel);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(new JHCedulaP(), gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(hormigueroPanel, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(actionPanel, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(bottomPanel, gbc);
    }
}
