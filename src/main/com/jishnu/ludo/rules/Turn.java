package main.com.jishnu.ludo.rules;

import main.com.jishnu.ludo.coins.Blue;
import main.com.jishnu.ludo.coins.Coins;
import main.com.jishnu.ludo.coins.Green;
import main.com.jishnu.ludo.coins.Red;
import main.com.jishnu.ludo.coins.Yellow;

public class Turn {
	private static short turn = (short) (Math.random() * 3);
	private static final Coins[] colours = { Blue.newInstance(), Red.newInstance(), Green.newInstance(),
			Yellow.newInstance() };

	public static Coins getNextTurn() {
		// System.out.println(colours[(turn + 1) % 4].getName());
		return colours[++turn % 4];
	}

	public static Coins getTurn() {
		return colours[turn % 4];
	}

	public static boolean hasTurn(Coins coin) {
		if (Coins.getCoin(turn % 4).getName().equals(coin.getName()))
			return true;

		return false;
	}
}
