package Mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class StonePit implements Icon{
private int diameter;
	
	public StonePit(int diameter) {
		this.diameter = diameter;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawOval(0, 0, diameter, diameter);
		
	}

	
	public int getIconWidth() {
		return diameter;
	}

	
	public int getIconHeight() {
		return diameter;
	}

}
