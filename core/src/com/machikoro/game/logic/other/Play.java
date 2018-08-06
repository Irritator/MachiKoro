package com.machikoro.game.logic.other;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.machikoro.game.MachiKoro;

/**
 * Created by unknown on 07.02.2018.
 */

public class Play {
    private Array<Player> players;
    private Stage stage;

    public Play(Stage stage){
        this.stage = stage;
        players = new Array<Player>();
        addPlayer();
        addPlayer();
        players.first().activate();
    }

    public void addPlayer(){
        if (players.size < 5) {
            final Player newPlayer = new Player();
            newPlayer.setDelBtnAction(new ButtonListener() {
                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    if (players.size > 2) {
                        players.removeValue(newPlayer, true);
                        Array<Actor> actors = stage.getActors();
                        actors.removeValue(newPlayer.getEditViewGroup(), true);
                        recalculatePlayerPositions();
                        NameGenerator.returnNameToList(newPlayer.getGeneratedName());
                    }
                }
            });
            players.add(newPlayer);
            Group newPlayerEditGroup = newPlayer.getEditViewGroup();
            newPlayerEditGroup.setPosition(MachiKoro.width * 0.02f, MachiKoro.height * 0.7f - newPlayer.getHeight() * (players.size - 1));
            stage.addActor(newPlayerEditGroup);
        }
    }

    public void removePlayer(){
        players.pop();
    }

    public int getNumOfPlayers(){
        return players.size;
    }

    public void dispose() {
        for (Player player : players){
//            player.dispose();
        }
    }

    private void recalculatePlayerPositions() {
        for (int i = 0; i < players.size; i++) {
            Group editGroup = players.get(i).getEditViewGroup();
            editGroup.setPosition(MachiKoro.width * 0.02f, MachiKoro.height * 0.7f - players.get(i).getHeight() * i);
        }
    }
}
