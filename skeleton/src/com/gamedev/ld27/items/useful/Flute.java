package com.gamedev.ld27.items.useful;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Flute extends BaseItem {
	public Flute() {
		super("Flute", "play a relaxing tune");
		this.setIcon(Assets.flute);
		
		setDefeats(GameSettings.Snake);
		setSound(Assets.fluteSound);
	}
	
	public void use() {
		this.playUseSound();
		if (Game.gameWorld.SameTile(Game.player.getPosition(), new Vector2(0*32,80*32)) && Game.player.getDirection() == Direction.North){
			Game.snake.Alive = false;
			Game.itemsBar.Remove(this);
			Game.itemsBar.Add(new CardboardBox());
			// TODO : dialog
		}
	}
}
