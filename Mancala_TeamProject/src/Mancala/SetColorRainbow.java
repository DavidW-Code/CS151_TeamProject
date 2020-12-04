package Mancala;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Strategy that dispalys board color as rainbow
 * @author davidwang
 *
 */
public class SetColorRainbow implements Strategy{
ArrayList<String> colorList = new ArrayList<>();

	@Override
	public ArrayList<String> getColor() {
		colorList.add(Integer.toString(Color.RED.getRGB()));
		colorList.add(Integer.toString(Color.ORANGE.getRGB()));
		colorList.add(Integer.toString(Color.YELLOW.getRGB()));
		colorList.add(Integer.toString(Color.GREEN.getRGB()));
		colorList.add(Integer.toString(Color.BLUE.getRGB()));
		colorList.add(Integer.toString(Color.MAGENTA.getRGB()));
		colorList.add(Integer.toString(Color.BLACK.getRGB()));
		return colorList;
	}

}
