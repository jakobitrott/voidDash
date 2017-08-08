package com.Jakob;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by jakob on 02/08/2017.
 */
public class Handler {
Game game;
    LinkedList<GameObject> gameObject = new LinkedList<GameObject>(); //list of gameObjects within the game

    public int speed = 5;

    public void tick() {
        for (int i = 0; i < gameObject.size(); i++) {
            GameObject tempObject = gameObject.get(i);

            tempObject.tick();
        }

    }

    public void clearEnemies(){
        for (int i = 0; i < gameObject.size(); i++) {
            GameObject tempObject = gameObject.get(i);
            if(tempObject.getId() != ID.Player) {
                removeObject(tempObject);
                i--;
            }
            if(game.gameState == Game.STATE.End){
                if(tempObject.getId() == ID.Player){
                    removeObject(tempObject);
                    i--;
                }
            }


        }
    }

    public void render(Graphics graphics) {
        for (int i = 0; i < gameObject.size(); i++) {
            GameObject tempObject = gameObject.get(i);

            tempObject.render(graphics);
        }
    }

    public void addObject(GameObject gameObject) {
        this.gameObject.add(gameObject);
    }

    public void removeObject(GameObject gameObject) {
        this.gameObject.remove(gameObject);
    }
}
