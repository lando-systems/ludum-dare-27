/**
 * Base class for all weapons, items and useless objects that will appear
 * and disappear on the game play map
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.BaseGamePlayObject;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.Utils.EStringJustify;
import com.gamedev.ld27.Game;

public abstract class BaseItem extends BaseGamePlayObject {

	private int _defeats;
	private boolean _autoPickup;
	
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

	/**
	 * Render method that prints the icon followed by the text of the advertisement
	 * @param batch
	 * @param adBarBounds
	 */
	public void renderAd(SpriteBatch batch, Rectangle adBarBounds) {
		icon.draw(batch);
		
		//Print the description text next to the icon
		float x = adBarBounds.x + icon.getOriginX() - Config.screenHalfWidth + icon.getWidth();
		float y = (adBarBounds.height -  adBarBounds.y)/2 - Config.screenHalfHeight;
		Utils.drawText(batch, this.getAdDescription(), x,  y, Color.BLACK, EStringJustify.LEFT);
	}

	public void use() 
	{
		// this just places item in world, override on weapons
		Vector2 position = Game.player.getUsePosition();
		if (Game.gameWorld.walkable(position))
		{
			Game.gameWorld.PlaceItem(this, position);
			Game.itemsBar.Remove(this);
		}
	}

	public boolean isAutoPickup() {
		return _autoPickup;
	}

	protected void setAutoPickup(boolean autoPickup) {
		_autoPickup = autoPickup;
	}
}
