package com.Jakob;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by jakob on 03/08/2017.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {

        this.handler = handler;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.gameObject.size(); i++) {
            GameObject tempObject = handler.gameObject.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for Player 1

                if (key == KeyEvent.VK_W) tempObject.setvY(tempObject.getvY() - 1);
                if (key == KeyEvent.VK_S) tempObject.setvY(tempObject.getvY() + 1);
                if (key == KeyEvent.VK_D) tempObject.setvX(tempObject.getvX() + 1);
                if (key == KeyEvent.VK_A) tempObject.setvX(tempObject.getvX() - 1);
            }


            //Player 2 multithreading??
            if (tempObject.getId() == ID.Player2) {
                //key events for Player 1

                if (key == KeyEvent.VK_UP) tempObject.setvY(tempObject.getvY() - 1);
                if (key == KeyEvent.VK_DOWN) tempObject.setvY(tempObject.getvY() + 1);
                if (key == KeyEvent.VK_RIGHT) tempObject.setvX(tempObject.getvX() + 1);
                if (key == KeyEvent.VK_LEFT) tempObject.setvX(tempObject.getvX() - 1);
            }




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


    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObject.size(); i++) {
            GameObject tempObject = handler.gameObject.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for Player 1

                if (key == KeyEvent.VK_W) tempObject.setvY(0);
                if (key == KeyEvent.VK_S) tempObject.setvY(0);
                if (key == KeyEvent.VK_D) tempObject.setvX(0);
                if (key == KeyEvent.VK_A) tempObject.setvX(0);
            }


            //Player 2 multithreading??
            if (tempObject.getId() == ID.Player2) {
                //key events for Player 1

                if (key == KeyEvent.VK_UP) tempObject.setvY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setvY(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setvX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setvX(0);
            }


        }


    }
}
