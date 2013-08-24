/**
 * Game items that alter some item of game play or the experience
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.BaseGamePlayObject;
import com.gamedev.ld27.obstacle.BaseObstacle;

public class ModifierItem extends BaseGamePlayObject {

	public ModifierItem(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Because this is a ModifierItem it won't defeat anything
	 */
	public boolean defeats(BaseObstacle obstacle)
	{
		return false;
	}
}
