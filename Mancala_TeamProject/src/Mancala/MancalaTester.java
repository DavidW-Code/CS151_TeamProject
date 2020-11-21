package Mancala;

public class MancalaTester {
ButtonFrame initialButton;
MancalaModel model;
MainFrame mainFrame;

	public MancalaTester() {
		model = new MancalaModel();
		
		mainFrame = new MainFrame(model);
		initialButton = new ButtonFrame(model);
	}

	public static void main(String[] args) {
		MancalaTester test = new MancalaTester();
	}
}
