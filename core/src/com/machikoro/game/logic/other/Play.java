package com.machikoro.game.logic.other;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

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
        Player newPlayer = new Player(players.size);
        players.add(newPlayer);
//        stage.addActor(new SimpleActor(players.peek().sprite));
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
