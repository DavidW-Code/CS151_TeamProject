package Mancala;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MancalaBoardPanel is a JPanel holding the base layer of mancala board
 * @author davidwang
 *
 */
public class MancalaBoardPanel extends JPanel{
MancalaModel model;
MancalaPit mancalaPit;
StonePit stonePit;
JLabel stonePitLabel;

	
	/*
	 * MancalaBoardPanel contains JLabels that display mancala pit and stone pit
	 * GridBagLayout is used to organize pits into correct positons
	 */
	public MancalaBoardPanel (MancalaModel model) {
		this.model = model;
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		mancalaPit = new MancalaPit(model);
		JLabel mancalaPitB = new JLabel(mancalaPit);
		add(mancalaPitB,c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		for (int i = 0; i < 6; i++) {
			stonePit= new StonePit(model,i);
			stonePitLabel = new JLabel(stonePit);
			add(stonePitLabel,c);
			c.gridx++;
		}
		
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		for (int i = 0; i < 6; i++) {
			stonePit= new StonePit(model,i);
			stonePitLabel = new JLabel(stonePit);
			add(stonePitLabel,c);
			c.gridx++;
		}
		
		c.gridx = 7;
		c.gridy = 0;
		c.gridheight = 2;
		mancalaPit = new MancalaPit(model);
		JLabel mancalaPitA = new JLabel(mancalaPit);
		add(mancalaPitA,c);
		
	}
}
