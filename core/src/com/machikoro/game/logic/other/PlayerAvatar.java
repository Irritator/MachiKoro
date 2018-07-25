package com.machikoro.game.logic.other;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.utils.Array;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.screens.PlayPreparationScreen;

import java.io.File;

public class PlayerAvatar extends SimpleActor {

    private static final String AVATARS_DIRECTORY = "avatars/";
    private static final float AVATAR_SIZE = MachiKoro.width / 10;
    private Array<String> avatarPathArray;
    private int currentAvatarIndex;

    public PlayerAvatar(){
        initAvatarPathArray();
        setNewAvatar();
        setSize(AVATAR_SIZE, AVATAR_SIZE);
    }

    public void disableEditing(){
        clearListeners();
    }

    public void enableEditing(){
        addListener(new ButtonListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                setNewAvatar();
            }
        });
    }

    private void initAvatarPathArray(){
        File folder = new File(AVATARS_DIRECTORY);
        File[] listOfFiles = folder.listFiles();
        avatarPathArray = new Array<String>();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                avatarPathArray.add(AVATARS_DIRECTORY + file.getName());
                System.out.println(file.getName());

            }
        }
    }

    private void setNewAvatar(){
        if (sprite != null){
            sprite.getTexture().dispose();
        } else {
            currentAvatarIndex = 0;
            sprite = new Sprite(new Texture(avatarPathArray.get(currentAvatarIndex)));
        }
        sprite.setTexture(new Texture(avatarPathArray.get(currentAvatarIndex)));
        currentAvatarIndex++;
        if (currentAvatarIndex >= avatarPathArray.size){
            currentAvatarIndex = 0;
        }
    }

}
