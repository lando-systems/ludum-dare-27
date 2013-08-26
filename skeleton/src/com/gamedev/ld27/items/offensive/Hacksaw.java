package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;
import com.gamedev.ld27.items.modifiers.Eyeglasses;

public class Hacksaw extends Weapon {

	public Hacksaw() {
		super("Hacksaw", "Able to cut the mightiest of chains!");
		setIcon(Assets.hacksaw);
		
		setProperties(1, 10);
		
		setDefeats(GameSettings.DragonChain);
	}
	
	@Override
	public void use(){
		if (Game.gameWorld.SameTile(Game.player.getUsePosition(), Game.dragonShackles.getPosition())){
			//TODO fix this dialog
			Game.dialogBox.AppendText("");
			Game.itemsBar.Remove(this);
			Game.player.Alive = false;
			playUseSound();
		}
	}
}
