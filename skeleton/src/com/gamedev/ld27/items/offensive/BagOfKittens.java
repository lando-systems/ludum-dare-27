package com.gamedev.ld27.items.offensive;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.items.RangeWeapon;

public class BagOfKittens extends RangeWeapon {

	public BagOfKittens() {
		super("Bag of Kittens", "This is a bag and it's full of kittens with razor sharp claws");
		setIcon(Assets.bagOfKittens);
		
		setProperties(3, 5, 1);
	}
}
