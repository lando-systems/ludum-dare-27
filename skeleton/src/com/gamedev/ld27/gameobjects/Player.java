package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.gamedev.ld27.Assets;

public class Player extends PlayerBase {

	public Player(Rectangle bounds) {
		super(bounds, Assets.playerSheet);
		
		_livePlayer = true;
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
	

}
