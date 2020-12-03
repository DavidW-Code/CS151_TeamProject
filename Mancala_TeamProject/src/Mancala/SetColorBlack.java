package Mancala;

import java.awt.Color;
import java.util.ArrayList;

public class SetColorBlack implements Strategy{
ArrayList<String> colorList = new ArrayList<>();
	
	@Override
	public ArrayList<String> getColor() {
		colorList.add(Integer.toString(Color.BLACK.getRGB()));
		return colorList;
	}

}
