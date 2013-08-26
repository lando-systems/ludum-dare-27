package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.modifiers.Mushroom;

public class Shrubbery extends BaseItem {

	public Shrubbery() {
		super("A Shrubbery", "This would make a good gift for an odd person");
		this.setIcon(Assets.aShrubbery);		
		
		setDefeats(GameSettings.KnightWhoSayNi);
	}

	@Override
	public void use(){
		if (Game.gameWorld.SameTile(Game.player.getUsePosition(), Game.knight.getPosition())){
			//TODO fix this dialog
			Game.dialogBox.AppendText("Thank you for the shrubbery");
			Game.itemsBar.Remove(this);
			Game.itemsBar.Add(new Mushroom());
			playUseSound();
		}
	}
	
}
