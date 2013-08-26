package com.gamedev.ld27.items.useful;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;

public class Slinky extends Weapon {
	public Slinky() {
		super("Slinky", "A surprisingly effective grappling hook");
		this.setIcon(Assets.slinky);
		
		setProperties(4, 1);
		
		setDefeats(GameSettings.Abyss);
		setSound(Assets.slinkySound);
	}
	
	// no longer a weapon =(
	public void use() {
		if (Game.gameWorld.SameTile(Game.player.getPosition(), new Vector2(800, 2656)) && Game.player.getDirection() == Direction.North){
			Game.gameWorld.SetMapTile(23, 84, 5);
			Game.gameWorld.DrawBridgeDropped = true;
			Game.player.useWeapon(this);
			Game.itemsBar.Remove(this);
			playUseSound();			
		}
	}
}
