package Mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class StonePit implements Icon{
	private static final int DIAMETER = 100;
	
	public StonePit() {
		
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawOval(0, 0, DIAMETER, DIAMETER);
		
	}

	
	public int getIconWidth() {
		return DIAMETER;
	}

	
	public int getIconHeight() {
		return DIAMETER;
	}

}
