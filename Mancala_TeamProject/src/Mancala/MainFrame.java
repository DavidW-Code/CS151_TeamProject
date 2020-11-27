package Mancala;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class MainFrame extends JFrame{
MancalaModel model;
MancalaBoardPanel mancalaPanel;
PlayerLabels PLabels;
StonePanel stonePanel;

	public MainFrame(MancalaModel model) {
		this.model = model;
		
		mancalaPanel = new MancalaBoardPanel();
		mancalaPanel.setBounds(0, 0, 1000, 500);
		PLabels = new PlayerLabels();
		PLabels.setBounds(0, 0, 1000, 475);
		PLabels.setOpaque(false);
		stonePanel = new StonePanel(model);
		model.attach(stonePanel);
		stonePanel.setBounds(0, 0, 1000, 500);
		stonePanel.setOpaque(false);
		
		JLayeredPane pane = new JLayeredPane();
		pane.add(mancalaPanel, JLayeredPane.DEFAULT_LAYER);
		pane.add(PLabels, JLayeredPane.PALETTE_LAYER);
		pane.add(stonePanel, JLayeredPane.MODAL_LAYER);
		
		add(pane);
		setBounds(0,0,1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}

