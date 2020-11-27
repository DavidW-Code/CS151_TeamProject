package Mancala;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerLabels extends JPanel{
JLabel PlayerID;
Font myFont = new Font("Serif", Font.BOLD, 20);

	public PlayerLabels() {
		setLayout(new BorderLayout());
		
		PlayerID = new JLabel("Player B", JLabel.CENTER);
		PlayerID.setFont(myFont);
		PlayerID.setPreferredSize(new Dimension(1000,25));
		add(PlayerID, BorderLayout.NORTH);

		PlayerID = new JLabel("Player A", JLabel.CENTER);
		PlayerID.setFont(myFont);
		PlayerID.setPreferredSize(new Dimension(1000,25));
		add(PlayerID, BorderLayout.SOUTH);
		
	}

}

