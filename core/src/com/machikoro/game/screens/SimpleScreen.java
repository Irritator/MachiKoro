package com.machikoro.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.other.TextButtonFactory;

/**
 * Created by unknown on 04.02.2018.
 */

public class SimpleScreen implements Screen {

    protected final MachiKoro game;
    protected Stage stage;
    protected TextButtonFactory buttonFactory;

    public SimpleScreen(final MachiKoro game){
        this.game = game;
        stage = new Stage();
        buttonFactory = new TextButtonFactory(game);
    }

    @Override
    public void show() {

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSb().begin();
        game.getSb().draw(MachiKoro.background, 0, 0, MachiKoro.width, MachiKoro.height);
        game.getSb().end();
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}
