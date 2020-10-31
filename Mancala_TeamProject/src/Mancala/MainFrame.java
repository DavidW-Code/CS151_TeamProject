package Mancala;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame {
MancalaPit pit;

	public MainFrame() {
		JFrame mainFrame = new JFrame();
		mainFrame.setLayout(new FlowLayout());
		
		//ArrayList for Player A Test
		ArrayList<Integer> playerA = new ArrayList<>();
		int i = 0;
		int ball = 1;
		while (i < 6) {
			playerA.add(ball);
			i++;
		}
		
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame test = new MainFrame();
	}
}
