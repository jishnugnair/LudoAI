package com.jishnu.ludo.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.jishnu.ludo.coins.Blue;
import com.jishnu.ludo.coins.Coins;
import com.jishnu.ludo.coins.Green;
import com.jishnu.ludo.coins.Red;
import com.jishnu.ludo.coins.Yellow;
import com.jishnu.ludo.rules.Dice;
import com.jishnu.ludo.rules.Turn;

public class Board {

	private static BufferedImage board = null;
	private static BufferedImage diceBoard = null;
	private static BufferedImage dices[] = new BufferedImage[6];
	private static final Coins[] colours = { Blue.newInstance(), Green.newInstance(), Red.newInstance(),
			Yellow.newInstance() };
	private static final float cellSize = 620f / 15f;

	public static void loadSprites() throws IOException {
		board = ImageIO.read(new File("src/main/resources/images/ludo_board.png"));

		for (short i = 0; i < 6; i++) {
			dices[i] = ImageIO.read(new File("src/main/resources/images/" + (i + 1) + ".jpg"));
		}
	}

	public static void drawBoard(Graphics g) throws IOException {
		BufferedImage tmpboard = new BufferedImage(board.getColorModel(), board.copyData(null),
				board.getColorModel().isAlphaPremultiplied(), null);

		Graphics2D gimg = tmpboard.createGraphics();

		gimg.setRenderingHints(
				new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
		/*
		 * while (i++ < 51) { gimg.fillOval((int) (track.get(i)[0] * 41.3 + 7), (int)
		 * (track.get(i)[1] * 41.3 + 7), 30, 30); }
		 */
		short position[][] = new short[4][4];
		Track.setCoinsinHouse();
		for (short i = 0; i < 4; i++) {
			position[i] = colours[i].getPosition();
			for (short j = 0; j < 4; j++) {
				gimg.setColor(colours[i].getColor());
				short[] xy = Track.getTrackPos(colours[i], position[i][j]);
				gimg.fillOval((int) (xy[0] * cellSize + 7), (int) (xy[1] * cellSize + 7), 30, 30);
				gimg.setColor(Color.BLACK);
				gimg.drawOval((int) (xy[0] * cellSize + 7), (int) (xy[1] * cellSize + 7), 30, 30);
			}
		}
		g.drawImage(tmpboard, 0, 22, null);

	}

	public static void drawDiceBoard(Graphics g) throws IOException {
		diceBoard = new BufferedImage(620, 40, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D dbGraphics = diceBoard.createGraphics();
		dbGraphics.setColor(Turn.getTurn().getColor());
		dbGraphics.fillRect(0, 0, 620, 40);
		dbGraphics.drawImage(dices[Dice.getDice() - 1], 290, 0, 40, 40, null);
		if (!Dice.isDiceRolled())
			dbGraphics.drawOval(290, 0, 40, 40);
		g.drawImage(diceBoard, 0, 643, null);
	}

}
