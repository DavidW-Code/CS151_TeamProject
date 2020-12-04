package Mancala;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.Icon;

/**
 * StonePit icon class that draws stone pit that hold stones
 * @author davidwang
 *
 */
public class StonePit implements Icon{
private static final int DIAMETER = 115;
MancalaModel model;
ArrayList<String> colorList;
Graphics2D g2;
Color color;

	/*
	 * StonePit that initializes colors from strategy
	 */
	public StonePit(MancalaModel model, int colorNum) {
		this.model = model;
		colorList = model.getColorList();
		if (colorList.size() > 2) {
			color = new Color(Integer.parseInt(colorList.get(colorNum)));
		}
		else {
			color = new Color(Integer.parseInt(colorList.get(0)));
		}
		
	}
	
	/*
	 * paintIcon that draws stone pit
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(color);
		g2.drawOval(0, 0, DIAMETER, DIAMETER);
		
	}
	
	/*
	 * Getter that returns stone pit width
	 */
	public int getIconWidth() {
		return DIAMETER;
	}

	/*
	 * Getter that returns stone pit height
	 */
	public int getIconHeight() {
		return DIAMETER;
	}

}
