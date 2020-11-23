package main.com.jishnu.ludo.main;

import java.io.IOException;

import main.com.jishnu.ludo.ui.Board;
import main.com.jishnu.ludo.ui.Frame;
import main.com.jishnu.ludo.ui.UserInputHandler;

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
