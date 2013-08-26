package com.gamedev.ld27.items.useful;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;
import com.gamedev.ld27.items.modifiers.Mushroom;

public class Shrubbery extends BaseItem {

	public Shrubbery() {
		super("Shrubbery", "This would make a good gift for an odd person");
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
		} else {
			Vector2 position = Game.player.getUsePosition();
			if (this.PlaceOnUnWalkable || Game.gameWorld.walkable(position))
			{
				Game.gameWorld.PlaceItem(this, position);
				Game.itemsBar.Remove(this);
				playUseSound();
			}
		}
	}
	
}
