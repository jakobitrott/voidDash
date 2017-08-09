package com.Jakob;

import jdk.internal.org.objectweb.asm.Handle;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jakob on 08/08/2017.
 */
public class Shop extends MouseAdapter {
    Handler handler;
    HUD hud;
    Game game;
    Score score;
    private int boxOne= 100;
    private int boxTwo=100;
    private int boxThree=100;


    public void setBoxOne(int boxOne) {
        this.boxOne = boxOne;
    }



    public void setBoxTwo(int boxTwo) {
        this.boxTwo = boxTwo;
    }



    public void setBoxThree(int boxThree) {
        this.boxThree = boxThree;
    }


    public Shop(Handler handler, HUD hud, Game game, Score score) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
        this.score = score;

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("arial", 0, 48));
        graphics.drawString("SHOP", Game.WIDTH / 2 - 100, 50);

        //box one
        graphics.setFont(new Font("arial", 0, 12));
        graphics.drawString("Upgrade Health", 110, 120);
        graphics.drawString("Cost: " + boxOne, 110, 140);
        graphics.drawRect(100, 100, 100, 80);

        //box two

        graphics.drawString("Upgrade Speed", 260, 120);
        graphics.drawString("Cost: " + boxTwo, 260, 140);
        graphics.drawRect(250, 100, 100, 80);

        //box three

        graphics.drawString("Refill Health", 410, 120);
        graphics.drawString("Cost: " + boxThree, 410, 140);
        graphics.drawRect(400, 100, 100, 80);


        graphics.drawString("SCORE " + score.getScore(), Game.WIDTH / 2 - 50, 300);
        graphics.drawString("Press space to go back", Game.WIDTH / 2 - 50, 330);


    }

    public void mousePressed(MouseEvent event) {

        int mouseX = event.getX();
        int mouseY = event.getY();

        if (game.gameState == Game.STATE.Shop) {
            //boxOne
            if (mouseX >= 100 && mouseX <= 200) {
                if (mouseY >= 100 && mouseY <= 180) {
                    System.out.println("boxThree");
                    if (score.getScore() >= boxOne) {
                        score.setScore(score.getScore() - boxOne);
                        boxOne += 20;
                        hud.bounds += 20;
                        hud.HEALTH = (100 + (hud.bounds / 2));
                    }
                }
            }
            //boxTwo
            if (mouseX >= 250 && mouseX <= 350) {
                if (mouseY >= 100 && mouseY <= 180) {
                    System.out.println("boxThree");
                    if (score.getScore() >= boxTwo) {
                        score.setScore(score.getScore() - boxTwo);
                        boxTwo += 20;
                        handler.speed++;
                    }
                }
            }
                //boxThree
                if (mouseX >= 400 && mouseX <= 500) {
                    if (mouseY >= 100 && mouseY <= 180) {
                        System.out.println("boxThree");
                        if (score.getScore() >= boxTwo)
                        {
                        score.setScore(score.getScore() - boxThree);
                        hud.HEALTH = (100 + (hud.bounds / 2));
                    }
                }

            }
        }
    }
}

