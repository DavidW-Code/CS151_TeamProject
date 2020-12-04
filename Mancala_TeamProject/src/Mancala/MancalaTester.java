package Mancala;

/**
 * MancalaTester class that runs the mancala game program
 * @author davidwang
 *
 */
public class MancalaTester {
MancalaModel model;
ButtonFrame initialButton;
	
	/*
	 * Initialize model class and runs the first frame
	 */
	public MancalaTester() {
		model = new MancalaModel();
		initialButton = new ButtonFrame(model);
		
	}
	
	public static void main(String[] args) {
		MancalaTester test = new MancalaTester();
	}
	
}

