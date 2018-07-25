package com.machikoro.game.logic.cards;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.machikoro.game.logic.other.SimpleActor;

/**
 * Created by unknown on 31.01.2018.
 */

public class Card extends SimpleActor {
    protected int cost;
    protected CardType type;
    protected int gain;

    public Card(Sprite sprite, int cost, CardType type, int gain) {
        super(sprite);
        this.cost = cost;
        this.type = type;
        this.gain = gain;
    }

    public Card() {
        super();
        cost = 0;
        gain = 0;
        type = null;
    }

    public int getCost(){
        return cost;
    }

    public int getGain(){
        return gain;
    }

}
