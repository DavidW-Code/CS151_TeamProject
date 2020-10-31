package Mancala;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MancalaBoardPanel extends JPanel{

	public MancalaBoardPanel() {
		
		setPreferredSize(new Dimension(1000,500));

		
		//Not final layout
		setLayout(new FlowLayout());
		
		//Testing mancala pit A and B
		MancalaPit pit = new MancalaPit(0,0);
		JLabel label = new JLabel(pit);
		label.setPreferredSize(new Dimension(pit.getIconWidth() + 10,pit.getIconHeight() + 10));
		
		StonePit test = new StonePit(100);
		JLabel testPit = new JLabel(test);
		testPit.setPreferredSize(new Dimension(pit.getIconWidth() + 10,pit.getIconHeight() + 10));
		
		MancalaPit pit2 = new MancalaPit(0,0);
		JLabel label2 = new JLabel(pit2);
		label2.setPreferredSize(new Dimension(pit2.getIconWidth() + 10,pit2.getIconHeight() + 10));
		
		add(label);
		add(testPit);
		add(label2);
		
	}
	
}
