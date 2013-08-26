package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.modifiers.Mushroom;

public class ExplodingCigar extends BaseItem {

	public ExplodingCigar() {
		super("Exploding Cigar", "Smoking can be hazardous to your health");
		
		setIcon(Assets.explodingCigar);
		setDefeats(GameSettings.SmokingGuard);
	}

	@Override
	public void use(){
		if (Game.gameWorld.SameTile(Game.player.getUsePosition(), Game.smokingGuard.getPosition())){
			//TODO fix this dialog
			Game.dialogBox.AppendText("Thanks I can use a Smoke");
			Game.itemsBar.Remove(this);
			Game.smokingGuard.Alive = false;
			playUseSound();
		}
	}
}
