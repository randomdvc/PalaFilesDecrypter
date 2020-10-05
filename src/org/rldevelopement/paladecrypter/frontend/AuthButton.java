package org.rldevelopement.paladecrypter.frontend;


import javax.swing.*;
import java.awt.*;


public class AuthButton extends AbstractButton {


    private Color color;


    private Color colorHover;


    private Color colorDisabled;

    private JLabel text = new JLabel("S'IDENTIFIER");


    public AuthButton(Color color) {
        this(color, null, null);
    }


    public AuthButton(Color color, Color colorHover) {
        this(color, colorHover, null);
    }

    public AuthButton(Color color, Color colorHover, Color colorDisabled) {
        // If the color is null, throwing an Illegal Argument Exception, else setting it
        if(color == null)
            throw new IllegalArgumentException("Color == null");
        this.color = color;

        // If the color hover is null, creating it, else, setting it
        if(colorHover == null)
            this.colorHover = color.brighter();
        else
            this.colorHover = colorHover;

        // If the color disabled is null, creating it, else, setting it
        if(colorDisabled == null)
            this.colorDisabled = color.darker();
        else
            this.colorDisabled = colorDisabled;

        setLayout(null);

        text.setBackground(null);
        text.setBounds(175, 0, 245, 50);
        text.setForeground(Color.white);
        text.getFont().deriveFont(40);
        add(text);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color;
        if(!this.isEnabled())
            color = colorDisabled;
        else if (super.isSelected())
            color = colorHover;
        else
            color = this.color;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(color);
        g2.fillRoundRect(0, 0, 422, 50, 10, 10);

    }

    public void setColor(Color color) {
        // If the given color is null, throwing an Illegal Argument Exception, else setting it
        if(color == null)
            throw new IllegalArgumentException("Color == null");
        this.color = color;

        repaint();
    }

    public Color getColor() {
        return color;
    }

    public void setColorHover(Color colorHover) {
        // If the given hover color is null, throwing an Illegal Argument Exception, else setting it
        if(colorHover == null)
            throw new IllegalArgumentException("colorHover == null");
        this.colorHover = colorHover;

        repaint();
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorDisabled(Color colorDisabled) {
        // If the given disabled color is null, throwing an Illegal Argument Exception, else setting it
        if(colorDisabled == null)
            throw new IllegalArgumentException("colorDisabled == null");
        this.colorDisabled = colorDisabled;

        repaint();
    }

    public Color getColorDisabled() {
        return colorDisabled;
    }
}
