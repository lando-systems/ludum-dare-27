/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamedev.ld27.Game;

public abstract class OffensiveWeaponItem extends BaseItem {

	// time to draw this item as used
	protected float _animationTime = 1f;
	private float _range = 1.5f;
	private int _uses = 4;
	private boolean _isMelee = true;
	private TextureRegion _rangeImage;
	private float _rangeScale = 0.5f;
	
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
		_range = tileRange;
		if (melee) {
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
	
	protected void setRangeImage(TextureRegion texture, float scale) {
		_rangeImage = texture;
		_rangeScale = scale;
	}
	
	public TextureRegion getWeaponUseImage(int direction) {
		return (_rangeImage != null) ? _rangeImage : getTexture();
	}	
	
	public float getRangeScale() {
		return _rangeScale;
	}
	
	public float getRotation(int direction) {
		return 0f;
	}
	
	public boolean isSingleUse() {
		return _isMelee;
	}
}
