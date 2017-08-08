package com.Jakob;

import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 08/08/2017.
 */
public class HardEnemy extends GameObject {

    private Handler handler;

    private Random random = new Random();

    public HardEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
        this.handler = handler;
        vX = 5;
        vY = 5;
    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += vX;
        y += vY;

        if (y <= 0 || y >= Game.HEIGHT - 32) // reverse direction
        {if(vY < 0) vY = -(random.nextInt(7)+1)*-1; else vY = (random.nextInt(7)+1)*-1;}

        if (x <= 0 || x >= Game.WIDTH - 32) // reverse direction
        {if(vX < 0) vX = -(random.nextInt(7)+1)*-1; else vX = (random.nextInt(7)+1)*-1;}
        vX = Game.clamp(vX,-10,10);

        int spawn = random.nextInt(50);
        if(spawn == 0){
            new EnemyBullet((int)x+40,(int)y+40, ID.BasicEnemy, handler);
        }


        new Trail((int)x,(int)y,ID.Trail,Color.yellow,16,16,0.03f,handler);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x, (int)y, 16, 16);
    }
}
