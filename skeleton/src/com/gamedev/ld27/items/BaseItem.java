/**
 * Base class for all weapons, items and useless objects that will appear
 * and disappear on the game play map
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.BaseGamePlayObject;

public abstract class BaseItem extends BaseGamePlayObject {

	private int _defeats;
	
	public BaseItem(Vector2 position) {
		super(position);
		setDescription("Anonymous item - give me a name!");
	}

	public boolean doesDefeat(int gameCode) {
		return (_defeats & gameCode) != 0;
	}

	protected void setDefeats(int defeats) {
		_defeats = defeats;
	}

}
