package Mancala;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * StyleFrame displayed after ButtonFrame and displays selection for board styles
 * @author davidwang
 *
 */
public class StyleFrame{
MancalaModel model;

	/*
	 * StyleFrame JFrame that contains buttons that can be clicked to determine board style
	 * After click, StyleFrame is disposed and MainFrame is opened
	 */
	public StyleFrame(MancalaModel model) {
		this.model = model;
		
		JFrame styleFrame = new JFrame();
		styleFrame.setLayout(new FlowLayout());
		
		JTextField initialText = new JTextField("Choose a board style");
		initialText.setEditable(false);
		
		JButton style1 = new JButton("Black/White");
		style1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setColor(new SetColorBlack());
				MainFrame mainFrame = new MainFrame(model);
				
				styleFrame.dispose();
			}
			
		});
		
		JButton style2 = new JButton("Rainbow");
		style2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setColor(new SetColorRainbow());
				MainFrame mainFrame = new MainFrame(model);
				
				styleFrame.dispose();
			}
			
		});
		
		styleFrame.add(initialText);
		styleFrame.add(style1);
		styleFrame.add(style2);
		
		styleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		styleFrame.pack();
		styleFrame.setVisible(true);
	}
}
