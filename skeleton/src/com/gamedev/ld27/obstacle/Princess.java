package com.gamedev.ld27.obstacle;


import com.gamedev.ld27.Assets;
import com.gamedev.ld27.GameSettings;

public class Princess extends BaseObstacle {


	public Princess() {
		super("Princess", "The dragon is in chains and has to be released from them", GameSettings.DragonChain);
		this.setIcon(Assets.princess);

	}
	

}
