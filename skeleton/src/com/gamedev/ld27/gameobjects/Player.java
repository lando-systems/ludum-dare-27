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

	private boolean _wearingGlasses;
	private float _mushroomEffectTime;
	private boolean _wearingDisguise;
	private boolean _wearingBox;
	
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
	
	public boolean isWearingHelm() {
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
	
	public void ToggleDisguise(){
		_wearingDisguise = !_wearingDisguise;
	}
	
	public void toggleBox() {
		_wearingBox = !_wearingBox;
	}
	
	public boolean isWearingDisguise() {
		return _wearingDisguise;
	}
	
	public boolean isWearingBox() {
		return _wearingBox;
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
		
		//FLow of the game is as such
		// Get bacon from killing things
		// Give Bacon to vegan hippie (get a disguise)
		// Get helmet from behind hippie
		// Get a bag of jewels or a hammer
		// meet the troll, give him jewels or break rock (get cigar)
		// get flute from middle of map
		// get slinky from buttom right
		// use flute on snake to get cardboard box and get access to knight who says NI
		// Give shubbery to knight for mushrooms
		// Put on the helmet so you can pick up the offensive tower on the right
		// use slinky on level to lower draw bridge
		// use offenseive tower on defensive tower
		// use the exploding cigar to make the smoking guard leave
		// Put on the disguise or the cardboard box to walk past the guards
		// Give the red herring to the dog to get past and get the eyeglasses so you can see the path
		// get the hacksaw from the hidden path in the top right
		// cut the dragon free, and die (end game)
		
		Vector2 PlayerTile = Game.gameWorld.mapTileFromPosition(pos);
		if (!TrollBridge.Spawned && PlayerTile.x == 27 && PlayerTile.y == 57) {
			Game.dialogBox.AppendText("Give me something shiny that cuts class, and you may pass");
			_obstacle = new TrollBridge(this);
		}
		if (Game.VegHippie.Alive && PlayerTile.x == 25 && PlayerTile.y == 12){
			Game.dialogBox.AppendText("Lately my Tofu, Lettuce and Tomato Sandwich hasn't been cutting it");
		}
		if (Game.snake.Alive && PlayerTile.x == 0 && PlayerTile.y == 80){
			Game.dialogBox.AppendText("So charming and disarming (to a snake)");
		}
		if (!Game.gameWorld.DrawBridgeDropped && PlayerTile.x == 25 && PlayerTile.y == 83){
			Game.dialogBox.AppendText("Look at that lever on the other side of the moat!");
		}
		if (PlayerTile.x == 10 && PlayerTile.y == 93){
			Game.dialogBox.AppendText("I am one of the knights who says NI, you must bring me... a shrubbery!");
		}
		if (Game.defensiveTower.Alive && PlayerTile.x == 22 && PlayerTile.y == 91){
			Game.dialogBox.AppendText("Even the best defense can't overcome a good offense (or insult)");
		}
		if (Game.smokingGuard.Alive && PlayerTile.x == 25 && PlayerTile.y == 95){
			Game.dialogBox.AppendText("Make his habit blow up in his face");
		}
		if (!_wearingDisguise && (PlayerTile.x == 30 || PlayerTile.x == 31) && PlayerTile.y == 93){
			Game.dialogBox.AppendText("Find a way to hide in plain sight");
		}
		if (Game.guardDog.Alive && PlayerTile.x == 37 && PlayerTile.y == 90){
			Game.dialogBox.AppendText("Here fishy fish fish.  Hungry doggy?");
		}
		if (PlayerTile.x == 35 && PlayerTile.y == 94){
			// This is in front of the dragon chains
			Game.dialogBox.AppendText("Hacking isn't just for devs. Find something with teeth");
		}
		if (PlayerTile.x == 34 && PlayerTile.y == 94){
			// This is in front of the dragon 
			Game.dialogBox.AppendText("ME HUNGRY!");
		}
		if (PlayerTile.x == 37 && PlayerTile.y == 94){
			// This is in front of the princess 
			Game.dialogBox.AppendText("Isn't my precious dragon beautiful?!  Next I want a polar bear.");
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
