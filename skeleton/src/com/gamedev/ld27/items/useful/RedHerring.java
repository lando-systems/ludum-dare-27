package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.modifiers.Eyeglasses;

public class RedHerring extends BaseItem {

	public RedHerring() {
		super("Red Herring", "Probably useless... but it does look tasty");
		this.setIcon(Assets.redHerring);		
		
		setDefeats(GameSettings.GuardDog);
	}
	
	@Override
	public void use(){
		if (Game.gameWorld.SameTile(Game.player.getUsePosition(), Game.guardDog.getPosition())){
			//TODO fix this dialog
			Game.dialogBox.AppendText("He loves that Red Herring");
			Game.itemsBar.Remove(this);
			Game.itemsBar.Add(new Eyeglasses());
			Game.guardDog.Alive = false;
			playUseSound();
		}
	}

}
