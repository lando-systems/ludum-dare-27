package com.gamedev.ld27.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Game;

public class Stopwatch extends GameObject {
	
	private float _stateTime;
	private Animation _anim;
	private Vector2 _screenPos;
	
	public Stopwatch(Rectangle bounds) {
		super(bounds);
		_stateTime = 0.f;
		_anim = new Animation(1.f, Assets.stopwatchFrames);
		_screenPos = new Vector2();
	}
	
	@Override
	public void update(float delta) {
		if (_stateTime < 11.f) {
			_stateTime += delta;
		} else {
			_stateTime = 0.f;
			Alive = false;
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		TextureRegion tex = _anim.getKeyFrame(_stateTime);
		_screenPos = Game.gameWorld.worldPosToScreenMapPos(new Vector2(_bounds.x, _bounds.y));
		batch.draw(tex, _screenPos.x, _screenPos.y, _bounds.width, _bounds.height);
	}

}
