package JHUserInterface.JHGUI;

import javax.swing.JFrame;

import JHUserInterface.JHCustomerCntrol.JHPanelBar;
import JHUserInterface.JHForm.JHMainP;

import java.awt.BorderLayout;
import java.awt.Container;

public class JHMain extends JFrame{
    public JHMain(String titleApp) {
        customizeComponent(titleApp);
    }

    private void customizeComponent(String titleApp) {
        setUndecorated(true);
        setSize(500, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(new JHPanelBar(this), BorderLayout.NORTH);

        container.add(new JHMainP(), BorderLayout.CENTER);

        setVisible(true);

    }
}
