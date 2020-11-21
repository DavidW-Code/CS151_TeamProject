package Mancala;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class StonePanel extends JPanel{
MancalaModel model;
JLayeredPane layeredPane;
Stone stone;
JLabel stoneLabel;
ArrayList<Stone> stonesList;
ArrayList<JLabel> stoneLabelsList;

	public StonePanel(MancalaModel model) {
		this.model = model;
		int numOfStones = 3; //For testing, needs to change
		setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();

		constraint.gridx = 0; //Relative to this panel not the mancala panel
		constraint.gridy = 0;
		constraint.ipady = 50;
		constraint.ipadx = 100;
		constraint.gridheight = 1;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < numOfStones; j++){
				stone = new Stone();
				stoneLabel = new JLabel(stone);
				add(stoneLabel, constraint);
			}	
			constraint.gridx++;
		}	

		constraint.gridx = 0; //Relative to this panel not the mancala panel
		constraint.gridy = 1;
		constraint.ipady = 50;
		constraint.ipadx = 150;
		constraint.gridheight = 1;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < numOfStones; j++){
				stone = new Stone();
				stoneLabel = new JLabel(stone);
				add(stoneLabel, constraint);
			}	
			constraint.gridx++;
		}	
	}

	public static void main(String[] args) {
		JFrame pan = new JFrame();
		MancalaModel mod = new MancalaModel();
		StonePanel s = new StonePanel(mod);
		pan.add(s);
		pan.setBounds(0,0,1000,500);
		pan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan.setVisible(true);
	}


}