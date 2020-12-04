package Mancala;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.swing.Icon;

/**
 * Stone icon class that draws stone
 * @author davidwang
 *
 */
public class Stone implements Icon{	
MancalaModel model;
ArrayList<String> colorList;
Graphics2D g2;
Map<Integer,Color> colorMap;
Color color;

	/*
	 * Stone class initializes colors from corresponding strategy
	 */
	public Stone(MancalaModel model) {
		this.model = model;
		colorList = model.getColorList();
		colorMap = model.getColorMap();
		if (colorList.size() > 2) {
			int colorID = getRandomColor();
			color = colorMap.get(colorID);
		}
		else {
			color = Color.BLACK;
		}
		
	}
	
	/*
	 * paintIcon method that draws stones
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g2 = (Graphics2D) g;
		Ellipse2D stone = new Ellipse2D.Double(0, 0, 20, 20);
		g2.draw(stone);
		g2.setPaint(color);
		g2.fill(stone);

	}

	/*
	 * Random number generator that gets a random number from 1-7 for hashmap of colors
	 */
	public int getRandomColor() {
		Random rand = new Random();
		int randomNum = rand.nextInt(7) + 1;
		return randomNum;
	}
	
	/*
	 * Getter for stone icon width
	 */
	@Override
	public int getIconWidth() {
		return 20;
	}
	
	/*
	 * Getter for stone icon height
	 */
	@Override
	public int getIconHeight() {
		return 20;
	}

}
