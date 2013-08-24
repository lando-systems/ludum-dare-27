package com.gamedev.ld27.screens;

import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamedev.ld27.Skeleton;

public abstract class GameScreen implements Screen {

	public static final TweenManager tweenMgr = new TweenManager();
	public static final SpriteBatch batch = new SpriteBatch();
	
	protected Skeleton game;

	public GameScreen(Skeleton game) { this.game = game; }

	public void update(float delta) {
		tweenMgr.update(delta);
	}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}
	
	@Override
	public void resize(int width, int height) {}

}