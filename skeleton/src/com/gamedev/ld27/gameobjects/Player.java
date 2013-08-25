package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Game;

public class Player extends GameObject {

	public Vector2 pos;
	private Vector2 targetPos;
	private static float SPEED = 100.0f;
	private int startTileX = 10;
	private int startTileY = 10;
	
	public Player(Rectangle bounds) {
		super(bounds);
		
		pos = new Vector2(startTileX*32,startTileY*32);
		targetPos = new Vector2(startTileX*32,startTileY*32);
	}
	@Override
	public void render(SpriteBatch batch) {
		Fill(Color.RED);
	}
	
	@Override
	public void update(float delta) {
		//TODO move this into a player controller?
		if (updatePos(delta)){
			Vector2 prevTarget = targetPos.cpy();
			if(Gdx.input.isKeyPressed(Keys.W)){
				targetPos.y += 32.0f;
			}
			else if(Gdx.input.isKeyPressed(Keys.A)){
				targetPos.x -= 32.0f;
			}
			else if(Gdx.input.isKeyPressed(Keys.S)){
				targetPos.y -= 32.0f;
			}
			else if(Gdx.input.isKeyPressed(Keys.D)){
				targetPos.x += 32.0f;
			}
			if (!Game.gameWorld.walkable(targetPos)) targetPos = prevTarget;
		} 
	}
	
	public boolean updatePos(float delta){
		if ((int)pos.x == (int)targetPos.x &&
			(int)pos.y == (int)targetPos.y)
			return true;
		
		Vector2 dir = new Vector2(targetPos.x - pos.x, targetPos.y - pos.y);
//		if (pos.x < targetPos.x) dir.x = 1.0f;
//		if (pos.x > targetPos.x) dir.x = -1.0f;
//		if (pos.y < targetPos.y) dir.y = 1.0f;
//		if (pos.y > targetPos.y) dir.y = -1.0f;
		dir.nor();
		dir.scl(SPEED*delta);
		float dist = dir.len2();
		float targetDist = targetPos.dst2(pos);
		if (dist >= targetDist){
			pos.x = targetPos.x;
			pos.y = targetPos.y;
		} else
		{
			pos.add(dir);
		}
		return false;
	}
}
