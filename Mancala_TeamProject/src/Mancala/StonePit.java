package Mancala;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.Icon;

public class StonePit implements Icon{
private static final int DIAMETER = 115;
MancalaModel model;
ArrayList<String> colorList;
Graphics2D g2;
Color color;

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
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(color);
		g2.drawOval(0, 0, DIAMETER, DIAMETER);
		
	}
	
	public int getIconWidth() {
		return DIAMETER;
	}

	public int getIconHeight() {
		return DIAMETER;
	}

}
