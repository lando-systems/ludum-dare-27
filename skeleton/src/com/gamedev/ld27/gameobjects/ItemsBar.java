package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class ItemsBar extends GameObject {

	public ItemsBar(Rectangle bounds) {
		super(bounds);
	}
	@Override
	public void render(SpriteBatch batch) {
		Fill(Color.BLACK);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

}
