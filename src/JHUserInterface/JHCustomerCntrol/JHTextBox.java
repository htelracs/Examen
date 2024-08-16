package JHUserInterface.JHCustomerCntrol;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import JHUserInterface.JHEstilo;

import javax.swing.JTextField;
import java.awt.Insets;

public class JHTextBox extends JTextField{
    public JHTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setFont(JHEstilo.FONT);
        setForeground(JHEstilo.COLOR_FONT_LIGHT);
        setCaretColor(JHEstilo.COLOR_CURSOR);
        setMargin(new Insets(5, 5, 5, 5));
        setBorderRect();
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(JHEstilo.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);
        setBorder(new CompoundBorder(lineBorder, emptyBorder));
    }
}
