package Mancala;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stone implements Icon{

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D stone = new Ellipse2D.Double(0, 0, 20, 20);
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
