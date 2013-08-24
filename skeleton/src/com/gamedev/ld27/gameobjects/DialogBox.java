package com.gamedev.ld27.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.Utils.EStringJustify;

public class DialogBox extends GameObject {
	
	private final ArrayList<String> _dialogText = new ArrayList<String>(20);
	private float _yPosition;
	private int _maxText;

	public DialogBox(Rectangle bounds) {
		super(bounds);
		_maxText = (int)(bounds.height / Config.textHeight);
	}
	
	@Override
	public void render(SpriteBatch batch) {
		Fill(Color.BLACK);
		float x = _bounds.x + 10 - Config.screenHalfWidth;
		float y = _yPosition - Config.screenHalfHeight;
		
		int i = Math.max(0,  _dialogText.size() - _maxText);		
		for (; i < _dialogText.size(); i++) {
			Utils.drawText(batch, _dialogText.get(i), x,  y, Color.RED, EStringJustify.LEFT);
			y += Config.textHeight;
		}	
	}

	@Override
	public void update(float delta) {
		// not using word wrap	
		int textLines = Math.min(_maxText,  _dialogText.size());		
		_yPosition = _bounds.y + (_bounds.height - (textLines * Config.textHeight)) /2;
	}
	
	public void AppendText(String text) {
		_dialogText.add(text);
	}
	
	public void SetText(String text) {
		_dialogText.clear();
		_dialogText.add(text);
	}
}
