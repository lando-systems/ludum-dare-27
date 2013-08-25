/**
 * Items that can be used to defeat an obstacle
 */
package com.gamedev.ld27.items;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RangeWeapon extends Weapon {

	private TextureRegion _rangeImage;
	private float _rangeScale = 0.5f;
	
	protected RangeWeapon(String name, String description) {
		super(name, description);
		_isMelee = false;
	}
	
	protected void setRangeImage(TextureRegion texture, float scale) {
		_rangeImage = texture;
		_rangeScale = scale;
	}
	
	public TextureRegion getWeaponUseImage(int direction) {
		return (_rangeImage != null) ? _rangeImage : super.getWeaponUseImage(direction);
	}	
	
	public float getRangeScale() {
		return _rangeScale;
	}
	
	public float getRotation(int direction) {
		return 0f;
	}
	
	public boolean doesReturn() {
		return false;
	}
}
