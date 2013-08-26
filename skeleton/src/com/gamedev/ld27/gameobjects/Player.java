package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.obstacle.BaseObstacle;
import com.gamedev.ld27.obstacle.TrollBridge;

public class Player extends PlayerBase {

	private BaseObstacle _obstacle;
	private boolean _wearingHelm;
	private boolean _wearingGlasses;
	private float _mushroomEffectTime;
	
	public Player(Rectangle bounds) {
		super(bounds, Assets.playerSheet);
		
		_livePlayer = true;
	}
	
	public boolean isOnMushrooms(){
		return _mushroomEffectTime > 0;
	}
	
	public void StartTripping() {
		_mushroomEffectTime = 10f;
	}
	
	public boolean isWearingHelf() {
		return _wearingHelm;
	}
	
	public void SetWearingHelm() {
		_wearingHelm = true;
	}
	
	public boolean IsWearingGlasses() {
		return _wearingGlasses;
	}
	
	public void StartWearingGlasses() {
		_wearingGlasses = true;
	}
	
	public void update(float delta) {
		
		IgnoreInput = (_obstacle != null);
		if (_mushroomEffectTime > 0) _mushroomEffectTime -= delta;
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
		//TODO Add stuff so players know what they need to do
		Vector2 PlayerTile = Game.gameWorld.mapTileFromPosition(pos);
		if (!TrollBridge.Spawned && PlayerTile.x == 27 && PlayerTile.y == 57) {
			_obstacle = new TrollBridge(this);
		}
		if (Game.VegHippie.Alive && PlayerTile.x == 25 && PlayerTile.y == 12){
			// TODO Say something about the vegan guy
		}
		if (Game.snake.Alive && PlayerTile.x == 0 && PlayerTile.y == 80){
			// TODO Say something about the snake in the box
		}
		if (!Game.gameWorld.DrawBridgeDropped && PlayerTile.x == 25 && PlayerTile.y == 83){
			// TODO Say something about the Lever
			Game.dialogBox.AppendText("Look at that lever on the other side of the moat!");
		}
		if (PlayerTile.x == 10 && PlayerTile.y == 93){
			// TODO Say something about the Lever
			Game.dialogBox.AppendText("I am one of the knights who says NI");
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
