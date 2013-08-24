package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
	protected final Rectangle _bounds;

	protected GameObject(Rectangle bounds) {
		_bounds = bounds;
	}
	
	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
}
