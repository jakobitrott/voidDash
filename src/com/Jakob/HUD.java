package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 03/08/2017.
 */
public class HUD {
    public int bounds = 0;
    public static int HEALTH = 100;
    private float greenHealth = 255;
    private int score = 0;
    private int level = 1;

    public void tick() {
        HEALTH = (int) Game.clamp(HEALTH, 0, 100+(bounds/2));
        greenHealth = HEALTH * 2;
        greenHealth = (int) Game.clamp(greenHealth, 0, 255);
        score++;
    }

    public void render(Graphics graphics) {

        //empty health bar
        graphics.setColor(Color.darkGray);
        graphics.fillRect(15, 15, 200 + bounds, 32);

        //Health
        graphics.setColor(new Color(75, (int) greenHealth, 0));
        graphics.fillRect(15, 15, (int) HEALTH * 2, 32);

        //draw border around health
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15, 15, 200+bounds, 32);

        //draw level and score
        graphics.drawString("Score: " + score, 15, 64);
        graphics.drawString("Level: " + level, 15, 80);
        graphics.drawString("Space for Shop", 15, 94);
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
