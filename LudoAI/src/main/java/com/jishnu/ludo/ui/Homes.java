package com.jishnu.ludo.ui;

import java.awt.Rectangle;
import java.util.HashMap;

public class Homes {
	private static HashMap<String, Rectangle> rectangles = new HashMap<String, Rectangle>();

	static {
		rectangles.put("blue", new Rectangle(0, 22, 248, 248));
		rectangles.put("red", new Rectangle(373, 22, 248, 248));
		rectangles.put("yellow", new Rectangle(0, 395, 248, 248));
		rectangles.put("green", new Rectangle(373, 395, 248, 248));
	}

	public static HashMap<String, Rectangle> getRectangles() {
		return rectangles;
	}
}
