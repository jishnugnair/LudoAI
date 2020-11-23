package com.jishnu.ludo.coins;

import java.awt.Color;

public class Red extends Coins {

	private static short[] position = { -1, -1, -1, -1 };
	private static Red myObj;

	private Red() {
	}

	public static Red newInstance() {
		if (myObj == null) {
			myObj = new Red();
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
		return "red";
	}

	public Color getColor() {
		return Color.RED;
	}
}
