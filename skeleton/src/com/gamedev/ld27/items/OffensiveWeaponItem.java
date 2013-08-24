/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;

import java.util.ArrayList;

import com.gamedev.ld27.obstacle.BaseObstacle;

public class OffensiveWeaponItem extends BaseItem {

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
