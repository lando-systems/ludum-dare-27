package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.GameSettings;
import com.gamedev.ld27.items.Weapon;

public class BinaryQuestion extends Weapon {

	public BinaryQuestion() {
		super("Question", "There are 10 types of people in the world.  Those who understand this riddle and those that don't.");

		setDefeats(GameSettings.TrollBridge);
	}
}
