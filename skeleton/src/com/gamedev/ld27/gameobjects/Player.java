package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.obstacle.BaseObstacle;
import com.gamedev.ld27.obstacle.TrollBridge;

public class Player extends PlayerBase {

	private BaseObstacle _obstacle;
	
	public Player(Rectangle bounds) {
		super(bounds, Assets.playerSheet);
		
		_livePlayer = true;
	}
	
	public void update(float delta) {
		
		IgnoreInput = (_obstacle != null);
		
		super.update(delta);
		
		if (_obstacle != null) {
			_obstacle.update(delta);
			if (_obstacle.isCompleted()) {
				_obstacle = null;
			}
		}
	}
	
	public void render(SpriteBatch spriteBatch) {
		super.render(spriteBatch);
		if (_obstacle != null) {
			_obstacle.render(spriteBatch);
		}
	}
	
	protected void handleInput(float delta) {
		
		if(Gdx.input.isKeyPressed(Keys.W)){
			moveNorth();
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			moveWest();
		}
		else if(Gdx.input.isKeyPressed(Keys.S)){
			moveSouth();
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			moveEast();
		}
	}
	
	protected void finishMove(int tileType) {
		// e-w bridge
		if (tileType == 6) {
			if (Utils.probability(90)) {
				_obstacle = new TrollBridge(this);
			}
		}	
	}

	public boolean canUse(BaseItem item) {
		if (_obstacle != null) {
			item.defeat(_obstacle);
			return false;
		}
		return true;
	}
}
