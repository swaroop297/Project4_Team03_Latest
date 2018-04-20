package client.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

/**
 * View Class to create the color selector buttons
 * 
 * @SER516 Project3_Team03
 * @version 1.0
 */
public class ColorSelectorButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Color current;
	private String name;

    public ColorSelectorButton(Color c, String name) {
        setSelectedColor(c); 
        setName(name);
        this.setText(name);
        addActionListener(new ActionListener() {
   
            public void actionPerformed(ActionEvent arg0) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
                setSelectedColor(newColor);
            }
        });
    }
    
    /**
     * Returns the selected color
     * @return contains the selected color
     */
    public Color getSelectedColor() {
        return current;
    }

    /**
     * Sets the color
     * @param newColor contains the new selected color
     */
    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }
    
    /**
     * Returns the name of the button
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the button
     */
    public void setName(String newName) {
    		name=newName;
    		
    }
    
    /**
     * Overloaded function to select the color
     * @param newColor contains the new selected color
     * @param notify Contains true or false based on change of color
     */
    public void setSelectedColor(Color newColor, boolean notify) {

        if (newColor == null) return;

        current = newColor;
        setIcon(createIcon(current,50, 50));
        repaint();

        if (notify) {
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
    }

    public static interface ColorChangedListener {
        public void colorChanged(Color newColor);
    }

    private List<ColorChangedListener> listeners = new ArrayList<ColorChangedListener>();

    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }
    
    /**
     * Adds the image of the color on the button
     * @param main Contains the color
     * @param width	Contains the width of the required image
     * @param height Contains the height of the required image
     * @return Contains the resultant icon
     */
    public static  ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width-1, height-1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}
