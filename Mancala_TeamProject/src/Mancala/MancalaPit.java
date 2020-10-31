package Mancala;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class MancalaPit implements Icon{
private static final int PIT_WIDTH = 150;
private static final int PIT_HEIGHT = 300;

private int xPosition;
private int yPosition;

	public MancalaPit(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawRoundRect(xPosition, yPosition, PIT_WIDTH, PIT_HEIGHT, 50, 50);
		
	}

	public int getIconWidth() {
		return PIT_WIDTH;
	}

	public int getIconHeight() {
		return PIT_HEIGHT;
	}
	
	
}
