package com.machikoro.game.logic.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.other.Play;
import com.machikoro.game.logic.other.Player;
import com.machikoro.game.logic.other.PlayerAvatar;

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
        stage.addActor(buttonFactory.getBackButton());
        stage.addActor(playersNumberLabel);
        Player player1 = new Player(1);
        Group group1 = player1.getEditView();
        group1.setPosition(MachiKoro.width / 2, MachiKoro.height / 2);
        stage.addActor(group1);

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
