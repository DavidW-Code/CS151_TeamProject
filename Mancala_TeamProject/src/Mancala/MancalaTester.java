package Mancala;

public class MancalaTester {
MancalaModel model;
ButtonFrame initialButton;

	public MancalaTester() {
		model = new MancalaModel();
		initialButton = new ButtonFrame(model);
		
	}
	
	public static void main(String[] args) {
		MancalaTester test = new MancalaTester();
	}
	
}

