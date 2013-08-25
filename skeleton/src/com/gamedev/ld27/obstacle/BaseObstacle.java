/**
 * Base class for an obstacle 
 */
package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.items.BaseGamePlayObject;

public abstract class BaseObstacle extends BaseGamePlayObject {
	
	private int _obstacleCode;

	protected BaseObstacle(String name, String description, int obstacleCode) {
		super(name, description);
		_obstacleCode = obstacleCode;
	}
	
	public int getObstacleCode() {
		return _obstacleCode;
	}
}
