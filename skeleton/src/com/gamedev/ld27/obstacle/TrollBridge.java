package com.gamedev.ld27.obstacle;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.gameobjects.Player;

public class TrollBridge extends BaseObstacle {

	private Player _player;
	private float _time;
	
	public TrollBridge(Player player) {		
		super("Troll Bridge", "Like a toll bridge, but with an extra R", GameSettings.TrollBridge);
		
		_player = player;
		Vector2 position = player.getPosition().cpy();
		if (player.getDirection() == Direction.East) {
			position.x += 32;
		} else {
			position.x -= 32;
		}
		
		setPosition(position);
		
		Game.dialogBox.SetText("<Binary Troll> Rrrarr");
		Game.dialogBox.AppendText(" You have 10 seconds to pay a troll to cross this bridge!");
	}
	
	public void update(float delta) {
		_time += delta;
		if (_time > 2.0) {
			
		}
	}
	
	public void render(SpriteBatch batch) {
		drawTroll(batch);
	}
	
	private void drawTroll(SpriteBatch batch) {
		fill(Color.RED);
	}
}
