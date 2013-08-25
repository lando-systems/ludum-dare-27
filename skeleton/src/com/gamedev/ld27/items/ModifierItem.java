/**
 * Game items that alter some item of game play or the experience
 */
package com.gamedev.ld27.items;

import com.gamedev.ld27.obstacle.BaseObstacle;

public class ModifierItem extends BaseItem {

	public ModifierItem(String name, String description) {
		super(name, description);
	}
	
	/**
	 * Because this is a ModifierItem it won't defeat anything
	 */
	public boolean defeats(BaseObstacle obstacle)
	{
		return false;
	}
}
