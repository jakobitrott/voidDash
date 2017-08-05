package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 03/08/2017.
 */
public class HUD {

    public static int HEALTH = 100;
    private int greenHealth = 255;
    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenHealth = Game.clamp(greenHealth, 0, 255);
        greenHealth = HEALTH * 2;
        score++;
    }

    public void render(Graphics graphics) {

        //empty health bar
        graphics.setColor(Color.darkGray);
        graphics.fillRect(15, 15, 200, 32);

        //Health
        graphics.setColor(new Color(75, greenHealth, 0));
        graphics.fillRect(15, 15, HEALTH * 2, 32);

        //draw border around health
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15, 15, 200, 32);

        //draw level and score
        graphics.drawString("Score: " + score, 15, 64);
        graphics.drawString("Level: " + level,15,80);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
