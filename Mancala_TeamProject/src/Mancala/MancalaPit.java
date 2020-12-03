package Mancala;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.Icon;

public class MancalaPit implements Icon{
private static final int PIT_WIDTH = 150;
private static final int PIT_HEIGHT = 350;
MancalaModel model;
ArrayList<String> colorList;
Graphics2D g2;
Color color;

	public MancalaPit(MancalaModel model) {
		this.model = model;
		colorList = model.getColorList();
		if (colorList.size() > 2) {
			color = Color.LIGHT_GRAY;
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
		g2.drawRoundRect(0, 0, PIT_WIDTH, PIT_HEIGHT, 50, 50);
		
	}

	
	public int getIconWidth() {
		return PIT_WIDTH;
	}
	
	public int getIconHeight() {
		return PIT_HEIGHT;
	}
	
	
}

