package com.gamedev.ld27.items;

import com.gamedev.ld27.Assets;
import com.gamedev.ld27.items.modifiers.Mushroom;
import com.gamedev.ld27.items.offensive.*;
import com.gamedev.ld27.items.useful.*;
import com.gamedev.ld27.obstacle.*;

public class ItemFactory {

	private static String[] items = {"WetNoodle","BagOfJewels", "BagOfKittens", "Boomerang", "Hammer", "Bombs", "RedHerring", "Shrubbery"};
	
	private static String[] killItems = {"WetNoodle","BagOfJewels", "BagOfKittens", "Bacon", "Boomerang", "Hammer", "Bombs", "RedHerring", "Shrubbery"};
	
	public static BaseItem GetRandomItem()
	{
		return getItem(items[Assets.random.nextInt(items.length)]);
	}
	
	public static BaseItem GetRandomKillItem()
	{
		return getItem(killItems[Assets.random.nextInt(killItems.length)]);
	}
	
	public static BaseItem getItem(String name)
	{
		if (name.equals("WetNoodle")) return new WetNoodle();
		if (name.equals("BagOfJewels")) return new BagOfJewels();
		if (name.equals("BagOfKittens")) return new BagOfKittens();
		if (name.equals("Hacksaw")) return new Hacksaw();
		if (name.equals("OffensiveTower")) return new OffensiveTower();
		if (name.equals("Bacon")) return new Bacon();
		if (name.equals("Bombs")) return new Bombs();
		if (name.equals("Boomerang")) return new Boomerang();
		if (name.equals("Flute")) return new Flute();
		if (name.equals("Hammer")) return new Hammer();
		if (name.equals("Helmet")) return new Helmet();
		if (name.equals("Slinky")) return new Slinky();
		if (name.equals("Mushroom")) return new Mushroom();
		if (name.equals("ExplodingCigar")) return new ExplodingCigar();
		if (name.equals("Snake")) return new Snake();
		if (name.equals("KnightWhoSaysNi")) return new KnightWhoSaysNi();
		if (name.equals("Shrubbery")) return new Shrubbery();
		if (name.equals("RedHerring")) return new RedHerring();
		
		return null;
	}
}
