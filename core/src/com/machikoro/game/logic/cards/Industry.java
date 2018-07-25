package com.machikoro.game.logic.cards;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by unknown on 01.02.2018.
 */

public abstract class Industry extends Card {

    protected int activateVal;
    protected boolean starting;

    public Industry() {
        super();
        activateVal = 0;
    }

    public Industry(Sprite sprite, int cost, CardType type, int gain, int activateVal) {

        super(sprite, cost, type, gain);
        this.activateVal = activateVal;
    }

    public int getActivateVal(){
        return activateVal;
    }

    public boolean isActive(int val) {
        return val == activateVal;
    }

}
