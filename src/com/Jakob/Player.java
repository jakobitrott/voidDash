package com.Jakob;

import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 02/08/2017.
 */
public class Player extends GameObject {

    Random random = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

        vX = random.nextInt(5) + 1;
        //vY = random.nextInt(5);

    }

    @Override
    public void tick() {
        x += vX;
        y += vY;

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, 32, 32);
    }
}
