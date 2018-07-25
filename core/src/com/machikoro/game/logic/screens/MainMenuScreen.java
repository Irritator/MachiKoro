package com.machikoro.game.logic.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.other.TextButtonFactory;

/**
 * Created by unknown on 02.02.2018.
 */

public class MainMenuScreen extends SimpleScreen {


    public MainMenuScreen(final MachiKoro game){
        super(game);
        Group buttonGroup = getButtonGroup(buttonFactory.getMainMenuButtons());
        stage.addActor(buttonGroup);

    }

    private Group getButtonGroup(Array<TextButton> buttons){
        Group buttonGroup = new Group();
        for (TextButton btn : buttons){
            buttonGroup.addActor(btn);
        }
        buttonGroup.setPosition(MachiKoro.width/2 - MachiKoro.btnWidth/2, MachiKoro.height/2 - MachiKoro.btnHeight * 2.4f);
        return buttonGroup;
    }
}
