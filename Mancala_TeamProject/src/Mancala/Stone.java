package Mancala;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;

public class Stone implements Icon{

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D stone = new Ellipse2D.Double(100,20,100,100);
		g2.draw(stone);
		g2.setPaint(Color.BLACK);
		g2.fill(stone);
		
	}

	@Override
	public int getIconWidth() {
		return 20;
	}

	@Override
	public int getIconHeight() {
		return 20;
	}

}
