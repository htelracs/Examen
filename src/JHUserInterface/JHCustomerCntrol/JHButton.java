package JHUserInterface.JHCustomerCntrol;

import javax.swing.JButton;

import JHUserInterface.JHEstilo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JHButton extends JButton implements MouseListener {
    private boolean isRound;
    private Color hoverBackgroundColor = new Color(128, 128, 128, 128); 
    private boolean isHovering = false; 
    private Color originalForegroundColor; 

    public JHButton(String text, boolean isRound, Font customFont) {
        this.isRound = isRound;
        customizeComponent(text, customFont);
        

    }

    private void customizeComponent(String text, Font customFont) {
        setText(text);
        setFont(customFont); 
        originalForegroundColor = Color.BLACK; 
        setForeground(originalForegroundColor);
        setOpaque(false); 
        setFocusPainted(false);
        setBorderPainted(false); 
        setContentAreaFilled(false); 
        setCursor(JHEstilo.CURSOR_HAND);
        addMouseListener(this);

        if (isRound) {
            setPreferredSize(new Dimension(30, 30)); 
        } else {
            setPreferredSize(new Dimension(80, 40)); 
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       
        g2.setColor(getBackground()); 
        if (isRound) {
            g2.fillOval(0, 0, getWidth(), getHeight());
        } else {
            g2.fillRect(0, 0, getWidth(), getHeight());
        }

    
        if (isHovering) {
            g2.setColor(hoverBackgroundColor);
            if (isRound) {
                g2.fillOval(0, 0, getWidth(), getHeight());
            } else {
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        }

        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - fm.getDescent();
        g2.setColor(getForeground());
        g2.drawString(getText(), x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isHovering = true; 
        setForeground(Color.BLACK); 
        repaint(); 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isHovering = false; 
        setForeground(originalForegroundColor);
        repaint(); 
    }
}
