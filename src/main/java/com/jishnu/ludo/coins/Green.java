package com.jishnu.ludo.coins;

import java.awt.Color;

public class Green extends Coins {

	private static short[] position = { -1, -1, -1, -1 };
	private static Green myObj;

	private Green() {
	}

	public static Green newInstance() {
		if (myObj == null) {
			myObj = new Green();
		}
		return myObj;
	}

	public static short getCoinCountinHouse() {
		short count = 0;
		for (short i = 0; i < 4; i++)
			if (position[i] < 0)
				count++;
		return count;
	}
	
	public short getCoininHouse() {
		for (short i = 0; i < 4; i++)
			if (position[i] < 0)
				return i;
		return -1;
	}

	public short[] getPosition() {
		return position;
	}

	public String getName() {
		return "green";
	}

	public Color getColor() {
		return Color.GREEN;
	}
}
