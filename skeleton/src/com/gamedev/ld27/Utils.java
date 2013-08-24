package com.gamedev.ld27;

import com.badlogic.gdx.graphics.Color;

public class Utils {

	private static final String symbols = ",.!?'\"-+=/\\%()<>:;";
	public static enum EStringJustify { LEFT, CENTER, RIGHT };

	public static void drawText(String text, float x, float y, int w, int h, Color color, EStringJustify justify) {
		text = text.toUpperCase();
		int s = 2; // spacing between characters (pixels)
		Assets.batch.begin();
		Assets.batch.setColor(color);
		float totalWidth = text.length() * w;
		switch (justify)
		{
		case LEFT:
			break;
		case CENTER:
			x -= totalWidth/2;
			break;
		case RIGHT:
			 x-= totalWidth;
			break;
		}
		for(int i = 0; i < text.length(); ++i) {
			char ch = text.charAt(i);
			float xPos = x + i * w + s;
			float yPos = y;

			if (ch >= 'A' && ch <= 'Z') {
				Assets.batch.draw(Assets.letters[0][ch - 'A'], xPos, yPos, w, h);
			} else if (ch >= '0' && ch <= '9') {
				Assets.batch.draw(Assets.digits[0][ch - '0'], xPos, yPos, w, h);
			} else {
				int index = symbols.indexOf(ch);
				if (index != -1) {
					Assets.batch.draw(Assets.symbols[0][index], xPos, yPos, w, h);
				}
			}
		}
		Assets.batch.setColor(Color.WHITE);
		Assets.batch.end();
	}
	
	
}
