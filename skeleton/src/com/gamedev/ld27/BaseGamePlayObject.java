/**
 * Base object for all items that will reside in a space on the game play map
 * Obstacles, weapons, other items
 */
package com.gamedev.ld27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.gameobjects.GameObject;

public class BaseGamePlayObject extends GameObject{

	protected String description;
	protected TextureRegion textureRegion;
	private FileHandle icon;
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
	
	/**
	 * Get a file handle to the icon image
	 * @return
	 */
	protected FileHandle getIcon() {
		return icon;
	}

	/**
	 * Set the file name for the image of the icon used for rendering this item
	 * Creates a File Reference to the assets/data folder - you only need to pass the file name and extension
	 * @param fileName
	 */
	protected void setIcon(String fileName) {
		this.icon = Gdx.files.internal("data/" + icon);
	}
	
	@Override
	public void update(float delta) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}
}
