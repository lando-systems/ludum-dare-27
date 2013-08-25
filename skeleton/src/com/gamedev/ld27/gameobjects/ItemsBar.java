package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.items.BaseItem;

public class ItemsBar extends GameObject {

	private BaseItem[] _items = new BaseItem[10];
	
	private float _itemHeight;
	
	public ItemsBar(Rectangle bounds) {
		super(bounds);
		
		_itemHeight = bounds.height / _items.length;
	}
	
	public boolean Add(BaseItem item) {
		return Add(item, FindEmptySlot());
	}
	
	public boolean Add(BaseItem item, int index) {
		boolean added = false;
		
		if (item != null) {
			if (index >= 0 && index < _items.length) {
				_items[index] = item;
				setBounds(item, index);
				added = true;
			}
		}
		return added;
	}
	
	private int FindEmptySlot() {
		for (int i = 0; i < _items.length; i++) {
			if (_items[i] == null) { 
				return i;
			}
		}
		return -1;
	}
	
	private void setBounds(BaseItem item, int index) {
		float top = _bounds.y + _bounds.height;
		top -= (index + 1) * _itemHeight;
		item.setPosition(new Vector2(_bounds.x + ((_bounds.width - item.getWidth())/2),
				top + ((_itemHeight - item.getHeight())/2)));		
	}
	
	@Override
	public void render(SpriteBatch batch) {
		Fill(Color.BLACK, Color.BLUE);
		
		for (BaseItem item : _items) {
			if (item != null) {
				item.render(batch);
			}
		}
	}

	@Override
	public void update(float delta) {
		for (BaseItem item : _items) {
			if (item != null) {
				item.update(delta);
			}
		}
	}
}
