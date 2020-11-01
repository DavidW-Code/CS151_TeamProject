package Mancala;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		Button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JButton Button4 = new JButton("4");
		Button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		buttonFrame.add(initialText);
		buttonFrame.add(Button3);
		buttonFrame.add(Button4);

		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.pack();
		buttonFrame.setVisible(true);
	}
}
