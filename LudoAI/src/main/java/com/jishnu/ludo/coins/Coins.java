package com.jishnu.ludo.coins;

import java.awt.Color;

public abstract class Coins {
	
	private static Coins[] coins = { Blue.newInstance(), Red.newInstance(), Green.newInstance(), Yellow.newInstance()};

	public abstract short[] getPosition();

	public abstract Color getColor();

	public abstract String getName();
	
	public abstract short getCoininHouse();
	
	public static Coins[] getCoins() {
		return coins;
	}
	
	public static Coins getCoin(int i) {
		return coins[i];
	}

}
