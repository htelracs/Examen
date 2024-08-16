package JHUserInterface.JHCustomerCntrol;

import javax.swing.JComboBox;

import JHUserInterface.JHEstilo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

public class JHComboBox extends JComboBox<String>  {
     
    public JHComboBox(String[] items) {
        super(items);
        customizeComponent();

    }

    public JHComboBox(List<String> items, String jhNomComboBox) {
        super();
        addItem(jhNomComboBox);

        for (String item : items) {
            addItem(item);
        }
        customizeComponent();
    }

    private void customizeComponent() {
        setFont(JHEstilo.FONT_SMALL);
        setForeground(JHEstilo.COLOR_FONT);
        setPreferredSize(new Dimension(100, 30)); 
        setBackground(Color.BLUE); 
        setSelectedIndex(0);
    }

    @Override
    public void setSelectedIndex(int index) {
        if (index == 0) {
            return;
        }
        super.setSelectedIndex(index);
    }
}
