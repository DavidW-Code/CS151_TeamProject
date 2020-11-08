package Mancala;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MancalaBoardPanel extends JPanel{
MancalaModel model;
MancalaPit mancalaPit;
StonePit stonePit;
JLabel stonePitLabel;
ArrayList<StonePit> stonePitList;
ArrayList<MancalaPit> mancalaPitList;

	public MancalaBoardPanel(MancalaModel model) {
		this.model = model;
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		mancalaPit = new MancalaPit();
		JLabel mancalaPit1 = new JLabel(mancalaPit);
		add(mancalaPit1,c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		for (int i = 0; i < 6; i++) {
			stonePit= new StonePit();
			stonePitLabel = new JLabel(stonePit);
			add(stonePitLabel,c);
			c.gridx++;
		}
		
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		for (int i = 0; i < 6; i++) {
			stonePit= new StonePit();
			stonePitLabel = new JLabel(stonePit);
			add(stonePitLabel,c);
			c.gridx++;
		}
		
		c.gridx = 7;
		c.gridy = 0;
		c.gridheight = 2;
		mancalaPit = new MancalaPit();
		JLabel mancalaPit2 = new JLabel(mancalaPit);
		add(mancalaPit2,c);
	}
	
}
