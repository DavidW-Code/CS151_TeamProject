package Mancala;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel {
ArrayList<ChangeListener> listenerList;

//ArrayList 0...5 = stones, 6 = pit
ArrayList<Integer> PlayerA;
ArrayList<Integer> PlayerB;


	public MancalaModel() {
		listenerList = new ArrayList<>();
		PlayerA = new ArrayList<>();
		PlayerB = new ArrayList<>();
	}
	
	//Adds initial 3/4 stones into ArrayList for Player A and Player B
	public void setInitialArray(int stones) {
		for (int i = 0; i < 6; i++) {
			PlayerA.add(stones);
			PlayerB.add(stones);
		}
	}
	
	//Get the Stones in PlayerA;
	public ArrayList<Integer> getPlayerAStones() {
		return PlayerA;
	}
	
	//Get the Stones in PlayerB;
	public ArrayList<Integer> getPlayerBStones() {
		return PlayerB;
	}
	
	//Set the Stones in PlayerA;
	public void setPlayerAStones(ArrayList<Integer> newPlayerA) {
		this.PlayerA = (ArrayList<Integer>) newPlayerA.clone();
	}
		
	//Set the Stones in PlayerB;
	public void setPlayerBStones(ArrayList<Integer> newPlayerB) {
		this.PlayerB = (ArrayList<Integer>) newPlayerB.clone();
	}
	
	//Attach Listeners for each View into ListenerList
	public void attach(ChangeListener c) {
		listenerList.add(c);
	}
	
	//Update method used to call stateChanged
	public void update() {
		
		for (ChangeListener l: listenerList) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
}

