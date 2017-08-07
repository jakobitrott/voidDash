package com.Jakob;

import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 07/08/2017.
 */
public class BossEnemy extends GameObject {
    private Handler handler;
    Random random = new Random();
    private int timer = 80;
    private int timer2 = 50;

    public BossEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        vX = 0;
        vY = 2;
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 140);
    }

    public void tick() {
        x += vX;
        y += vY;

        if (timer <= 0) {
            vY = 0;
        }
        else
            timer--;

        if(timer <= 0) {
            timer2--;
        }
        if(timer2  <= 0){
            if(vX==0)
            {
                vX = 3;
            }
            if(vX > 0){
                vX += 0.05;
            }
            else if(vX < 0){
                vX -= 0.05f;
            }

            vX = Game.clamp(vX,-10,10);
            int spawn = random.nextInt(7);
                    if(spawn == 0){
                new BossEnemyBullet((int)x+48,(int)y+48, ID.BasicEnemy, handler);
                    }
        }
        if(x <= 0 || x >= Game.WIDTH - 96){
            vX*= -1;
        }

       // new Trail((int) x, (int) y, ID.Trail, Color.white, 96, 96, 0.09f, handler);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect((int) x, (int) y, 96, 140);
    }
}

