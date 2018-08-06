package com.machikoro.game.logic.other;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import com.machikoro.game.MachiKoro;
import com.machikoro.game.logic.cards.Card;
import com.machikoro.game.logic.cards.Landmark;

/**
 * Created by unknown on 31.01.2018.
 */

public class Player {

    private static final String COINS = "Coins: ";
    public static final float HEIGHT = MachiKoro.width / 13;
    private static final float DEL_BTN_SIZE = HEIGHT / 2;

    private String generatedName;
    private int coins;
    private Array<Card> industries;
    private Array<Landmark> landmarks;
    private boolean active;
    private PlayerAvatar avatar;
    private TextField nameField;
    private Label nameLabel, coinsLabel;
    private ImageButton deleteButton;
    private Group editGroup, standardViewGroup;


    public Player() {
        generatedName = NameGenerator.extractRandomName();
        coins = 3;
        coinsLabel = new Label(COINS + coins, MachiKoro.getSkin());
        industries = new Array<Card>();
        landmarks = new Array<Landmark>();
        active = false;

        avatar = new PlayerAvatar();
        nameLabel = new Label(generatedName, MachiKoro.getSkin());
        nameField = new TextField(generatedName, MachiKoro.getSkin());
        deleteButton = MachiKoro.getImageButtonFactory().makeDeletePlayerButton();
    }

    public Group getEditViewGroup() {
        if (editGroup == null) {
            makeEditViewGroup();
        }
        return editGroup;
    }

    public Group getStandardViewGroup() {
        if (standardViewGroup == null) {
            makeStandardViewGroup();
        }
        return standardViewGroup;
    }

    public String getGeneratedName() {
        return generatedName;
    }

    public float getHeight() {
        return avatar.getHeight();
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public void setDelBtnAction(ButtonListener listener) {
        deleteButton.addListener(listener);
    }

    private void makeEditViewGroup() {
        editGroup = new Group();
        avatar.setPosition(0, 0);
        avatar.enableEditing();
        editGroup.addActor(avatar);
        nameField.setPosition(HEIGHT * 1.2f, MachiKoro.height * 0.03f);
        editGroup.addActor(nameField);
        deleteButton.setPosition(nameField.getX() + nameField.getPrefWidth() * 1.1f, DEL_BTN_SIZE / 2);
        deleteButton.setSize(DEL_BTN_SIZE, DEL_BTN_SIZE);
        editGroup.addActor(deleteButton);
    }

    private void makeStandardViewGroup() {
        standardViewGroup = new Group();
        avatar.disableEditing();
        avatar.setPosition(0, 50f);
        standardViewGroup.addActor(avatar);
        nameLabel.setPosition(0, 20);
        nameLabel.setText(nameField.getText());
        standardViewGroup.addActor(nameLabel);
        coinsLabel.setPosition(0, 0);
        standardViewGroup.addActor(coinsLabel);
    }

}
