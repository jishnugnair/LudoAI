package com.jishnu.ludo.rules;

public class Dice {
	private static boolean isDiceRolled = false;
	private static short dice = (short) (Math.random() * 5 + 1);

	public static short getDice() {
		return dice;
	}

	public static short turnDice() {
		isDiceRolled = true;
		dice = (short) (Math.round(Math.random() * 5) + 1);
		return dice;
	}

	public static boolean isDiceRolled() {
		return isDiceRolled;
	}

	public static void setDiceRolledFalse() {
		isDiceRolled = false;
	}
}
