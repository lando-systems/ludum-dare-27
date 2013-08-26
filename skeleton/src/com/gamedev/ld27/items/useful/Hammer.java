package com.gamedev.ld27.items.useful;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.Weapon;
import com.gamedev.ld27.obstacle.Rock;

public class Hammer extends Weapon {
	
	public Hammer() {
		super("Hammer", "Mainly used for the smashing");
		setIcon(Assets.hammer);
		
		setProperties(1, 3);
		Damage = 1;
		setDefeats(GameSettings.Rocks);
		setSound(Assets.hammerSound);
	}
	
	@Override 
	public void SpecialDamage(Vector2 pos) {
		for (BaseItem item : Game.gameWorld.worldItems){
			if (Game.gameWorld.SameTile(pos, item.getPosition()) && item instanceof Rock) item.Alive = false;
		}
	}
}
