package Mancala;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * MnacalaModel is model and controller class for mancala game
 * @author davidwang
 *
 */
public class MancalaModel {
ArrayList<ChangeListener> listenerList;		//ChangeListener list used to call in update() method
boolean PlayerATurn = true;					//Boolean check of player turns, true if it is A turn, false if it is B turn
boolean endGame = false;					//Boolean check to end game

ArrayList<Integer> PlayerA;					//ArrayList 0...5 = stones, 6 = pit
ArrayList<Integer> PlayerB;					//Holds current turn information

ArrayList<Integer> PlayerAOld;				//ArrayList 0...5 = stones, 6 = pit
ArrayList<Integer> PlayerBOld;				//Holds previous turn information
boolean oldPlayerATurn;
ArrayList<Boolean> playerTurnList;			//Arraylist of player turns

Strategy strategy;
ArrayList<String> colorList;				//Arraylisf of colors from strategy implemented
HashMap<Integer,Color> colorMap;			//Hashmap of stone colors

	/*
	 * MancalaModel intializes all relevant information that is shared across components that implement change listener
	 */
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
	
	/*
	 * Takes a strategy interface and implements its' getColor method to determine board design
	 */
	public void setColor(Strategy strategy) {
		this.strategy = strategy;
		setColorList(strategy.getColor());
	}
	
	/*
	 * Get the colors associated with strategy interface
	 */
	public ArrayList<String> getColorList(){
		return colorList;
	}
	
	/*
	 * Method that assigns color design from strategy into arraylist of color strings
	 */
	public void setColorList(ArrayList<String> colorList) {
		this.colorList = (ArrayList<String>) colorList.clone();
	}
	
	/*
	 * Returns a hashmap that contains colors and their corresponding ID
	 */
	public HashMap<Integer,Color> getColorMap(){
		return colorMap;
	}
	
	/*
	 * Insert into hashmap random colors for stones
	 */
	public void putColorInMap() {
		colorMap.put(1, Color.CYAN);
		colorMap.put(2, Color.BLUE);
		colorMap.put(3, Color.DARK_GRAY);
		colorMap.put(4, Color.RED);
		colorMap.put(5, Color.GREEN);
		colorMap.put(6, Color.MAGENTA);
		colorMap.put(7, Color.ORANGE);
	}
	
	/*
	 * Adds initial 3/4 stones into ArrayList for Player A and Player B
	 */
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
	
	/*
	 * Get the Stones in PlayerA
	 */
	public ArrayList<Integer> getPlayerAStones() {
		return PlayerA;
	}
	
	/*
	 * Get the Stones in PlayerB
	 */
	public ArrayList<Integer> getPlayerBStones() {
		return PlayerB;
	}
	
	/*
	 * Returns boolean of if Player A's turn
	 */
	public boolean getPlayerATurn() {
		return PlayerATurn;
	}
	
	/*
	 * Set the Stones in PlayerA
	 */
	public void setPlayerAStones(ArrayList<Integer> newPlayerA) {
		this.PlayerA = (ArrayList<Integer>) newPlayerA.clone();
	}
		
	/*
	 * Set the Stones in PlayerB
	 */
	public void setPlayerBStones(ArrayList<Integer> newPlayerB) {
		this.PlayerB = (ArrayList<Integer>) newPlayerB.clone();
	}
	
	/*
	 * Boolean check if it's Player A's turn
	 */
	public void setPlayerATurn(boolean PlayerATurn) {
		this.PlayerATurn = PlayerATurn;
	}
	
	/*
	 * Get arraylist of integers of previous turn's PlayerA stones
	 */
	public ArrayList<Integer> getOldPlayerA(){
		return PlayerAOld;
	}
	
	/*
	 * Get arraylist of integers of previous turn's PlayerB stones
	 */
	public ArrayList<Integer> getOldPlayerB(){
		return PlayerBOld;
	}
	
	/*
	 * Get boolean of who's turn was it previously
	 */
	public boolean getOldTurn() {
		return oldPlayerATurn;
	}
	
	/*
	 * Setter method that assigns stone count to PlayerAOld arraylist
	 */
	public void setOldPlayerA(ArrayList<Integer> oldPlayerA) {
		this.PlayerAOld = (ArrayList<Integer>) oldPlayerA.clone();
	}

	/*
	 * Setter method that assigns stone count to PlayerBOld arraylist
	 */
	public void setOldPlayerB(ArrayList<Integer> oldPlayerB) {
		this.PlayerBOld = (ArrayList<Integer>) oldPlayerB.clone();
	}
	
	/*
	 * Setter method that sets previous turn to oldPlayerATurn
	 */
	public void setOldPlayerTurn(boolean oldTurn) {
		this.oldPlayerATurn = oldTurn;
	}
	
	/*
	 * Adds boolean of which player turn it is into arraylist
	 */
	public void addPlayerTurn(boolean playerTurn) {
		playerTurnList.add(playerTurn);
	}
	
	/*
	 * Returns arraylist of booleans that checks the number of times a player has gone consecutively 
	 */
	public ArrayList<Boolean> getPlayerTurnList(){
		return playerTurnList;
	}
	
	/*
	 * Clears boolean arraylist of player turns
	 */
	public void clearTurnList() {
		playerTurnList.clear();
	}
	
	/*
	 * Boolean check to end game
	 */
	public boolean endGame() {
		return endGame;
	}
	
	/*
	 * Boolean set to end game
	 */
	public void setEndGame(boolean endGame) {
		this.endGame = endGame;
	}
	/*
	 * Attach Listeners for each View into ListenerList
	 */
	public void attach(ChangeListener c) {
		listenerList.add(c);
	}
	
	/*
	 * Update method used to call stateChanged
	 */
	public void update(ArrayList<Integer> newPlayerA, ArrayList<Integer> newPlayerB, boolean newPlayerATurn) {
		setPlayerAStones(newPlayerA);
		setPlayerBStones(newPlayerB);
		setPlayerATurn(newPlayerATurn);
		for (ChangeListener l: listenerList) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
}

