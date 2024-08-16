package JHUserInterface.JHForm;
import javax.swing.*;

import JHUserInterface.JHEstilo;
import JHUserInterface.JHCustomerCntrol.JHButton;

import java.awt.*;

public class JHGPanel extends JPanel {
    public JHGPanel() {
        setLayout(new BorderLayout());

        JLabel logoLabel = new JLabel(new ImageIcon(JHEstilo.URL_LOGO));
        add(logoLabel, BorderLayout.WEST);

        JPanel grid = new JPanel(new GridLayout(3, 4, 5, 5));
        for (int i = 0; i < 12; i++) { // 3x4 = 12 cuadros
            grid.add(new JLabel(""));
        }
        add(grid, BorderLayout.CENTER);

    
        JHButton createAntButton = new JHButton("Crear hormiga larva", false, JHEstilo.FONT_BOLD);
        add(createAntButton, BorderLayout.EAST);
    }
}
