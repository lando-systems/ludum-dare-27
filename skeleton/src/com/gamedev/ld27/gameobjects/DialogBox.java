package com.gamedev.ld27.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.DialogText;

public class DialogBox extends GameObject {
	
	private final ArrayList<DialogText> _dialogText = new ArrayList<DialogText>(20);
	private float _yPosition;
	private int _maxText;
	private int _maxTextWidth;

	public DialogBox(Rectangle bounds) {
		super(bounds);
		_maxText = (int)(bounds.height / Config.textHeight);
		_maxTextWidth = (int)(bounds.width / Config.textWidth) - 2;
		_yPosition = bounds.y + bounds.height 
				- ((bounds.height - (_maxText*Config.textHeight))/2) - Config.textHeight;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		fill(Color.BLACK, Color.RED);
		float x = _bounds.x + 10 - Config.screenHalfWidth;
		float y = _yPosition - Config.screenHalfHeight;
		
		int lines = 0;
		for (int i = _dialogText.size() - 1; i >=0; i--) {
			DialogText text = _dialogText.get(i);
			text.render(batch, x, y);
			
			y -= Config.textHeight;
			
			if (++lines == _maxText) {
				break;
			}
		}	
	}

	private ArrayList<DialogText> _removeList = new ArrayList<DialogText>(10);
	
	@Override
	public void update(float delta) {
		_removeList.clear();
		
		for (DialogText text : _dialogText) {
			text.update(delta);
			
			if (text.shouldRemove()) {
				_removeList.add(text);
			}
		}
		
		for (DialogText text : _removeList) {
			_dialogText.remove(text);
		}		
	}
	
	public void AppendText(String text) {
		add(text);
	}
	
	public void SetText(String text) {
		_dialogText.clear();
		add(text);
	}
	
	private void add(String text) {
		int insert = _dialogText.size();
		while (text.length() > _maxTextWidth) {
			int index = _maxTextWidth;
			while (text.charAt(index) != ' ') {
				index--;
			}
			
			String subText = text.substring(0, index);
			_dialogText.add(insert, new DialogText(subText));
			text = text.substring(index);
		}
		_dialogText.add(insert, new DialogText(text));
	}
}
