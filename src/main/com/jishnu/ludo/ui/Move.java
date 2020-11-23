package main.com.jishnu.ludo.ui;

import main.com.jishnu.ludo.coins.Coins;
import main.com.jishnu.ludo.rules.Dice;
import main.com.jishnu.ludo.rules.Moves;
import main.com.jishnu.ludo.rules.Turn;

public class Move {

	public static void move(Coins color, short coin, short dice) {
		short[] position = color.getPosition();
		if (Moves.isValidMove(position[coin], dice)) {
			if (position[coin] < 0)
				position[coin] = 0;
			else
				position[coin] += dice;
			
			Dice.setDiceRolledFalse();
			Turn.getNextTurn();
		}
		//System.out.println(dice);
	}
}
