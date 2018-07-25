package com.machikoro.game.logic.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.other.TextButtonFactory;

/**
 * Created by unknown on 02.02.2018.
 */

public class TutorialScreen extends SimpleScreen {

    public TutorialScreen(MachiKoro game) {
        super(game);
        stage.addActor(buttonFactory.getBackButton());
    }


}
