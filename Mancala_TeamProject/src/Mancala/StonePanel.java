package Mancala;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StonePanel extends JPanel implements ChangeListener{
MancalaModel model;
Stone stone;
ArrayList<Integer> PlayerA;
ArrayList<Integer> PlayerB;
ArrayList<JLabel> stoneLabelA;
ArrayList<JLabel> stoneLabelB;

	public StonePanel(MancalaModel model) {
		this.model = model;
		this.PlayerA = model.getPlayerAStones();
		this.PlayerB = model.getPlayerBStones();
		stoneLabelA = new ArrayList<>();
		stoneLabelB = new ArrayList<>();
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		JLabel mancalaLabelA = new JLabel();
		mancalaLabelA.setPreferredSize(new Dimension(150,350));
		add(mancalaLabelA, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		for (int i = 0; i < 6; i++) {
			JLabel stonePitALabel = new JLabel();
			stonePitALabel.setPreferredSize(new Dimension (115,115));
			stonePitALabel.setLayout(new FlowLayout());
			for (int j = 0; j< PlayerA.get(i); j++) {
				stone = new Stone();
				JLabel stoneLabel = new JLabel(stone);
				stonePitALabel.add(stoneLabel);
			}
			add(stonePitALabel, c);
			stoneLabelA.add(stonePitALabel);
			c.gridx++;
		}
		
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		for (int i = 0; i < 6; i++) {
			JLabel stonePitBLabel = new JLabel();
			stonePitBLabel.setPreferredSize(new Dimension (115,115));
			stonePitBLabel.setLayout(new FlowLayout());
			for (int j = 0; j < PlayerB.get(i); j++) {
				stone = new Stone();
				JLabel stoneLabel = new JLabel(stone);
				stonePitBLabel.add(stoneLabel);
			}
			add(stonePitBLabel, c);
			stoneLabelB.add(stonePitBLabel);
			c.gridx++;
		}
		
		c.gridx = 7;
		c.gridy = 0;
		c.gridheight = 2;
		JLabel mancalaLabelB = new JLabel();
		mancalaLabelB.setPreferredSize(new Dimension(150,350));
		add(mancalaLabelB, c);
	}

	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

}
