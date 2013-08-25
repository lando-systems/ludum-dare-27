package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Bacon extends BaseItem {
	public Bacon() {
		super("Bacon", "None can resist its awesome power");
		
		setIcon(Assets.bacon);
		setDefeats(GameSettings.Vegetarian);
	}
}
