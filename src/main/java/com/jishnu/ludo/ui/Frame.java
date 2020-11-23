package com.jishnu.ludo.ui;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1228193394106659788L;

	Graphics g;

	public Frame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 10, 620, 683);
		setVisible(true);
		addMouseListener(new UserInputHandler());

	}

	public void paint(Graphics g) {
		this.g = g;
		try {
			Board.drawBoard(g);
			Board.drawDiceBoard(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
