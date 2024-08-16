package JHUserInterface.JHCustomerCntrol;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JHUserInterface.JHEstilo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JHPanelBar  extends JPanel{
    private boolean isMaximized = false; 
    private Point previousLocation;
    private Dimension previousSize;

    public JHPanelBar(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(JHEstilo.COLOR_FONT_LIGHT); 

        ImageIcon logoIcon = new ImageIcon(JHEstilo.URL_LOGO); 
        JLabel logoLabel = new JLabel(logoIcon);

        JLabel titleLabel = new JLabel("EcuaFauna 2K24A");
        titleLabel.setFont(JHEstilo.FONT_SMALL); 
        titleLabel.setForeground(Color.WHITE); 

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        titlePanel.setOpaque(false);
        titlePanel.add(logoLabel); 
        titlePanel.add(titleLabel); 

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBackground(Color.BLUE);
        JHButton closeButton = new JHButton("X", true, JHEstilo.FONT_SMALL);
        JHButton minimizeButton = new JHButton("_", true, JHEstilo.FONT_SMALL);
        JHButton maximizeButton = new JHButton("O", true, JHEstilo.FONT_SMALL);

        closeButton.setBackground(JHEstilo.COLOR_BORDER);
        minimizeButton.setBackground(JHEstilo.COLOR_BORDER);
        maximizeButton.setBackground(JHEstilo.COLOR_BORDER);

        buttonPanel.add(minimizeButton);
        buttonPanel.add(maximizeButton);
        buttonPanel.add(closeButton);

        add(titlePanel, BorderLayout.WEST); 
        add(buttonPanel, BorderLayout.EAST); 

        closeButton.addActionListener(e -> frame.dispose());

        minimizeButton.addActionListener(e -> {
            frame.setState(JFrame.ICONIFIED);
        });

        maximizeButton.addActionListener(e -> {
            if (isMaximized) {
                frame.setExtendedState(JFrame.NORMAL);
                frame.setLocation(previousLocation);
                frame.setSize(previousSize);
                isMaximized = false;
            } else {
                previousLocation = frame.getLocation();
                previousSize = frame.getSize();
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                isMaximized = true;
            }
        });

        frame.addWindowStateListener(e -> {
            if (e.getNewState() == JFrame.NORMAL && isMaximized) {
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point initialClick;

            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (!isMaximized) {
                    int x = frame.getLocation().x + e.getX() - initialClick.x;
                    int y = frame.getLocation().y + e.getY() - initialClick.y;
                    frame.setLocation(x, y);
                }
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
}
}