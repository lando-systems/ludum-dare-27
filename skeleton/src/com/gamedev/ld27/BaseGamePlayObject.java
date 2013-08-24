/**
 * Base object for all items that will reside in a space on the game play map
 * Obstacles, weapons, other items
 */
package com.gamedev.ld27;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class BaseGamePlayObject {

	protected String description;
	protected TextureRegion textureRegion;
	private Vector2 objectPosition;
	
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
		return objectPosition;
	}

	protected void setObjectPosition(Vector2 objectPosition) {
		this.objectPosition = objectPosition;
	}
	
	//TODO:   Find out more about what is needed here
	public static void render()
	{
		//this still needs lots of information on what it's going to do
	}
}
