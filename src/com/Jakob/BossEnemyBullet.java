package com.Jakob;


import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 07/08/2017.
 */
public class BossEnemyBullet extends GameObject {

    private Handler handler;
    Random random = new Random();

    public BossEnemyBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
        this.handler = handler;

        vX = random.nextInt(5 - - 5) + -5;
        vY = 5;
    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick() {
        x += vX;
        y += vY;
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        Color randomColor = new Color(r,g,b);

       if(y>= Game.HEIGHT){
           handler.removeObject(this);
       }
        new Trail((int)x,(int)y,ID.Trail,randomColor,15,15,0.3f,handler);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x, (int)y, 15, 15);
    }
}
