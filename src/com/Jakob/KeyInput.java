package com.Jakob;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by jakob on 03/08/2017.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4]; //fix sticky keys

    public KeyInput(Handler handler) {

        this.handler = handler;
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

                if(key == KeyEvent.VK_W) { tempObject.setvY(-5); keyDown[0] = true;  }
                if(key == KeyEvent.VK_S) { tempObject.setvY(5); keyDown[1] = true; }
                if(key == KeyEvent.VK_D) { tempObject.setvX(5); keyDown[2] = true; }
                if(key == KeyEvent.VK_A) { tempObject.setvX(-5); keyDown[3] = true; }
            }


           /* //Player 2 multithreading??
            if (tempObject.getId() == ID.Player2) {
                //key events for Player 1

                if (key == KeyEvent.VK_UP) tempObject.setvY(tempObject.getvY() - 1);
                if (key == KeyEvent.VK_DOWN) tempObject.setvY(tempObject.getvY() + 1);
                if (key == KeyEvent.VK_RIGHT) tempObject.setvX(tempObject.getvX() + 1);
                if (key == KeyEvent.VK_LEFT) tempObject.setvX(tempObject.getvX() - 1);
            }
*/



                /*switch(key){
                    case KeyEvent.VK_W{
                        tempObject.setY(tempObject.getY() -1);
                    }
                    case KeyEvent.VK_S:{
                        tempObject.setY(tempObject.getY() +1);
                    }
                    case KeyEvent.VK_D:{
                        tempObject.setX(tempObject.getX() + 1);
                    }
                    case KeyEvent.VK_A:{
                        tempObject.setX(tempObject.getX() - 1);
                    }
                }
                */
        }

    if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObject.size(); i++) {
            GameObject tempObject = handler.gameObject.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for Player 1

                if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(0);
                if(key == KeyEvent.VK_A) keyDown[3] = false; //tempObject.setVelX(0);
                if(!keyDown[0] && !keyDown[1]) tempObject.setvY(0);
                if(!keyDown[2] && !keyDown[3]) tempObject.setvX(0);
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
