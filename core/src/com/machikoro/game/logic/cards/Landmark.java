package com.machikoro.game.logic.cards;

/**
 * Created by unknown on 31.01.2018.
 */

public class Landmark extends Card {
    private boolean active;

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

}
