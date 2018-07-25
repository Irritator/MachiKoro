package com.machikoro.game.logic.other;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by unknown on 31.01.2018.
 */

public class SimpleActor extends Actor {
    protected Sprite sprite;

    public SimpleActor(Sprite sprite) {
        this.sprite = sprite;
        setSize(sprite.getRegionWidth(), sprite.getRegionHeight());
        setBounds(0, 0, getWidth(), getHeight());
    }

    public SimpleActor(){
        sprite = null;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public void dispose(){
        sprite.getTexture().dispose();
    }
}
