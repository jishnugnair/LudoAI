package com.jishnu.ludo.main;

import java.io.IOException;

import com.jishnu.ludo.ui.Board;
import com.jishnu.ludo.ui.Frame;
import com.jishnu.ludo.ui.UserInputHandler;

public class Main {

	public static void main(String[] args) {		
		try {
			Board.loadSprites();
			Frame frame = new Frame();
			UserInputHandler.setFrame(frame);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
