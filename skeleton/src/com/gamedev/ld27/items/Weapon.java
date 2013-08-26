/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Game;

public abstract class Weapon extends BaseItem {

	// time to draw this item as used
	protected float _animationTime = 1f;
	private float _range = 1.5f;
	private int _uses = 3;
	protected boolean _isMelee = true;
	public int Damage = 0;
	
	protected Weapon(String name, String description) {
		super(name, description);
	}
	
	protected void setProperties(float tileRange, int uses) {
		setProperties(tileRange, uses, 1f);
	}
	
	/**
	 * 
	 * @param melee boolean
	 * @param tileRange number of tiles
	 * @param uses number of uses before gone
	 * @param speed speed of animation
	 */
	protected void setProperties(float tileRange, int uses, float speed)
	{
		_range = tileRange;
		if (_isMelee) {
			_range += 0.5f;
		}
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
		return getTexture();
	}	
	
	public boolean isSingleUse() {
		return _isMelee;
	}
	
	public void SpecialDamage(Vector2 pos)
	{
		
	}
}
