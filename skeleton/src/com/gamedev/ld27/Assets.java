package com.gamedev.ld27;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Assets {
	public static Random random;
	public static SpriteBatch batch;
	public static ShapeRenderer shapes;

	public static Music music;
	public static Sound boomerangSound;
	public static Sound fluteSound;
	public static Sound noodleSound;
	public static Sound hammerSound;
	public static Sound sawSound;
	public static Sound catSound;
	public static Sound mushroomSound;
	public static Sound slinkySound;
	public static Sound explodingCigarSound;
	public static Sound niSound;
	public static Sound aShrubberySound;
	public static Sound barkSound;
	
	public static Texture spritesheet;
	public static Texture titleBackground;
	public static Texture endBackground;
	public static Texture mapTiles;
	public static Texture mapTilesMushroom;
	public static Texture mapTilesGlasses;
	public static Texture itemsheet;
	public static Texture playerSheet;
	public static Texture playerHelmetSheet;

	public static TextureRegion[][] letters;
	public static TextureRegion[][] digits;
	public static TextureRegion[][] symbols;
	
	public static TextureRegion adbar;
	
	// 10 Secondzzzz!!!! ----------------------
	public static TextureRegion[] stopwatchFrames;
	
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
	public static TextureRegion cardboardBox;
	public static TextureRegion flute;
	public static TextureRegion disguise;
	public static TextureRegion eyeglasses;
	public static TextureRegion explodingCigar;
	public static TextureRegion hacksaw;
	public static TextureRegion redHerring;
	public static TextureRegion aShrubbery;	
	public static TextureRegion offensiveTower;
	public static TextureRegion defensiveTower;
	public static TextureRegion vegDude;
	public static TextureRegion commonGuard;
	public static TextureRegion smokingGuard;
	public static TextureRegion knightOfNi;
	public static TextureRegion dragon;
	public static TextureRegion dragonChains;
	public static TextureRegion dog;
	public static TextureRegion snake;
	public static TextureRegion princess;
	
	// offensive weapons use
	public static TextureRegion noWeapon;
	public static TextureRegion wetNoodleVert;	
	public static TextureRegion wetNoodleHor;	
	
	
	// obstacles
	public static TextureRegion troll;
	public static TextureRegion rock;


	public static void load() {
		random = new Random();
		batch  = new SpriteBatch();
		shapes = new ShapeRenderer();
 
		spritesheet  = new Texture(Gdx.files.internal("data/spritesheet.png"));
		spritesheet.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		itemsheet = new Texture(Gdx.files.internal("data/gameitems.png"));
		itemsheet.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		titleBackground = new Texture(Gdx.files.internal("data/dragon.png"));
		titleBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		endBackground = new Texture(Gdx.files.internal("data/dragonend.png"));
		endBackground.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		mapTiles = new Texture(Gdx.files.internal("data/maptiles.png"));
		mapTiles .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		mapTilesMushroom = new Texture(Gdx.files.internal("data/maptiles_mushroom.png"));
		mapTilesMushroom .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		mapTilesGlasses = new Texture(Gdx.files.internal("data/maptiles_glasses.png"));
		mapTilesGlasses .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		playerSheet = new Texture(Gdx.files.internal("data/playersheet.png"));
		playerSheet .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		playerHelmetSheet = new Texture(Gdx.files.internal("data/playersheet_helmet.png"));
		playerHelmetSheet .setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		adbar = splitAndGet(itemsheet, 256, 64, 0, 2, 1, 1)[0][0];
		
		// Key items ------------------------------
		TextureRegion[][] itemRow = splitAndGet(itemsheet, 32, 32, 0, 0, 20, 4);
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
		cardboardBox   = itemRow[0][10];
		flute          = itemRow[0][11];
		disguise       = itemRow[0][12];
		eyeglasses     = itemRow[0][13];
		explodingCigar = itemRow[0][14];
		hacksaw        = itemRow[0][15];
		redHerring     = itemRow[0][16];
		aShrubbery     = itemRow[0][17];	
		offensiveTower = itemRow[0][18];
		defensiveTower = itemRow[0][19];
		
		noWeapon	   = itemRow[1][11];
		wetNoodleHor   = itemRow[1][12];
		wetNoodleVert  = itemRow[1][13];
		
		// obstacles
		troll 		   = itemRow[3][0];
		rock 	       = itemRow[3][1];
		vegDude		   = itemRow[3][2];
		commonGuard    = itemRow[3][3];
		smokingGuard   = itemRow[3][4];
		knightOfNi     = itemRow[3][5];
		dragon         = itemRow[3][6];
		dragonChains   = itemRow[3][7];
		dog            = itemRow[3][8];
		snake          = itemRow[3][9];
		princess       = itemRow[3][10];
		
		// stopwatch
		stopwatchFrames = new TextureRegion[11];
		for (int i = 0; i < 11; ++i) {
			stopwatchFrames[i] = itemRow[2][i];
		}
		
		letters = splitAndGet(spritesheet, 8, 8, 0, 30, 26, 1);
		digits  = splitAndGet(spritesheet, 8, 8, 0, 31, 10, 1);
		symbols = splitAndGet(spritesheet, 8, 8, 10, 31, 18, 1);
		
		music = Gdx.audio.newMusic(Gdx.files.internal("data/dragon-and-toast.mp3"));
		music.setLooping(true);
		music.play();
		
		boomerangSound = Gdx.audio.newSound(Gdx.files.internal("data/boomerang.wav"));
		fluteSound = Gdx.audio.newSound(Gdx.files.internal("data/flute.mp3"));
		noodleSound = Gdx.audio.newSound(Gdx.files.internal("data/noodle.wav"));
		hammerSound = Gdx.audio.newSound(Gdx.files.internal("data/hammer.wav"));
		sawSound = Gdx.audio.newSound(Gdx.files.internal("data/saw.wav"));
		catSound = Gdx.audio.newSound(Gdx.files.internal("data/cat.wav"));
		mushroomSound = Gdx.audio.newSound(Gdx.files.internal("data/ohwow.wav"));
		slinkySound = Gdx.audio.newSound(Gdx.files.internal("data/slinky.mp3"));
		explodingCigarSound = Gdx.audio.newSound(Gdx.files.internal("data/explosion.wav"));
		niSound = Gdx.audio.newSound(Gdx.files.internal("data/ni.wav"));
		aShrubberySound = Gdx.audio.newSound(Gdx.files.internal("data/ashrubbery.wav"));
		barkSound = Gdx.audio.newSound(Gdx.files.internal("data/bark.wav"));
	}

	public static void dispose() {
		// TODO : dispose all the other things
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
