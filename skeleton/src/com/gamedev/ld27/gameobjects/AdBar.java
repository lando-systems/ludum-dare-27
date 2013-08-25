package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.Utils.EStringJustify;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.offensive.WetNoodle;

public class AdBar extends GameObject {

	private BaseItem _currentItem;
	private Rectangle adBarBounds;
	
	public AdBar(Rectangle bounds) {
		super(bounds);
		adBarBounds = bounds;
	}
	
	public boolean selectRandomAd() {
		boolean displayed = false;
		
		//TODO:   for now the noodle is hard coded, need to select a random one
		//TODO:   create a factory class for items
		//TODO:   the randomizer should probably come out of Adbar so we can drop them into the game world too
		_currentItem = new WetNoodle();
		
		if (_currentItem != null) 
		{
			//TODO:   Handle empty vs removing previous one
			float x = adBarBounds.x + 10;
			float y = (adBarBounds.height -  adBarBounds.y)/2;
			_currentItem.setPosition(new Vector2(x,y));	
			
			displayed = true;
		}
		return displayed;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		fill(Color.GREEN);
		
		if (_currentItem != null) {
			//Render the icon
			_currentItem.renderAd(batch, adBarBounds);
		}
	
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

}
