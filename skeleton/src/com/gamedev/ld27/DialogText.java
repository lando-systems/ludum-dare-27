package com.gamedev.ld27;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamedev.ld27.Utils.EStringJustify;

public class DialogText {
	
	public static Color TextColor = Color.WHITE;
	
	private String _text;
	private float _time;
	
	private float _visibleTime = 4f;
	private float _transitionTime = 1f;
	
	public DialogText(String text) {
		_text = text;
	}
	
	public void update(float delta) {
		_time += delta;
	}
	
	public void render(SpriteBatch batch, float x, float y) {
		Utils.drawText(batch, _text, x,  y, getColor(), EStringJustify.LEFT);
	}
	
	private Color getColor() {

		float trans = _time - _visibleTime;
		
		if (trans < 0) {
			return TextColor;
		}
		
		float alpha = 1f - (trans/ _transitionTime);
		return new Color(TextColor.r, TextColor.g, TextColor.b, alpha);		
	}
	
	public boolean shouldRemove() {
		return (_time >= (_visibleTime + _transitionTime));
	}
}
