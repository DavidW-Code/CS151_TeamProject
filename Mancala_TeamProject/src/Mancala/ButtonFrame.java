package Mancala;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * ButtonFrame initalizes and displays first screen selection to determine how many stones in initial mancala board
 * @author davidwang
 *
 */
public class ButtonFrame {
MancalaModel model;

	/*
	 * ButtonFrame JFrame that contains buttons that can be clicked to determine initial stone count
	 * After click, ButtonFrame is disposed and StyleFrame is opened
	 */
	public ButtonFrame(MancalaModel model) {
		this.model = model;
		JFrame buttonFrame = new JFrame();
		buttonFrame.setLayout(new FlowLayout());
		
		JTextField initialText = new JTextField("Pick Initial Stones");
		initialText.setEditable(false);
		
		JButton Button3 = new JButton("3");
		Button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setInitialArray(3);
				StyleFrame styleFrame = new StyleFrame(model);
				
				buttonFrame.dispose();
				
			}
			
		});
		JButton Button4 = new JButton("4");
		Button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setInitialArray(4);
				
				StyleFrame styleFrame = new StyleFrame(model);
				
				buttonFrame.dispose();
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

