/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.obstacle.BaseObstacle;

public class OffensiveWeaponItem extends BaseItem {

	public OffensiveWeaponItem(Vector2 position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	protected ArrayList<Class<?>> obstacles = new ArrayList<Class<?>>();
	
	public void addDefeater(Class<?> obstacleClassName)
	{
		if(!obstacles.contains(obstacleClassName))
		{
			obstacles.add(obstacleClassName);
		}
	}

	public boolean defeats(BaseObstacle obstacle)
	{
		for(Class<?> obstacleClass : obstacles)
		{
			if(obstacleClass != null && obstacle.getClass().isInstance(obstacleClass))
			{	
				return true;
			}
		}

		return false;
	}
	
}
