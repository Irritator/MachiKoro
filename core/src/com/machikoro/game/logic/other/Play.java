package com.machikoro.game.logic.other;

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
        Player newPlayer = new Player(players.size + 1);
        players.add(newPlayer);
        Group newPlayerEditGroup = players.peek().getEditViewGroup();
        newPlayerEditGroup.setPosition(MachiKoro.width * 0.02f, MachiKoro.height * 0.7f - newPlayer.getHeight() * (players.size - 1));
        stage.addActor(newPlayerEditGroup);
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
}
