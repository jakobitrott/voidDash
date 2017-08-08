package com.Jakob;


import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 08/08/2017.
 */
public class EnemyBullet extends GameObject {

    private Handler handler;
    Random random = new Random();

    public EnemyBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
        this.handler = handler;

        vX = random.nextInt(5 - - 5) + -5;
        vY = random.nextInt(5- -5) + -5;
    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += vX;
        y += vY;

        if(y >= Game.HEIGHT || x >= Game.WIDTH || x <= 0 || y <= 0){
            handler.removeObject(this);
        }
      //  new Trail((int)x,(int)y,ID.Trail,Color.yellow,15,15,0.3f,handler);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.fillOval((int)x, (int)y, 15, 15);
    }
}
