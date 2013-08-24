/**
 * Base object for all items that will reside in a space on the game play map
 * Obstacles, weapons, other items
 */
package com.gamedev.ld27;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.gameobjects.GameObject;

public class BaseGamePlayObject extends GameObject {

	protected String description;
	protected TextureRegion textureRegion;
	
	/**
	 * Return a description that can be displayed to the user 
	 * about what the object is
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String desc)
	{
		description = desc;
	}
	
	public TextureRegion getTextureRegion()
	{
		return textureRegion;
	}
	
	public void setTextureRegion(TextureRegion texture)
	{
		textureRegion = texture;
	}

	protected Vector2 getObjectPosition() {
		return new Vector2(_bounds.x, _bounds.y);
	}

	protected void setObjectPosition(Vector2 objectPosition) {
		_bounds.setPosition(objectPosition);
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
}
