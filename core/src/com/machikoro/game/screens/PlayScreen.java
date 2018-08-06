package com.machikoro.game.screens;

import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.other.Play;

/**
 * Created by unknown on 02.02.2018.
 */

public class PlayScreen extends SimpleScreen {

    private Play play;

    public PlayScreen(MachiKoro game, Play play) {
        super(game);
        this.play = play;
    }

}
