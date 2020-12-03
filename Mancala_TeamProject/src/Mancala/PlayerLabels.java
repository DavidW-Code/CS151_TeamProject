package Mancala;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlayerLabels extends JPanel implements ChangeListener{
JLabel PlayerID;
JLabel mancalaCount;
Font myFont = new Font("Serif", Font.BOLD, 20);
MancalaModel model;
boolean PlayerATurn;
boolean clickOnce = false;
ArrayList<Integer> PlayerA;
ArrayList<Integer> PlayerB;
ArrayList<JLabel> mancalaCountLabels;

	public PlayerLabels(MancalaModel model) {
		this.model = model;
		this.PlayerA = model.getPlayerAStones();
		this.PlayerB = model.getPlayerBStones();
		this.PlayerATurn = model.getPlayerATurn();
		
		mancalaCountLabels = new ArrayList<>();
		
		setLayout(new BorderLayout());
		
		JPanel topDisplay = new JPanel();
		topDisplay.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		PlayerID = new JLabel("Player B", JLabel.CENTER);
		PlayerID.setFont(myFont);
		PlayerID.setPreferredSize(new Dimension(1000,25));
		topDisplay.add(PlayerID,c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!clickOnce) {
					model.update(model.getOldPlayerA(), model.getOldPlayerB(), model.getOldTurn());
					clickOnce = true;
				}
			}
		});
		topDisplay.add(undoButton,c);
		add(topDisplay, BorderLayout.PAGE_START);
		
		mancalaCount = new JLabel("B Stones: " + PlayerB.get(6), JLabel.CENTER);
		mancalaCount.setFont(myFont);
		mancalaCount.setPreferredSize(new Dimension(150,450));
		add(mancalaCount, BorderLayout.LINE_START);
		mancalaCountLabels.add(mancalaCount);
		
		PlayerID = new JLabel("Player A Starts", JLabel.CENTER);
		PlayerID.setFont(myFont);
		PlayerID.setPreferredSize(new Dimension(700,450));
		add(PlayerID, BorderLayout.CENTER);
		mancalaCountLabels.add(PlayerID);
		
		mancalaCount = new JLabel("A Stones: " + PlayerA.get(6), JLabel.CENTER);
		mancalaCount.setFont(myFont);
		mancalaCount.setPreferredSize(new Dimension(150,450));
		add(mancalaCount, BorderLayout.LINE_END);
		mancalaCountLabels.add(mancalaCount);
		
		PlayerID = new JLabel("Player A", JLabel.CENTER);
		PlayerID.setFont(myFont);
		PlayerID.setPreferredSize(new Dimension(1000,25));
		add(PlayerID, BorderLayout.PAGE_END);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.PlayerA = model.getPlayerAStones();
		this.PlayerB = model.getPlayerBStones();
		this.PlayerATurn = model.getPlayerATurn();
		this.clickOnce = false;
		
		//Count player stones
		mancalaCountLabels.get(0).setText("B Stones: " + PlayerB.get(6));
		mancalaCountLabels.get(2).setText("A Stones: " + PlayerA.get(6));
		
		//Alternating turn conditons
		if (model.endGame()) {
			mancalaCountLabels.get(1).setText("GAME OVER");
		}
		else {
			if (PlayerATurn) {
				mancalaCountLabels.get(1).setText("Player A's Turn");
			}
			else {
				mancalaCountLabels.get(1).setText("Player B's Turn");
			}
		}
	}
}

