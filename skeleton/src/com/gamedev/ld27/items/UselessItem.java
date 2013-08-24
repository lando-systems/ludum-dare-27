/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.BaseGamePlayObject;
import com.gamedev.ld27.obstacle.*;

public class UselessItem extends BaseGamePlayObject {
	
	public UselessItem(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Because this is a UselessItem it won't defeat anything
	 */
	public boolean defeats(BaseObstacle obstacle)
	{
		return false;
	}
}
