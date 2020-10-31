package Mancala;

import javax.swing.JFrame;

public class MainFrame {
MancalaBoardPanel test;

	public MainFrame() {
		JFrame mainFrame = new JFrame();
		
		
		test = new MancalaBoardPanel();
		
		mainFrame.add(test);
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame test = new MainFrame();
	}
}
