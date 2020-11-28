package Mancala;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndGameFrame extends JFrame{
MancalaModel model;
JLabel stoneCount;
int totalA;
int totalB;
ArrayList<Integer> PlayerA;
ArrayList<Integer> PlayerB;

	public EndGameFrame(MancalaModel model) {
		this.model = model;
		this.PlayerA = model.getPlayerAStones();
		this.PlayerB = model.getPlayerBStones();
		this.totalA = PlayerA.get(6);
		this.totalB = PlayerB.get(6);
		
		setLayout(new GridLayout(0,1));
		stoneCount = new JLabel("Player A Total Stones: " + totalA);
		stoneCount.setPreferredSize(new Dimension(200,50));
		add(stoneCount);
		stoneCount = new JLabel("Player B Total Stones: " + totalB);
		stoneCount.setPreferredSize(new Dimension(200,50));
		add(stoneCount);
		
		if (totalA > totalB) {
			stoneCount = new JLabel("The Winner is Player A");
			stoneCount.setPreferredSize(new Dimension(200,50));
			add(stoneCount);
		}
		else if (totalB > totalA) {
			stoneCount = new JLabel("The Winner is Player B");
			stoneCount.setPreferredSize(new Dimension(200,50));
			add(stoneCount);
		}
		else {
			stoneCount = new JLabel("It is a Tie");
			stoneCount.setPreferredSize(new Dimension(200,50));
			add(stoneCount);
		}

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
