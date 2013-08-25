/**
 * Base class for all weapons, items and useless objects that will appear
 * and disappear on the game play map
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.Utils.EStringJustify;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.obstacle.BaseObstacle;

public abstract class BaseItem extends BaseGamePlayObject {

	private int _defeats;
	private boolean _autoPickup;
	protected boolean _walkable = true;
	public boolean PlaceOnUnWalkable = false;
	
	protected BaseItem(String name, String description) {
		super(name, description);
		setAutoPickup(true);
	}
	
	public boolean doesDefeat(int gameCode) {
		return (_defeats & gameCode) != 0;
	}

	protected void setDefeats(int defeats) {
		_defeats = defeats;
	}

	public boolean getWalkable(){
		return _walkable;
	}
	
	/**
	 * Render method that prints the icon followed by the text of the advertisement
	 * @param batch
	 * @param adBarBounds
	 */
	public void renderAd(SpriteBatch batch, Rectangle adBarBounds) {
		icon.draw(batch);

		float x = adBarBounds.x + 10;
		float y = (adBarBounds.height -  adBarBounds.y)/2;
		this.setPosition(new Vector2(x,y));
		
		//Print the description text next to the icon
		x = adBarBounds.x + icon.getOriginX() - Config.screenHalfWidth + icon.getWidth();
		y = (adBarBounds.height -  adBarBounds.y)/2 - Config.screenHalfHeight;
		
		//TODO:   Handle wrapping
		Utils.drawText(batch, this.getAdDescription(), x,  y, Color.BLACK, EStringJustify.LEFT);
	}

	public void use() 
	{
		// this just places item in world, override on weapons
		Vector2 position = Game.player.getUsePosition();
		if (this.PlaceOnUnWalkable || Game.gameWorld.walkable(position))
		{
			Game.gameWorld.PlaceItem(this, position);
			Game.itemsBar.Remove(this);
			playUseSound();
		}
	}
	
	public void playUseSound() { }

	public boolean isAutoPickup() {
		return _autoPickup;
	}

	protected void setAutoPickup(boolean autoPickup) {
		_autoPickup = autoPickup;
	}

	public boolean defeat(BaseObstacle obstacle) {
		if (doesDefeat(obstacle.getObstacleCode())) {
			obstacle.defeat();
			Game.itemsBar.Remove(this);
			return true;
		}
		return false;
	}
}
