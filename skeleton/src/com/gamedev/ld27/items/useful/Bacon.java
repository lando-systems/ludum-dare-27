package com.gamedev.ld27.items.useful;

import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Direction;
import com.gamedev.ld27.Game;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Bacon extends BaseItem {
	public Bacon() {
		super("Bacon", "None can resist its awesome power");
		setAdDescription("PITA: people eating tasty animals?  Bacon can overcome conviction");
		setIcon(Assets.bacon);
		setDefeats(GameSettings.Vegetarian);
	}
	
	public void use() {
		if (Game.gameWorld.SameTile(Game.player.getUsePosition(), Game.VegHippie.getPosition())){
			Game.VegHippie.Alive = false;
			Game.itemsBar.Remove(this);
			Game.itemsBar.Add(new Disguise());
			// TODO : dialog
			Game.dialogBox.AppendText("You got a Disguise!");
		}
	}
}
