package main.com.jishnu.ludo.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import main.com.jishnu.ludo.coins.Coins;
import main.com.jishnu.ludo.rules.Dice;
import main.com.jishnu.ludo.rules.Moves;
import main.com.jishnu.ludo.rules.Turn;

public class UserInputHandler implements MouseListener {

	private final float cellSize = 620f / 15f;
	private static Frame frame = null;
	private short dice = 0;

	public static void setFrame(Frame f) {
		frame = f;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		System.out.println(x + " : " + y);
		System.out.println("Turn of " + Turn.getTurn().getName());
		// Check if dice is clicked
		if (x >= 290 && x <= 330 && y > 643 && y <= 683 && !Dice.isDiceRolled()) {
			dice = Dice.turnDice();
			if (Moves.hasNoValidMoves(Turn.getTurn(), dice)) {
				Dice.setDiceRolledFalse();
				Turn.getNextTurn();
			}
		}
		// Check if Board's Center is clicked
		else if (x > 248 && x <= 372 && y > 270 && y <= 394) {
			System.out.println("Center clicked");
		}
		// Check if Play area is clicked
		else if (x >= 0 && x <= 620 && y >= 22 && y <= 643 && Dice.isDiceRolled()) {
			Map<String, Rectangle> rectangles = Homes.getRectangles();
			boolean isHome = false;
			// Check if a Home is clicked
			for (int i = 0; i < 4; i++) {
				Coins coin = Coins.getCoin(i);
				if (rectangles.get(coin.getName()).contains(x, y)) {
					if (dice == 6 && Turn.hasTurn(coin) && coin.getCoininHouse() > -1) {
						Move.move(coin, coin.getCoininHouse(), dice);
					}
					System.out.println("Home clicked");
					isHome = true;
					break;
				}
			}
			// Identify the clicked Track position
			if (!isHome) {
				System.out.println("Track clicked");
				short coinNo = -1;
				coinNo = Track.getCoinAtPos(Turn.getTurn(), (short) (x / cellSize), (short) ((y - 22) / cellSize));
				System.out.println("Coin No: " + coinNo);
				if (coinNo > -1)
					Move.move(Turn.getTurn(), coinNo, dice);
			}
		}

		// Move.move(Turn.getTurn(), (short) 1, dice);
		frame.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
