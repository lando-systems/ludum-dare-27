package com.gamedev.ld27;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Config.title;
		cfg.useGL20 = Config.useGL20;
		cfg.width = Config.screenWidth;
		cfg.height = Config.screenHeight;
		
		new LwjglApplication(new Skeleton(), cfg);
	}
}
