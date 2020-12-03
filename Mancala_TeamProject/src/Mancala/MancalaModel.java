package Mancala;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MancalaModel {
ArrayList<ChangeListener> listenerList;
boolean PlayerATurn = true;
boolean endGame = false;

//ArrayList 0...5 = stones, 6 = pit
ArrayList<Integer> PlayerA;
ArrayList<Integer> PlayerB;

ArrayList<Integer> PlayerAOld;
ArrayList<Integer> PlayerBOld;
boolean oldPlayerATurn;
ArrayList<Boolean> playerTurnList;

Strategy strategy;
ArrayList<String> colorList;
HashMap<Integer,Color> colorMap;

	public MancalaModel() {
		listenerList = new ArrayList<>();
		PlayerA = new ArrayList<>();
		PlayerB = new ArrayList<>();
		PlayerAOld = new ArrayList<>();
		PlayerBOld = new ArrayList<>();
		playerTurnList = new ArrayList<>();
		colorList = new ArrayList<>();
		colorMap = new HashMap<>();
		putColorInMap();
	}
	
	public void setColor(Strategy strategy) {
		this.strategy = strategy;
		setColorList(strategy.getColor());
	}
	
	public ArrayList<String> getColorList(){
		return colorList;
	}
	
	public void setColorList(ArrayList<String> colorList) {
		this.colorList = (ArrayList<String>) colorList.clone();
	}
	
	public HashMap<Integer,Color> getColorMap(){
		return colorMap;
	}
	
	public void putColorInMap() {
		colorMap.put(1, Color.CYAN);
		colorMap.put(2, Color.BLUE);
		colorMap.put(3, Color.DARK_GRAY);
		colorMap.put(4, Color.RED);
		colorMap.put(5, Color.GREEN);
		colorMap.put(6, Color.MAGENTA);
		colorMap.put(7, Color.ORANGE);
	}
	
	//Adds initial 3/4 stones into ArrayList for Player A and Player B
	public void setInitialArray(int stones) {
		for (int i = 0; i < 6; i++) {
			PlayerA.add(stones);
			PlayerB.add(stones);
		}
		
		PlayerA.add(0);
		PlayerB.add(0);
		
		PlayerAOld = PlayerA;
		PlayerBOld = PlayerB;
		
	}
	
	//Get the Stones in PlayerA;
	public ArrayList<Integer> getPlayerAStones() {
		return PlayerA;
	}
	
	//Get the Stones in PlayerB;
	public ArrayList<Integer> getPlayerBStones() {
		return PlayerB;
	}
	
	//Returns boolean of if Player A's turn
	public boolean getPlayerATurn() {
		return PlayerATurn;
	}
	
	//Set the Stones in PlayerA;
	public void setPlayerAStones(ArrayList<Integer> newPlayerA) {
		this.PlayerA = (ArrayList<Integer>) newPlayerA.clone();
	}
		
	//Set the Stones in PlayerB;
	public void setPlayerBStones(ArrayList<Integer> newPlayerB) {
		this.PlayerB = (ArrayList<Integer>) newPlayerB.clone();
	}
	
	//Boolean check if it's Player A's turn
	public void setPlayerATurn(boolean PlayerATurn) {
		this.PlayerATurn = PlayerATurn;
	}
	
	public ArrayList<Integer> getOldPlayerA(){
		return PlayerAOld;
	}
	
	public ArrayList<Integer> getOldPlayerB(){
		return PlayerBOld;
	}
	
	public boolean getOldTurn() {
		return oldPlayerATurn;
	}
	
	public void setOldPlayerA(ArrayList<Integer> oldPlayerA) {
		this.PlayerAOld = (ArrayList<Integer>) oldPlayerA.clone();
	}
	
	public void setOldPlayerB(ArrayList<Integer> oldPlayerB) {
		this.PlayerBOld = (ArrayList<Integer>) oldPlayerB.clone();
	}
	
	public void setOldPlayerTurn(boolean oldTurn) {
		this.oldPlayerATurn = oldTurn;
	}
	
	public void addPlayerTurn(boolean playerTurn) {
		playerTurnList.add(playerTurn);
	}
	
	public ArrayList<Boolean> getPlayerTurnList(){
		return playerTurnList;
	}
	
	public void clearTurnList() {
		playerTurnList.clear();
	}
	
	//Boolean check to end game
	public boolean endGame() {
		return endGame;
	}
	
	//Boolean set to end game
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	//Attach Listeners for each View into ListenerList
	public void attach(ChangeListener c) {
		listenerList.add(c);
	}
	
	//Update method used to call stateChanged
	public void update(ArrayList<Integer> newPlayerA, ArrayList<Integer> newPlayerB, boolean newPlayerATurn) {
		setPlayerAStones(newPlayerA);
		setPlayerBStones(newPlayerB);
		setPlayerATurn(newPlayerATurn);
		for (ChangeListener l: listenerList) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
}

