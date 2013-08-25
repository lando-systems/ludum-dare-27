/**
 * Base object for all items that will reside in a space on the game play map
 * Obstacles, weapons, other items
 */
package com.gamedev.ld27;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.gameobjects.GameObject;

public class BaseGamePlayObject extends GameObject{

	protected String description;
	protected Sprite icon;
	protected TextureRegion textureRegion;
	private Vector2 objectPosition;
	
	/**
	 * Create an instance of a game play object, setting its position
	 * Description, icon, etc. are all defaulted
	 * @param position
	 */
	public BaseGamePlayObject(Vector2 position)
	{
		objectPosition = position;
	}
	
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

	protected Vector2 getObjectPosition() {
		return objectPosition;
	}

	protected void setObjectPosition(Vector2 objectPosition) {
		this.objectPosition = objectPosition;
	}
	
	/**
	 * Set the file name for the image of the icon used for rendering this item
	 * Creates a File Reference to the assets/data folder - you only need to pass the file name and extension
	 * @param fileName
	 */
	protected void setIcon(TextureRegion region) {
		icon = new Sprite(region);
		icon.setPosition(_bounds.x, _bounds.y);
	}
	
	public Sprite getIcon() {
		return icon;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		icon.draw(batch);
	}
}
