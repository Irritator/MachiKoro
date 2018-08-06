package com.machikoro.game.logic.other;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class ImageButtonFactory {

    private static final String DELETE_BUTTON_PATH = "buttons/remove.png";
    private ImageButton.ImageButtonStyle deletePlayerButtonStyle;


    public ImageButtonFactory(){
    }

    public  ImageButton makeDeletePlayerButton(){
        if (deletePlayerButtonStyle == null) {
            initDeletePlayerButtonStyle();
        }
        ImageButton deletePlayer = new ImageButton(deletePlayerButtonStyle);
        return deletePlayer;
    }

    private void initDeletePlayerButtonStyle(){
        deletePlayerButtonStyle = new ImageButton.ImageButtonStyle();
        deletePlayerButtonStyle.imageUp = new SpriteDrawable(new Sprite(new Texture(DELETE_BUTTON_PATH)));
        deletePlayerButtonStyle.imageDown = new SpriteDrawable(new Sprite(new Texture(DELETE_BUTTON_PATH)));
        deletePlayerButtonStyle.imageOver = new SpriteDrawable(new Sprite(new Texture(DELETE_BUTTON_PATH)));
    }

}
