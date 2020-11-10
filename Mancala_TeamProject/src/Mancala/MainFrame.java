package Mancala;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
MancalaBoardPanel mancalaPanel;
StonePanel stonePanel;
MancalaModel model;

	public MainFrame(MancalaModel model) {
		this.model = model;
		mancalaPanel = new MancalaBoardPanel(model);
		//stonePanel = new StonePanel(model);

		add(mancalaPanel);
		//add(stonePanel);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
}
