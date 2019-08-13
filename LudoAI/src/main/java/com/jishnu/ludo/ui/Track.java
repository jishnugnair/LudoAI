package com.jishnu.ludo.ui;

import java.util.ArrayList;

import com.jishnu.ludo.coins.Blue;
import com.jishnu.ludo.coins.Coins;
import com.jishnu.ludo.coins.Green;
import com.jishnu.ludo.coins.Red;
import com.jishnu.ludo.coins.Yellow;

public class Track {

	private static ArrayList<short[]> track = new ArrayList<short[]>();
	private static short[] position;
	private static short blueHome[][] = { { 1, 1 }, { 1, 4 }, { 4, 1 }, { 4, 4 } };
	private static short greenHome[][] = { { 10, 10 }, { 10, 13 }, { 13, 10 }, { 13, 13 } };
	private static short redHome[][] = { { 10, 1 }, { 13, 1 }, { 10, 4 }, { 13, 4 } };
	private static short yellowHome[][] = { { 1, 13 }, { 4, 13 }, { 1, 10 }, { 4, 10 } };
	private static short blue = 0, green = 0, red = 0, yellow = 0;

	static {

		for (short i = 0; i < 6; i++) {
			position = new short[2];
			position[0] = i;
			position[1] = 6;
			track.add(position);
		}

		for (short i = 5; i >= 0; i--) {
			position = new short[2];
			position[0] = 6;
			position[1] = i;
			track.add(position);
		}

		position = new short[2];
		position[0] = 7;
		position[1] = 0;
		track.add(position);

		for (short i = 0; i < 6; i++) {
			position = new short[2];
			position[0] = 8;
			position[1] = i;
			track.add(position);
		}

		for (short i = 9; i < 15; i++) {
			position = new short[2];
			position[0] = i;
			position[1] = 6;
			track.add(position);
		}

		position = new short[2];
		position[0] = 14;
		position[1] = 7;
		track.add(position);

		for (short i = 14; i > 8; i--) {
			position = new short[2];
			position[0] = i;
			position[1] = 8;
			track.add(position);
		}

		for (short i = 9; i < 15; i++) {
			position = new short[2];
			position[0] = 8;
			position[1] = i;
			track.add(position);
		}

		position = new short[2];
		position[0] = 7;
		position[1] = 14;
		track.add(position);

		for (short i = 14; i > 8; i--) {
			position = new short[2];
			position[0] = 6;
			position[1] = i;
			track.add(position);
		}

		for (short i = 5; i >= 0; i--) {
			position = new short[2];
			position[0] = i;
			position[1] = 8;
			track.add(position);
		}

		position = new short[2];
		position[0] = 0;
		position[1] = 7;
		track.add(position);
	}

	public static ArrayList<short[]> getTrack() {
		return track;
	}

	public static void setCoinsinHouse() {
		blue = Blue.getCoinCountinHouse();
		green = Green.getCoinCountinHouse();
		red = Red.getCoinCountinHouse();
		yellow = Yellow.getCoinCountinHouse();
	}

	public static short[] getTrackPos(Coins coin, short pos) {
		String color = coin.getName();

		if (color.equals("blue"))
			if (pos < 0)
				return blueHome[--blue];
			else if (pos > 51)
				return null;
			else
				return track.get((pos + 1) % 52);

		if (color.equals("green"))
			if (pos < 0)
				return greenHome[--green];
			else if (pos > 51)
				return null;
			else
				return track.get((pos + 27) % 52);

		if (color.equals("red"))
			if (pos < 0)
				return redHome[--red];
			else if (pos > 51)
				return null;
			else
				return track.get((pos + 14) % 52);

		if (color.equals("yellow"))
			if (pos < 0)
				return yellowHome[--yellow];
			else if (pos > 51)
				return null;
			else
				return track.get((pos + 40) % 52);

		return null;
	}

	public static short getCoinAtPos(Coins coin, short x, short y) {
		int trackPos = -1;
		short pos = -1;

		System.out.println("X=" + x + " & " + "Y=" + y);

		for (int i = 0; i < track.size(); i++) {
			short position[] = track.get(i);
			if (position[0] == x && position[1] == y) {
				trackPos = i;
				break;
			}
		}

		System.out.println("Track Position: " + trackPos);

		int tempPos = -1;
		switch (coin.getName()) {
		case "blue":
			tempPos = trackPos - 1;
			pos = getCoinNo(coin, (tempPos < 0 ? tempPos + 52 : tempPos) % 52);
			break;

		case "red":
			tempPos = trackPos - 14;
			pos = getCoinNo(coin, (tempPos < 0 ? tempPos + 52 : tempPos) % 52);
			break;

		case "green":
			tempPos = trackPos - 27;
			pos = getCoinNo(coin, (tempPos < 0 ? tempPos + 52 : tempPos) % 52);
			break;

		case "yellow":
			tempPos = trackPos - 40;
			pos = getCoinNo(coin, (tempPos < 0 ? tempPos + 52 : tempPos) % 52);
			break;
		}

		return pos;
	}

	private static short getCoinNo(Coins coin, int pos) {
		short position[] = coin.getPosition();
		for (short i = 0; i < 4; i++)
			if (pos == position[i])
				return i;

		return -1;
	}

}
