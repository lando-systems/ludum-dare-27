package com.gamedev.ld27.items.useful;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.BaseItem;

public class RedHerring extends BaseItem {

	public RedHerring() {
		super("Red Herring", "Probably useless... but it does look tasty");
		this.setIcon(Assets.redHerring);		
		
		setDefeats(GameSettings.GuardDog);
	}

}
