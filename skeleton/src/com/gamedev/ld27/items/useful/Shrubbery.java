package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class Shrubbery extends BaseItem {

	public Shrubbery() {
		super("A Shrubbery", "This would make a good gift for an odd person");
		this.setIcon(Assets.aShrubbery);		
		
		setDefeats(GameSettings.KnightWhoSayNi);
	}

}
