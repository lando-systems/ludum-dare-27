package com.gamedev.ld27.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Skeleton;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.Utils.EStringJustify;

public class TitleScreen extends GameScreen {

	private OrthographicCamera camera;
	private Sprite sprite;

	public TitleScreen(Skeleton game) {
		super(game);

		camera = new OrthographicCamera(Config.screenWidth, Config.screenHeight);

		sprite = new Sprite(Assets.titleBackground);
		sprite.setSize(Config.screenWidth, Config.screenHeight);
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void update(float delta) {
		super.update(delta);

		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}

		if (Gdx.input.justTouched()) {
			game.setScreen(game.screens.get("Play"));
		}

		camera.update();
	}

	@Override
	public void render(float delta) {
		update(delta);

		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1.f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		Assets.batch.setProjectionMatrix(camera.combined);
		Assets.batch.begin();
		sprite.draw(Assets.batch);
		Assets.batch.end();
		
		Utils.drawText("LD27 - 10 Seconds", 20, 0, 16, 16, Color.BLACK, EStringJustify.CENTER);
	}

	@Override
	public void dispose() {
		
	}

}