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
	public static Texture playerSheet;

	public static TextureRegion[][] letters;
	public static TextureRegion[][] digits;
	public static TextureRegion[][] symbols;
	
	// Key items ------------------------------
	public static TextureRegion wetNoodle;
	public static TextureRegion bagOfJewels;
	public static TextureRegion hammer;
	public static TextureRegion boomerang;
	public static TextureRegion bombs;
	public static TextureRegion mushroom;	
	public static TextureRegion bacon;
	public static TextureRegion slinky;
	public static TextureRegion helmet;
	public static TextureRegion bagOfKittens;
	public static TextureRegion sillyString;
	public static TextureRegion flute;
	public static TextureRegion cardboardBox;
	public static TextureRegion bubbleWrap;
	public static TextureRegion star;
	public static TextureRegion ductTape;
	public static TextureRegion disguise;
	public static TextureRegion potatoCannon;
	public static TextureRegion offensiveTower;
	public static TextureRegion boxOfPuppies;
	public static TextureRegion eyeglasses;
	public static TextureRegion bouncyBall;
	public static TextureRegion map;
	public static TextureRegion spork;
	public static TextureRegion plunger;
	public static TextureRegion explodingCigar;
	public static TextureRegion hacksaw;
	public static TextureRegion torch;
	public static TextureRegion bottleOfAcid;
	public static TextureRegion redHerring;
	public static TextureRegion aShrubbery;	

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
		
		playerSheet = new Texture(Gdx.files.internal("data/playersheet.png"));
		playerSheet .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		// Key items ------------------------------
		TextureRegion[][] itemRow = splitAndGet(itemsheet, 32, 32, 0, 0, 20, 2);
		wetNoodle      = itemRow[0][0];
		bagOfJewels    = itemRow[0][1];
		hammer         = itemRow[0][2];
		boomerang      = itemRow[0][3];
		bombs          = itemRow[0][4];
		mushroom       = itemRow[0][5];		
		bacon          = itemRow[0][6];
		slinky         = itemRow[0][7];
		helmet         = itemRow[0][8];
		bagOfKittens   = itemRow[0][9];
		sillyString    = itemRow[0][10];
		flute          = itemRow[0][11];
		cardboardBox   = itemRow[0][12];
		bubbleWrap     = itemRow[0][13];
		star           = itemRow[0][14];
		ductTape       = itemRow[0][15];
		disguise       = itemRow[0][16];
		potatoCannon   = itemRow[0][17];
		offensiveTower = itemRow[0][18];
		boxOfPuppies   = itemRow[0][19];
		eyeglasses     = itemRow[1][0];
		bouncyBall     = itemRow[1][1];
		map            = itemRow[1][2];
		spork          = itemRow[1][3];
		plunger        = itemRow[1][4];
		explodingCigar = itemRow[1][5];
		hacksaw        = itemRow[1][6];
		torch          = itemRow[1][7];
		bottleOfAcid   = itemRow[1][8];
		redHerring     = itemRow[1][9];
		aShrubbery     = itemRow[1][10];
		
		letters = splitAndGet(spritesheet, 8, 8, 0, 30, 26, 1);
		digits  = splitAndGet(spritesheet, 8, 8, 0, 31, 10, 1);
		symbols = splitAndGet(spritesheet, 8, 8, 10, 31, 18, 1);
	}

	public static void dispose() {
		itemsheet.dispose();
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
