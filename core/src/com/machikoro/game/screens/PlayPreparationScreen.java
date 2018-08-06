package com.machikoro.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.other.ButtonListener;
import com.machikoro.game.logic.other.Play;

/**
 * Created by unknown on 02.02.2018.
 */

public class PlayPreparationScreen extends SimpleScreen{
    private static final String NUM_OF_PLAYERS = "Number of players: ";
    private static final String SIMPLE_BUTTON_PATH = "buttons/simple_button.pack";
    BitmapFont font;

    private Play play;
    private Label playersNumberLabel;
    private Array<Label> names;
    private Group playersGroup;


    public PlayPreparationScreen(final MachiKoro game) {
        super(game);
        play = new Play(stage);
        initNumOfPlayersLabel();
        stage.addActor(buttonFactory.makeBackButton());
        stage.addActor(playersNumberLabel);
        stage.addActor(buttonFactory.makeAddPlayerButton(new ButtonListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                play.addPlayer();
            }
        }));
        stage.addActor(buttonFactory.makeStartButton(new ButtonListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.getManager().pop();
                game.getManager().push(new PlayScreen(game, play));
            }
        }));
    }



    private void initNumOfPlayersLabel(){
        playersNumberLabel = new Label(NUM_OF_PLAYERS + play.getNumOfPlayers(), getLabelStyle());
        playersNumberLabel.setPosition(MachiKoro.width * 0.02f, MachiKoro.height * 0.9f);
    }

    private Label.LabelStyle getLabelStyle(){
        font = new BitmapFont();
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.fontColor = Color.WHITE;
        labelStyle.font = font;
        return labelStyle;
    }

    @Override
    public void dispose(){
        super.dispose();
        play.dispose();
        font.dispose();
    }
}
