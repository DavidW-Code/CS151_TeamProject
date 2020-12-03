package Mancala;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StonePanel extends JPanel implements ChangeListener{
MancalaModel model;
Stone stone;
boolean pressed;
boolean PlayerATurn = true;
int lastIndex;
int xCoordB = 155;
int yCoordB = 95;
int xCoordA = 155;
int yCoordA = 325;
int space = 115;

ArrayList<Integer> PlayerA;
ArrayList<Integer> PlayerB;
ArrayList<JLabel> stoneLabelA;
ArrayList<JLabel> stoneLabelB;

	public StonePanel(MancalaModel model) {
		this.model = model;
		this.PlayerA = model.getPlayerAStones();
		this.PlayerB = model.getPlayerBStones();
		stoneLabelA = new ArrayList<>();
		stoneLabelB = new ArrayList<>();
		
		setLayout(null);
		
		JLabel mancalaLabelB = new JLabel();
		mancalaLabelB.setLayout(new FlowLayout());
		mancalaLabelB.setPreferredSize(new Dimension(150,350));
		mancalaLabelB.setBounds(5, 100, 150, 350);
		add(mancalaLabelB);
		
		
		for (int i = 0; i < 6; i++) {
			JLabel stonePitBLabel = new JLabel();
			
			stonePitBLabel.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e) {
					pressed = true;
				}
				
				public void mouseReleased(MouseEvent e) {
					if (pressed) {
						model.setOldPlayerA(PlayerA);
						model.setOldPlayerB(PlayerB);
						model.setOldPlayerTurn(PlayerATurn);
						for (int i = 0; i < stoneLabelB.size(); i++) {
							if (stoneLabelB.get(i).equals(e.getComponent())) {
								boolean inB = true;
								boolean inMancala = false;
								
								int indexB = i;
								int indexA = 0;
								int loopCount = 0;
								int stoneCount = PlayerB.get(indexB);
								
								if (stoneCount != 0) {
								
									PlayerB.set(indexB, 0);
									while (loopCount < stoneCount) {
										//Fills Player B Row
										if (indexB - 1 >= 0) {
											PlayerB.set(indexB - 1, PlayerB.get(indexB - 1) + 1);
											inB = true;
											inMancala = false;
											lastIndex = indexB - 1;
										}
										
										else {
											//Fills Mancala B
											if (indexA == 0 && indexB == 0) {
												PlayerB.set(PlayerB.size() - 1, PlayerB.get(PlayerB.size() - 1) + 1);
												inB = false;
												inMancala = true;
											}
											//Fills Row A
											else if(indexA <= 5) {
												PlayerA.set(indexA, PlayerA.get(indexA) + 1);
												indexA++;
												inB = false;
												inMancala = false;
											}
											//Fills Row B after Row A
											else {
												inMancala = false;
												inB = true;
												int indexBreset = 5;
												lastIndex = indexBreset;
												
												//Maybe do one more mancala B put
												
												PlayerB.set(indexBreset, PlayerB.get(indexBreset) + 1);
												indexBreset--;
											}
										}
										
										if (loopCount == stoneCount - 1) {
											//Check Last In Opposite
											if (inB && PlayerB.get(lastIndex) == 1) {
												int oppositeStones = PlayerA.get(lastIndex);
												PlayerA.set(lastIndex, 0);
												PlayerB.set(PlayerB.size() - 1, PlayerB.get(PlayerB.size() - 1) + oppositeStones);
												PlayerATurn = true;
											}
											//Check Last In Mancala
											else if (inMancala) {
												PlayerATurn = false;
											}
											else {
												PlayerATurn = true;
											}
										}
										
										
										indexB--;
										loopCount++;
									}						
								}
								
								break;
							}
						}
						
						model.update(PlayerA, PlayerB, PlayerATurn);
						
					}
					
					if (checkAEnd() || checkBEnd()) {
						endGameCount();
						EndGameFrame endScreen = new EndGameFrame(model);
					}
				}	
			});
			
			stonePitBLabel.setPreferredSize(new Dimension (115,115));
			stonePitBLabel.setLayout(new FlowLayout());
			for (int j = 0; j < PlayerB.get(i); j++) {
				stone = new Stone();
				JLabel stoneLabel = new JLabel(stone);
				stonePitBLabel.add(stoneLabel);
			}
			if (i == 0) {
				stonePitBLabel.setBounds(xCoordB, yCoordB, 115, 115);
			}
			else {
				stonePitBLabel.setBounds(xCoordB + space, yCoordB, 115, 115);
				space += 115;
			}
			
			add(stonePitBLabel);
			stoneLabelB.add(stonePitBLabel);
		}
		
		space = 115;
		for (int i = 0; i < 6; i++) {
			JLabel stonePitALabel = new JLabel();
			
			stonePitALabel.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e) {
					pressed = true;
					
				}
				
				public void mouseReleased(MouseEvent e) {
					if (pressed) {
						model.setOldPlayerA(PlayerA);
						model.setOldPlayerB(PlayerB);
						model.setOldPlayerTurn(PlayerATurn);
						for (int i = 0; i < stoneLabelA.size(); i++) {
							if (stoneLabelA.get(i).equals(e.getComponent())) {
								boolean inA = true;
								boolean inMancala = false;
								
								int indexA = i;
								int indexB = 5;
								int loopCount = 0;
								int stoneCount = PlayerA.get(indexA);
								
								if (stoneCount != 0) {
								
									PlayerA.set(indexA, 0);
									while (loopCount < stoneCount) {
										//Fills Row A
										if (indexA + 1 <= 5) {
											PlayerA.set(indexA + 1, PlayerA.get(indexA + 1) + 1);
											inA = true;
											inMancala = false;
											lastIndex = indexA + 1;
										}
										
										else {
											//Fills Mancala A
											if (indexA == 5 && indexB == 5) {
												PlayerA.set(PlayerA.size() - 1, PlayerA.get(PlayerA.size() - 1) + 1);
												inA = false;
												inMancala = true;
											}
											//Fills Row B
											else if(indexB >= 0) {
												PlayerB.set(indexB, PlayerB.get(indexB) + 1);
												indexB--;
												inA = false;
												inMancala = false;
											}
											//Fills Row A after Row B
											else {
												inA = true;
												inMancala = false;
												int indexAreset = 0;
												lastIndex = indexAreset;
												
												PlayerA.set(indexAreset, PlayerA.get(indexAreset) + 1);
												indexAreset++;
												
											}
											
										}
										if (loopCount == stoneCount - 1) {
											//Check Opposite
											if (inA && PlayerA.get(lastIndex) == 1) {
												int oppositeStones = PlayerB.get(lastIndex);
												PlayerB.set(lastIndex, 0);
												PlayerA.set(PlayerA.size() - 1, PlayerA.get(PlayerA.size() - 1) + oppositeStones);
												PlayerATurn = false;
											}
											//Check Mancala
											else if (inMancala) {
												PlayerATurn = true;
											}
											else {
												PlayerATurn = false;
											}
										}
										
										indexA++;
										loopCount++;
									}
								}
								
								break;
							}
						}
						
						model.update(PlayerA, PlayerB, PlayerATurn);
						
					}
					
					if (checkAEnd() || checkBEnd()) {
						endGameCount();
						EndGameFrame endScreen = new EndGameFrame(model);
					}
					
				}
			});
			
			stonePitALabel.setPreferredSize(new Dimension (115,115));
			stonePitALabel.setLayout(new FlowLayout());
			for (int j = 0; j< PlayerA.get(i); j++) {
				stone = new Stone();
				JLabel stoneLabel = new JLabel(stone);
				stonePitALabel.add(stoneLabel);
			}
			if (i == 0) {
				stonePitALabel.setBounds(xCoordA, yCoordA, 115, 115);
			}
			else {
				stonePitALabel.setBounds(xCoordA + space, yCoordA, 115, 115);
				space += 115;
			}
			add(stonePitALabel);
			stoneLabelA.add(stonePitALabel);
		}
		
		
		JLabel mancalaLabelA = new JLabel();
		mancalaLabelA.setLayout(new FlowLayout());
		mancalaLabelA.setPreferredSize(new Dimension(150,350));
		mancalaLabelA.setBounds(845, 100, 150, 350);
		add(mancalaLabelA);
		
		stoneLabelA.add(mancalaLabelA);
		stoneLabelB.add(mancalaLabelB);
	}

	public boolean checkAEnd() {
		boolean isEnd = true;
		for (int i = 0; i < 6; i++) {
			if (PlayerA.get(i) != 0) {
				isEnd = false;
				break;
			}
		}
		
		return isEnd;
	}
	
	public boolean checkBEnd() {
		boolean isEnd = true;
		for (int i = 0; i < 6; i++) {
			if (PlayerB.get(i) != 0) {
				isEnd = false;
				break;
			}
		}
		
		return isEnd;
	}
	
	public void endGameCount() {
		int countA = 0;
		int countB = 0;
		for (int i = 0; i < 6; i++) {
			countA += PlayerA.get(i);
			countB += PlayerB.get(i);
		}
		
		PlayerA.set(6, PlayerA.get(6) + countA);
		PlayerB.set(6, PlayerB.get(6) + countB);
		
		model.setEndGame(true);
		model.update(PlayerA, PlayerB, true);
		
	}
	
	public void stoneRepaint(JLabel stoneLabel, int stoneNum) {
		int labelStoneCount = stoneLabel.getComponentCount();
		int diff;
		
		if (labelStoneCount < stoneNum) {
			diff = stoneNum - labelStoneCount;

			while (diff > 0) {
				stone = new Stone();
				JLabel newStone = new JLabel(stone);
				stoneLabel.add(newStone);
				diff--;
			}
		}
		
		else if (labelStoneCount > stoneNum){
			diff = labelStoneCount - stoneNum;
			int stoneIndex = labelStoneCount - 1;
			
			while (diff > 0) {
				stoneLabel.remove(stoneLabel.getComponent(stoneIndex));
				stoneIndex--;
				diff--;
			}
		}
		
		stoneLabel.repaint();
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		this.PlayerA = model.getPlayerAStones();
		this.PlayerB = model.getPlayerBStones();
		this.PlayerATurn = model.getPlayerATurn();
		
		for (int i = 0; i < 7; i++) {
			stoneRepaint(stoneLabelA.get(i), PlayerA.get(i));
			stoneRepaint(stoneLabelB.get(i), PlayerB.get(i));
		}
	}

}
