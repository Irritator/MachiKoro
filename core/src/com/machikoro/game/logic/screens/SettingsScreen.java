package com.machikoro.game.logic.screens;

import com.machikoro.game.MachiKoro;

/**
 * Created by unknown on 02.02.2018.
 */

public class SettingsScreen extends SimpleScreen {

    public SettingsScreen(MachiKoro game) {
        super(game);
        stage.addActor(buttonFactory.makeBackButton());
    }

}
