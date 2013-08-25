/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;

public abstract class OffensiveWeaponItem extends BaseItem {

	// time to draw this item as used
	protected float _animationTime = 1f;
	private float _range = 1.5f;
	private int _uses = 4;
	private boolean _isMelee = true;		
	
	protected OffensiveWeaponItem(String name, String description) {
		super(name, description);
	}
	
	protected void setProperties(boolean melee, float tileRange, int uses) {
		setProperties(melee, tileRange, uses, 1f);
	}
	
	/**
	 * 
	 * @param melee boolean
	 * @param tileRange number of tiles
	 * @param uses number of uses before gone
	 * @param speed speed of animation
	 */
	protected void setProperties(boolean melee, float tileRange, int uses, float speed)
	{
		_isMelee = melee;
		_range = tileRange + 0.5f;
		_uses = uses;
		_animationTime = speed;		
	}

	public float animationTime() {
		return _animationTime;
	}
	
	public boolean isMeleeWeapon() {
		return _isMelee;
	}
	
	public float getRange() {
		return _range;
	}
	
	public void use() {
		if (Game.player.useWeapon(this) && (--_uses <= 0)) {
			Game.itemsBar.Remove(this);
		}
	}
	
	public TextureRegion getWeaponUseImage(int direction) {
		return Assets.noWeapon;
	}	
}
