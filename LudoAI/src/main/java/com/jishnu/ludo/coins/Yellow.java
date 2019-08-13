package com.jishnu.ludo.coins;

import java.awt.Color;

public class Yellow extends Coins {

	private static short[] position = { 12, -1, -1, -1 };
	private static Yellow myObj;

	private Yellow() {
	}

	public static Yellow newInstance() {
		if (myObj == null) {
			myObj = new Yellow();
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
		return "yellow";
	}

	public Color getColor() {
		return Color.YELLOW;
	}
}
