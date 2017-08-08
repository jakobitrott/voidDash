package com.Jakob;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by jakob on 03/08/2017.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4]; //fix sticky keys
    Game game;

    public KeyInput(Handler handler,Game game) {

        this.handler = handler;
        this.game = game;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.gameObject.size(); i++) {
            GameObject tempObject = handler.gameObject.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for Player 1

                if (key == KeyEvent.VK_W) {
                    tempObject.setvY(-handler.speed);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setvY(handler.speed);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setvX(handler.speed);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setvX(-handler.speed);
                    keyDown[3] = true;
                }
            }

        }
        //pause game
        if (key == KeyEvent.VK_P) {
            if (game.gameState == Game.STATE.Game) {
                if (Game.paused) Game.paused = false;
                else Game.paused = true;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
        if (key == KeyEvent.VK_SPACE) {
            if (Game.gameState == Game.STATE.Game) {
                Game.gameState = Game.STATE.Shop;
            } else if (Game.gameState == Game.STATE.Shop) {
                Game.gameState = Game.STATE.Game;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObject.size(); i++) {
            GameObject tempObject = handler.gameObject.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for Player 1

                if (key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) keyDown[3] = false; //tempObject.setVelX(0);
                if (!keyDown[0] && !keyDown[1]) tempObject.setvY(0);
                if (!keyDown[2] && !keyDown[3]) tempObject.setvX(0);
            }


            //Player 2 multithreading??
          /*  if (tempObject.getId() == ID.Player2) {
                //key events for Player 1

                if (key == KeyEvent.VK_UP) tempObject.setvY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setvY(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setvX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setvX(0);
            }
*/

        }


    }
}
