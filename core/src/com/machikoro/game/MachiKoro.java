package com.machikoro.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.machikoro.game.logic.screens.MainMenuScreen;
import com.machikoro.game.logic.screens.ScreenManager;

public class MachiKoro extends Game {

	private SpriteBatch sb;
	private static final String BACKGROUND = "background.png";
	private static final String SKIN_PATH = "glassyui/ui.json";
	public static final String TITLE = "Machi Koro";
	public static float width, height, btnWidth, btnHeight;
	private OrthographicCamera camera;
	public static Texture background;
	private ScreenManager manager;
	private static Skin skin;

	@Override
	public void create () {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		btnHeight = width/19;
		btnWidth = width/7;
		sb = new SpriteBatch();
		background = new Texture(BACKGROUND);
		skin = new Skin(Gdx.files.internal(SKIN_PATH));
		manager = new ScreenManager(this);
//		Gdx.input.setCatchBackKey(true);

	}

	@Override
	public void render () {
		manager.render(Gdx.graphics.getDeltaTime());
	}
	
	@Override
	public void dispose () {
		sb.dispose();
		background.dispose();
	}

	public SpriteBatch getSb() {
		return sb;
	}

	public ScreenManager getManager() {
		return manager;
	}

	public static Skin getSkin(){
		return skin;
	}
}
