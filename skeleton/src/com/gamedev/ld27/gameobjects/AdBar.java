package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.offensive.*;
import com.gamedev.ld27.items.useful.*;
import com.gamedev.ld27.items.modifiers.*;
import com.gamedev.ld27.items.offensive.BagOfKittens;
import com.gamedev.ld27.items.offensive.WetNoodle;

public class AdBar extends GameObject {

	private BaseItem _currentItem;
	private Rectangle adBarBounds;
	private long lastAdTime = -1;
	
	public AdBar(Rectangle bounds) {
		super(bounds);
		adBarBounds = bounds;
	}
	
	public boolean selectRandomAd(SpriteBatch batch) {
		boolean displayed = false;
		
		//TODO:   for now the noodle is hard coded, need to select a random one
		//TODO:   create a factory class for items
		//TODO:   the randomizer should probably come out of Adbar so we can drop them into the game world too
		Array<BaseItem> items = new Array<BaseItem>();
		//offensive
		items.add(new BagOfJewels());
		items.add(new BagOfKittens());
		items.add(new Hacksaw());
		items.add(new OffensiveTower());
		items.add(new WetNoodle());
		//useful
		items.add(new Bacon());
		items.add(new Bombs());
		items.add(new Boomerang());
		items.add(new Flute());
		items.add(new Hammer());
		items.add(new Helmet());
		items.add(new Slinky());
		
		//modifiers
		items.add(new Mushroom());
		
		_currentItem = items.random();
		
		if (_currentItem != null) 
		{
			lastAdTime = TimeUtils.millis();
			displayed = true;
		}
	
		return displayed;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		//TODO:   Get the ad color from the item
		fill(Color.GREEN);
		
		if((TimeUtils.millis() - lastAdTime) > 10000)
		{
			selectRandomAd(batch);
		}
	
		_currentItem.renderAd(batch, adBarBounds);
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

}
