package Mancala;

public class MancalaTester {
ButtonFrame initialButton;
MancalaModel model;
MainFrame mainFrame;

	public MancalaTester() {
		model = new MancalaModel();
		
		initialButton = new ButtonFrame(model);
		mainFrame = new MainFrame(model);
	}

	public static void main(String[] args) {
		MancalaTester test = new MancalaTester();
	}
}
