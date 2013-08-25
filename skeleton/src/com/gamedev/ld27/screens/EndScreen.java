package com.gamedev.ld27.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.gamedev.ld27.Assets;
import com.gamedev.ld27.Config;
import com.gamedev.ld27.Skeleton;
import com.gamedev.ld27.Utils;
import com.gamedev.ld27.Utils.EStringJustify;

public class EndScreen extends GameScreen {

	private OrthographicCamera camera;
	private Sprite sprite;

	public EndScreen(Skeleton game) {
		super(game);

		camera = new OrthographicCamera(Config.screenWidth, Config.screenHeight);

		sprite = new Sprite(Assets.endBackground);
		sprite.setSize(Config.screenWidth, Config.screenHeight);
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void update(float delta) {
		super.update(delta);

		if (Gdx.input.justTouched()) {
			Gdx.app.exit();
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
		
		Utils.drawText("Thank you for playing " + Config.title, 20, 300, 24, 24, Color.LIGHT_GRAY, EStringJustify.CENTER);
		
		float introTextX = 10 - Config.screenHalfWidth;
		float introTextY = 10 - Config.screenHalfHeight;
		float introTextHeight = 16;
		
		ArrayList<String> introText = new ArrayList<String>();
		introText.add("The dragon has packed you and the princess up for snacks on its journey home");
		introText.add("It's never wise to free a dragon.  no matter how evil the princess");
		for(int i = 0; i < introText.size();  i++)
		{
			Utils.drawText(introText.get(i), introTextX, introTextY + ((introTextHeight+1) * (introText.size() - i)), 16, 16, Color.LIGHT_GRAY, EStringJustify.LEFT);
		}
	}

	@Override
	public void dispose() {
		
	}

}