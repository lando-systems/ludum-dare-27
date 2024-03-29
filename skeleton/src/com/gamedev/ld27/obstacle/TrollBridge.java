package com.gamedev.ld27.obstacle;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.gameobjects.Player;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.ItemFactory;

public class TrollBridge extends BaseObstacle {

	private float _time;
	private Sprite trollSprite;
	public static boolean Spawned = false;
	
	public TrollBridge(Player player) {		
		super("Troll Bridge", "Like a toll bridge, but with an extra R", GameSettings.TrollBridge);
		_walkable = false;
		trollSprite = new Sprite(Assets.troll);
		Vector2 position = player.getPosition().cpy();
		if (player.getDirection() == Direction.East) {
			position.x += 32;
		} else {
			position.x -= 32;
		}
		
		setPosition(position);
		Spawned = true;
		BaseItem cigar = ItemFactory.getItem("ExplodingCigar");
		Game.gameWorld.PlaceItem(cigar, position);
		Game.dialogBox.SetText(" You have 10 seconds to pay a troll to cross this bridge!");
		Game.dialogBox.AppendText("<Binary Troll> Rrrarr");		
	}
	
	public void update(float delta) {
		_time += delta;
		if (_time > 2.0) {
			Rock rock = new Rock();		
			rock.setPosition(pos);
			Game.gameWorld.PlaceItem(rock, pos);
			_completed = true;
		}
	}
	
	public void render(SpriteBatch batch) {
		drawTroll(batch);
	}
	
	private void drawTroll(SpriteBatch batch) {
		Game.gameWorld.screenPositionFromWorld(trollSprite, pos);
		trollSprite.draw(batch);
	}
}
