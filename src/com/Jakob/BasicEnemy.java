package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 03/08/2017.
 */
public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        vX = 5;
        vY = 5;
    }

    public void tick() {
        x += vX;
        y += vY;

        if(y <= 0 || y >= Game.HEIGHT-32) // reverse direction
            vY *= -1;

        if(x <= 0 || x >= Game.WIDTH-32) // reverse direction
            vX *= -1;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect(x, y, 16, 16);
    }
}
