/**
 * Base class for an obstacle 
 */
package com.gamedev.ld27.obstacle;

import com.gamedev.ld27.items.BaseGamePlayObject;

public abstract class BaseObstacle extends BaseGamePlayObject {

	protected BaseObstacle(String name, String description) {
		super(name, description);
	}
}
