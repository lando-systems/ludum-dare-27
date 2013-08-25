/**
 * Base class for all weapons, items and useless objects that will appear
 * and disappear on the game play map
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.BaseGamePlayObject;
import com.gamedev.ld27.Game;

public abstract class BaseItem extends BaseGamePlayObject {

	private int _defeats;
	
	public boolean doesDefeat(int gameCode) {
		return (_defeats & gameCode) != 0;
	}

	protected void setDefeats(int defeats) {
		_defeats = defeats;
	}

	public void use() 
	{
		// this just places item in world, override on weapons
		Vector2 position = Game.player.getTargetPosition();
		if (Game.gameWorld.walkable(position))
		{
			Game.gameWorld.PlaceItem(this, position);
			Game.itemsBar.Remove(this);
		}
	}
}
