package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 03/08/2017.
 */
public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
        this.handler = handler;
        vX = 2;
        vY = 8;
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public void tick() {
        x += vX;
        y += vY;

        if (y <= 0 || y >= Game.HEIGHT - 32) // reverse direction
            vY *= -1;

        if (x <= 0 || x >= Game.WIDTH - 32) // reverse direction
            vX *= -1;

        new Trail(x,y,ID.Trail,Color.CYAN,16,16,0.03f,handler);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(x, y, 16, 16);
    }
}
