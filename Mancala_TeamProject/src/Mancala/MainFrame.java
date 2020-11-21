package Mancala;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame{
MancalaBoardPanel mancalaPanel;
JLayeredPane pane;
StonePanel stonePanel;
MancalaModel model;

	public MainFrame(MancalaModel model) {
		this.model = model;
		mancalaPanel = new MancalaBoardPanel(model);
		mancalaPanel.setBounds(0, 0, 1000, 500);
		stonePanel = new StonePanel(model);
		stonePanel.setBounds(0,0,1000,500);
		stonePanel.setOpaque(false);

		pane = new JLayeredPane();
		pane.add(mancalaPanel,1);
		pane.add(stonePanel,0);
		
		
		class Controller implements ChangeListener{
			ArrayList<Integer> playerA = model.getPlayerAStones();
			ArrayList<Integer> playerB = model.getPlayerBStones();
			ArrayList<Stone> topStones;
			ArrayList<Stone> bottomStones;
			int numOfStones = 0;
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				for(int i =0; i < playerA.size(); i++) {//For each player
					numOfStones = playerA.get(i); //Since each stone pit might have different number of stones
					for(int j = 0; j< numOfStones; j++) { //In each stone pit 
						Stone stone = new Stone();
						topStones.add(stone);
					}
				}
				
				for(int i =0; i < playerB.size(); i++) { 
					numOfStones = playerA.get(i); 
					for(int j = 0; j< numOfStones; j++) {
						Stone stone = new Stone();
						topStones.add(stone);	
					}
					
				}
			}
			
		}
		Controller controller = new Controller();
		model.attach(controller);


		add(pane);
		setBounds(0,0,1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
