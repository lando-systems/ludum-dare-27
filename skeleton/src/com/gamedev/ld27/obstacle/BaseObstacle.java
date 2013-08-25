/**
 * Base class for an obstacle 
 */
package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.items.BaseItem;

public abstract class BaseObstacle extends BaseItem {
	
	private int _obstacleCode;
	protected boolean _completed;
	

	protected BaseObstacle(String name, String description, int obstacleCode) {
		super(name, description);
		_obstacleCode = obstacleCode;
		_walkable = false;
	}
	
	public int getObstacleCode() {
		return _obstacleCode;
	}
	
	public void defeat() {
		_completed = true;
	}
	
	public boolean isCompleted() {
		return _completed;
	}
}
