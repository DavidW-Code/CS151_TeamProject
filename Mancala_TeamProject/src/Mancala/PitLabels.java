package Mancala;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PitLabels extends JPanel{
JLabel pitID;
int xCoordB = 200;
int xCoordA = 200;
Font myFont = new Font("Serif", Font.BOLD, 20);
Stone stone;

	public PitLabels() {
		setLayout(null);
		
		for (int i = 6; i > 0; i--) {
			pitID = new JLabel("B" + i);
			pitID.setSize(40,20);
			pitID.setFont(myFont);
			
			if (i < 6) {
				xCoordB += 115;
				pitID.setBounds(xCoordB, 50, 40, 20);
			}
			else {
				pitID.setBounds(xCoordB, 50, 40, 20);
			}
			add(pitID);
		}
		
		for (int i = 1; i < 7; i++) {
			pitID = new JLabel("A" + i);
			pitID.setSize(40,20);
			pitID.setFont(myFont);
			
			if (i > 1) {
				xCoordA += 115;
				pitID.setBounds(xCoordA, 430, 40, 20);
			}
			else {
				pitID.setBounds(xCoordA, 430, 40, 20);
			}
			add(pitID);
		}
		
	}
	
}
