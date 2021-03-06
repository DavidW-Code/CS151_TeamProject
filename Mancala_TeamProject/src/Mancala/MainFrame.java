package Mancala;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * MainFrame initalizes and displays all relevant components of the mancala board
 * @author davidwang
 *
 */
public class MainFrame extends JFrame{
MancalaModel model;
MancalaBoardPanel mancalaPanel;
PlayerLabels PLabels;
PitLabels pitLabel;
StonePanel stonePanel;

	/*
	 * MainFrame is made up on 4 layers on top of each other
	 * mancalaPanel is lowest layer that displays the board
	 * pLabels is on top of mancalaPanel and displays player information
	 * pitLabels is on top of pLabels and displays pit count
	 * stonePanel is top most layer and displays stones
	 */
	public MainFrame(MancalaModel model) {
		this.model = model;
		
		mancalaPanel = new MancalaBoardPanel(model);
		mancalaPanel.setBounds(0, 0, 1000, 500);
		PLabels = new PlayerLabels(model);
		model.attach(PLabels);
		PLabels.setBounds(0, 0, 1000, 500);
		PLabels.setOpaque(false);
		stonePanel = new StonePanel(model);
		model.attach(stonePanel);
		pitLabel = new PitLabels();
		pitLabel.setBounds(0, 0, 1000, 500);
		pitLabel.setOpaque(false);
		stonePanel.setBounds(0, 0, 1000, 500);
		stonePanel.setOpaque(false);
		
		JLayeredPane pane = new JLayeredPane();
		pane.add(mancalaPanel, JLayeredPane.DEFAULT_LAYER);
		pane.add(PLabels, JLayeredPane.PALETTE_LAYER);
		pane.add(pitLabel, JLayeredPane.MODAL_LAYER);
		pane.add(stonePanel, JLayeredPane.POPUP_LAYER);
		
		add(pane);
		setBounds(0,0,1000,520);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}

