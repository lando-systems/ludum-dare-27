/**
 * Base object for all items that will reside in a space on the game play map
 * Obstacles, weapons, other items
 */
package com.gamedev.ld27;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.gameobjects.GameObject;

public class BaseGamePlayObject extends GameObject {

	protected String description = "Anonymous item - give me a name!";
	private String adDescription = "This is some text that will go in the advertisement";
	protected Sprite icon;
	protected TextureRegion textureRegion;
	protected Vector2 pos;
	private boolean inWorld;
	
	protected BaseGamePlayObject()
	{
		super(new Rectangle(0, 0, 32, 32));
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
	
	public void setPosition(Vector2 position) {
		super.setPosition(position);
		pos = position.cpy();
		if (icon != null) {
			setPosition(icon, position.x, position.y);
		}
	}
	
	public Vector2 getPosition()
	{
		return pos;
	}
	
	/**
	 * Set the file name for the image of the icon used for rendering this item
	 * Creates a File Reference to the assets/data folder - you only need to pass the file name and extension
	 * @param fileName
	 */
	protected void setIcon(TextureRegion region) {
		icon = new Sprite(region);
		setPosition(icon, _bounds.x, _bounds.y);
	}
	
	private void setPosition(Sprite sprite, float x, float y) {
		pos = new Vector2(x, y);
		icon.setPosition(x - Config.screenHalfWidth, y - Config.screenHalfHeight);
	}
	

	
	public Sprite getIcon() {
		return icon;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		icon.draw(batch);
	}

	protected String getAdDescription() {
		return adDescription;
	}
	protected void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
	}

	public boolean isInWorld() {
		return inWorld;
	}
	public void setInWorld(boolean inWorld) {
		this.inWorld = inWorld;
	}
}
