package com.machikoro.game.logic.other;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class ImageButtonFactory {

    private ImageButton.ImageButtonStyle deletePlayerButtonStyle;


    public ImageButtonFactory(){

    }

    public  ImageButton makeDeletePlayerButton(){
        ImageButton deletePlayer = new ImageButton(deletePlayerButtonStyle);
        return deletePlayer;
    }

    private void initDeletePlayerButtonStyle(){
        if (deletePlayerButtonStyle == null) {
            deletePlayerButtonStyle = new ImageButton.ImageButtonStyle();

        }
    }
}
