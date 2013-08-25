package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.items.BaseItem;

public class ItemsBar extends GameObject {

	private BaseItem[] _items = new BaseItem[10];
	
	private float _itemHeight;
	private int _selectedIndex = -1;
	private Rectangle _selectionBounds;
	
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
				
				if (_selectedIndex == -1) {
					selectNext(true);
				}				
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
		Rectangle itemBounds = getItemBounds(index);
		item.setPosition(new Vector2(itemBounds.x + ((itemBounds.width - item.getWidth())/2),
				itemBounds.y + ((itemBounds.height - item.getHeight())/2)));		
	}
	
	private Rectangle getItemBounds(int index) {
		float top = _bounds.y + _bounds.height;
		top -= (index + 1) * _itemHeight;
		return new Rectangle(_bounds.x, top, _bounds.width, _itemHeight);
	}
	
	public void selectNext(boolean down) {
		int index = _selectedIndex;
		
		int search = _items.length;
		while (search-- > 0) {
			if (down) {
				if (++index == _items.length) {
					index = 0;
				}
			} else if (--index < 0) {
				index = _items.length -1;
			}
			
			if (_items[index] != null) {
				_selectedIndex = index;
				_selectionBounds = Utils.inflate(getItemBounds(index), -30, -10);
				break;
			}
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		fill(Color.BLACK, Color.BLUE);
		
		drawSelector();
		
		for (BaseItem item : _items) {
			if (item != null) {
				item.render(batch);
			}
		}
	}
	
	private void drawSelector() {
		if (_selectedIndex != -1) {
			drawRect(_selectionBounds, Color.RED);
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
