package Mancala;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButtonFrame {

	public ButtonFrame() {
		JFrame buttonFrame = new JFrame();
		buttonFrame.setLayout(new FlowLayout());
		
		JTextField initialText = new JTextField("Pick Initial Stones");
		initialText.setEditable(false);
		
		JButton Button3 = new JButton("3");
		JButton Button4 = new JButton("4");
		
		buttonFrame.add(initialText);
		buttonFrame.add(Button3);
		buttonFrame.add(Button4);

		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.pack();
		buttonFrame.setVisible(true);
	}
}
