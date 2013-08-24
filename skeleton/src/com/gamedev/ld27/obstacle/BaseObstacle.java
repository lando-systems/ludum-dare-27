/**
 * Base class for an obstacle 
 */
package com.gamedev.ld27.obstacle;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.BaseGamePlayObject;;

public abstract class BaseObstacle extends BaseGamePlayObject {

	public BaseObstacle(Vector2 position) {
		super(position);
		setDescription("Anonymous obstacle - give me a name!");
		setIcon("default_obstacle.png");
	}
}
