package com.machikoro.game.logic.other;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.screens.PlayPreparationScreen;
import com.machikoro.game.logic.screens.SettingsScreen;
import com.machikoro.game.logic.screens.TutorialScreen;

import javax.crypto.Mac;

/**
 * Created by unknown on 24.06.2018.
 */

public class TextButtonFactory {

    private static final String PLAY = "Play";
    private static final String RULES = "Rules";
    private static final String SETTINGS = "Settings";
    private static final String EXIT = "Exit";
    private static final String BACK = "Back";
//    private static final String BUTTON_IMAGE = "buttons/simple_button.pack";
    private static final float BACK_BUTTON_X = 20f;
    private static final float BACK_BUTTON_Y = 20f;
    private MachiKoro game;

    public TextButtonFactory(MachiKoro game) {
        this.game = game;
    }

    private TextButton getMenuButton(String text, ButtonListener listener){
        TextButton  btn = new TextButton(text, MachiKoro.getSkin());
        btn.setSize(MachiKoro.btnWidth, MachiKoro.btnHeight);
        btn.addListener(listener);
        return btn;
    }

    public Array<TextButton> getMainMenuButtons(){
        Array<TextButton> buttons = new Array<TextButton>();

        buttons.add(getMenuButton(PLAY, new ButtonListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.getManager().push(new PlayPreparationScreen(game));
            }
        }));
        buttons.add(getMenuButton(SETTINGS, new ButtonListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.getManager().push(new SettingsScreen(game));
            }
        }));
        buttons.add(getMenuButton(RULES, new ButtonListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.getManager().push(new TutorialScreen(game));
            }
        }));
        ButtonListener exitListener = new ButtonListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
        };
        buttons.add(getMenuButton(EXIT, exitListener));
        setButtonPositions(buttons);
        return buttons;

    }

    public TextButton getBackButton(){
        TextButton btn = new TextButton(BACK, MachiKoro.getSkin());
        btn.setSize(MachiKoro.btnWidth, MachiKoro.btnHeight);
        btn.addListener(new ButtonListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.getManager().pop();
            }
        });
        btn.setPosition(BACK_BUTTON_X, BACK_BUTTON_Y);
        return btn;
    }

    private void setButtonPositions(Array<TextButton> buttons){
        for (int i = 0; i < buttons.size; i++){
            buttons.get(i).setPosition(0, MachiKoro.btnHeight * 1.2f * (buttons.size - 1 - i));
        }
    }


}
