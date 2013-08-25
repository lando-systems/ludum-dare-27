package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Helmet extends BaseItem {
	public Helmet() {
		super("Helmet", "protect your noggin");
		this.setIcon(Assets.helmet);
		
		setDefeats(GameSettings.Avalanche);
	}
	
	@Override
	public void use(){
		Game.dialogBox.AppendText("I wonder where this is from?");
		Game.itemsBar.Remove(this);
		Game.player.SetWearingHelm();
		playUseSound();
	}
}
