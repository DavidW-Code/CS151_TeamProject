package Mancala;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StonePanel extends JPanel{
MancalaModel model;
Stone stone;
JLabel stoneLabel;

	public StonePanel(MancalaModel model) {
		this.model = model;
		
		//setLayout Probably grid bag
		
		stone = new Stone();
		stoneLabel = new JLabel(stone);
		add(stoneLabel);
	}
}
