package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.gamedev.ld27.Assets;

public abstract class GameObject {
	protected final Rectangle _bounds;

	protected GameObject(Rectangle bounds) {
		_bounds = bounds;
	}
	
	protected void Fill(Color color) {
		Assets.batch.end();
		
		Assets.shapes.begin(ShapeType.Filled);
		Assets.shapes.setColor(color);
		Assets.shapes.rect(_bounds.x, _bounds.y, _bounds.width, _bounds.height);
		Assets.shapes.end();
		
		Assets.batch.begin();
	}
	
	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
}
