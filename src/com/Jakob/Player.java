package com.Jakob;

import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 02/08/2017.
 */
public class Player extends GameObject {

    Random random = new Random();
    Handler handler;

    public Player(int x, int y, ID id,Handler handler) {
        super(x, y, id,handler);
        this.handler = handler;


    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    @Override
    public void tick() {
        x += vX;
        y += vY;

        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 61);
        new Trail(x,y,ID.Trail,Color.white,32,32,0.05f,handler);

        collision();

    }

    private void collision() {
        for (int i = 0; i < handler.gameObject.size(); i++) {

            GameObject tempObject = handler.gameObject.get(i);

            if (tempObject.getId() == ID.BasicEnemy ||tempObject.getId() == ID.FastEnemy|| tempObject.getId() ==ID.SmartEnemy || tempObject.getId() ==ID.BossEnemy) {

                if (getBounds().intersects(tempObject.getBounds())) {
                    if(tempObject.getId() == ID.BossEnemy)
                    {
                        HUD.HEALTH = 0;
                    }
                    //collision code
                    else
                        HUD.HEALTH -= 2;

                }
                }
            }
        }


    @Override
    public void render(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;

   /*     graphics.setColor(Color.red);
        graphics2D.draw(getBounds());*/

        if (id == ID.Player) {
            graphics.setColor(Color.white);
            graphics.fillRect((int)x, (int)y, 32, 32);
        } /*else if (id == ID.Player2) {
            graphics.setColor(Color.cyan);
            graphics.fillRect(x, y, 32, 32);
        }*/

    }
}



