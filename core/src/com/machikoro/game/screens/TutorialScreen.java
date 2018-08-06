package com.machikoro.game.screens;

import com.machikoro.game.MachiKoro;

/**
 * Created by unknown on 02.02.2018.
 */

public class TutorialScreen extends SimpleScreen {

    public TutorialScreen(MachiKoro game) {
        super(game);
        stage.addActor(buttonFactory.makeBackButton());
    }


}
