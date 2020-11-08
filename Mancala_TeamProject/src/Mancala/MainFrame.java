package Mancala;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
MancalaBoardPanel mancalaPanel;
MancalaModel model;

	public MainFrame(MancalaModel model) {
		this.model = model;
		mancalaPanel = new MancalaBoardPanel(model);
		
		add(mancalaPanel);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
}
