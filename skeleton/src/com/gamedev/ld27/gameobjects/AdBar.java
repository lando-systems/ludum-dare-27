package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class AdBar extends GameObject {

	public AdBar(Rectangle bounds) {
		super(bounds);
	}
	@Override
	public void render(SpriteBatch batch) {
		fill(Color.GREEN);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

}
