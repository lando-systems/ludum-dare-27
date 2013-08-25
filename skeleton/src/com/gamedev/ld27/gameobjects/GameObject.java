package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;

public abstract class GameObject {
	protected final Rectangle _bounds;

	protected GameObject()
	{
		this(new Rectangle());
	}
	
	protected GameObject(Rectangle bounds) {
		_bounds = bounds;
	}
	
	public float getWidth() { 
		return _bounds.height;
	}
	
	public float getHeight() {
		return _bounds.width;
	}
	
	private static final Color Transparent = new Color(0, 0, 0, 0);
		
	protected void Fill(Color color) {
		Fill(color, Transparent);
	}
	
	protected void Fill(Color background, Color border)
	{
		Assets.batch.end();
		
		Assets.shapes.begin(ShapeType.Filled);
		Assets.shapes.setColor(background);
		Assets.shapes.rect(_bounds.x, _bounds.y, _bounds.width, _bounds.height);
		Assets.shapes.end();
		
		if (border != Transparent) {
			Assets.shapes.begin(ShapeType.Line);
			Assets.shapes.setColor(border);
			Assets.shapes.rect(_bounds.x, _bounds.y, _bounds.width, _bounds.height);
			Assets.shapes.end();
		}
		
		Assets.batch.begin();
	}
	
	public void setPosition(Vector2 position) {
		_bounds.setPosition(position);
	}
	
	public void render(SpriteBatch batch) {}
	public void update(float delta) {}
}
