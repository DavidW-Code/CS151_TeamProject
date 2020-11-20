package Mancala;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StonePanel extends JPanel{
MancalaModel model;
Stone stone;
JLabel stoneLabel;


	public StonePanel(MancalaModel model) {
		this.model = model;
		int numOfStones = 3; //For testing, needs to change
		//setLayout Probably grid bag
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
		constraint.gridx = 1; //Relative to this panel not the mancala panel
		constraint.gridy = 1;
		for(int i = 0; i< numOfStones; i++ ) {
			stone = new Stone();
			stoneLabel = new JLabel(stone);
			add(stoneLabel, constraint);
			constraint.gridx++;
		}
		
	}
}
