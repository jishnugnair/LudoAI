package main.com.jishnu.ludo.rules;

import main.com.jishnu.ludo.coins.Coins;

public class Moves {

	public static boolean isValidMove(short position, short dice) {
		if (position < 0 && dice < 6)
			return false;
		if ((position + dice) > 57)
			return false;
		return true;
	}

	public static boolean hasNoValidMoves(Coins coin, short dice) {
		short position[] = coin.getPosition();
		for (short i = 0; i < 4; i++)
			if (isValidMove(position[i], dice))
				return false;

		return true;
	}
}
