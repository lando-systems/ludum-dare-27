package com.gamedev.ld27;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Assets {
	public static Random random;
	public static SpriteBatch batch;
	public static ShapeRenderer shapes;

	public static Texture spritesheet;
	public static Texture titleBackground;
	public static Texture mapTiles;
	public static Texture itemsheet;

	public static TextureRegion[][] letters;
	public static TextureRegion[][] digits;
	public static TextureRegion[][] symbols;
	
	public static TextureRegion wetNoodle;
	public static TextureRegion bagOfJewels;
	public static TextureRegion hammer;
	public static TextureRegion boomerang;
	public static TextureRegion bombs;
	public static TextureRegion mushroom;

	public static void load() {
		random = new Random();
		batch  = new SpriteBatch();
		shapes = new ShapeRenderer();
 
		spritesheet  = new Texture(Gdx.files.internal("data/spritesheet.png"));
		spritesheet.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		itemsheet = new Texture(Gdx.files.internal("data/gameitems.png"));
		itemsheet.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		titleBackground = new Texture(Gdx.files.internal("data/libgdx.png"));
		titleBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		mapTiles = new Texture(Gdx.files.internal("data/maptiles.png"));
		mapTiles .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		TextureRegion[][] itemRow = splitAndGet(itemsheet, 32, 32, 0, 0, 20, 1);
		wetNoodle   = itemRow[0][0];
		bagOfJewels = itemRow[0][1];
		hammer      = itemRow[0][2];
		boomerang   = itemRow[0][3];
		bombs       = itemRow[0][4];
		mushroom    = itemRow[0][5];		
		
		letters = splitAndGet(spritesheet, 8, 8, 0, 30, 26, 1);
		digits  = splitAndGet(spritesheet, 8, 8, 0, 31, 10, 1);
		symbols = splitAndGet(spritesheet, 8, 8, 10, 31, 18, 1);
	}

	public static void dispose() {
		mapTiles.dispose();
		titleBackground.dispose();
		spritesheet.dispose();
		batch.dispose();
	}

	private static TextureRegion[][] splitAndGet(Texture texture, int width, int height, int col, int row, int xTiles, int yTiles) {
		TextureRegion[][] allRegions = TextureRegion.split(texture, width, height);
		TextureRegion[][] regions = new TextureRegion[yTiles][xTiles];
		for (int y = 0; y < yTiles; ++y) {
			for (int x = 0; x < xTiles; ++x) {
				regions[y][x] = allRegions[row + y][col + x];
			}
		}
		return regions;
	}

}
