package com.machikoro.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.machikoro.game.MachiKoro;

import java.util.Stack;

/**
 * Created by unknown on 05.02.2018.
 */

public class ScreenManager {
    private Stack<Screen> screens;
    private MachiKoro game;
    private SpriteBatch sb;

    public ScreenManager(MachiKoro game){
        this.game = game;
        screens = new Stack<Screen>();
        push(new MainMenuScreen(game));

    }

    public void pop(){
        Screen oldScreen = screens.pop();
        oldScreen.dispose();
        game.setScreen(screens.peek());
        Gdx.input.setInputProcessor(((SimpleScreen) screens.peek()).getStage());
    }

    public void push(Screen screen){
        screens.push(screen);
        game.setScreen(screen);
        Gdx.input.setInputProcessor(((SimpleScreen) screen).getStage());
    }

    public void render(float dt){
        screens.peek().render(dt);
    }

}
