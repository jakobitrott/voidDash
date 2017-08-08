package com.Jakob;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by jakob on 07/08/2017.
 */
public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random random = new Random();
    private HUD hud;

    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }

    public void mousePressed(MouseEvent event) {
        int mouseX = event.getX(); //get the location where the mouse has pressed
        int mouseY = event.getY();

        if (game.gameState == Game.STATE.Menu) {


            //Play
            if (mouseOver(mouseX, mouseY, 220, 150, 200, 64)) {
                game.gameState = Game.STATE.Select;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }


            //help button
            if (mouseOver(mouseX, mouseY, 220, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;
                AudioPlayer.getSound("menu_sound").play();
                //back button for help

            }


            //quit button
            if (mouseOver(mouseX, mouseY, 220, 350, 200, 64)) {
                AudioPlayer.getSound("menu_sound").play();
                System.exit(1);

            }
        }


        if (game.gameState == Game.STATE.Select) {


            //Normal
            if (mouseOver(mouseX, mouseY, 220, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;

                new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler);
                handler.clearEnemies();

                new BasicEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.BasicEnemy, handler);


                game.difficulty = 0;
                AudioPlayer.getSound("menu_sound").play();
            }


            //hard button
            if (mouseOver(mouseX, mouseY, 220, 250, 200, 64)) {
                game.gameState = Game.STATE.Game;
                new Player((Game.WIDTH / 2 - 32), (Game.HEIGHT / 2 - 32), ID.Player, handler);
                handler.clearEnemies();

                new HardEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.BasicEnemy, handler);
                game.difficulty = 1;
                AudioPlayer.getSound("menu_sound").play();
            }

            //back button
            if (mouseOver(mouseX, mouseY, 220, 350, 200, 64)) {
                if (mouseOver(mouseX, mouseY, 220, 350, 200, 64)) {
                    game.gameState = Game.STATE.Menu;
                    AudioPlayer.getSound("menu_sound").play();
                    return;

                }
            }

        }

            if (game.gameState == Game.STATE.End) {

                if (mouseOver(mouseX, mouseY, 220, 350, 200, 64)) {
                    game.gameState = Game.STATE.Menu;
                    AudioPlayer.getSound("menu_sound").play();
                    hud.setLevel(1);
                    hud.setScore(0);


                }
            }

        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mouseX, mouseY, 220, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                AudioPlayer.getSound("menu_sound").play();
                return;
            }
        }

    }

    public void mouseReleased(MouseEvent event) {

    }

    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height) {


        if (mouseX > x && mouseX < x + width) {  //checking to see if the mouse click is between 2 points on the x axis
            if (mouseY > y && mouseY < y + height) { // if true check to see if mouse click is between 2 points on Y axis
                return true;                    //if all true, mouse click is within box
            } else return false;
        } else
            return false;

    }


    public void render(Graphics graphics) {
        if (game.gameState == Game.STATE.Menu) {

            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 40);

            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString("Void_Dash", 200, 80);

            graphics.setFont(font2);
            graphics.setColor(Color.white);


            graphics.setColor(Color.white);
            graphics.drawRect(220, 150, 200, 64);
            graphics.drawString("Play", 280, 195);

            graphics.setColor(Color.white);
            graphics.drawRect(220, 250, 200, 64);
            graphics.drawString("Help", 280, 295);

            graphics.setColor(Color.white);
            graphics.drawRect(220, 350, 200, 64);
            graphics.drawString("Quit", 280, 395);
        } else if (game.gameState == Game.STATE.Help) {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            Font font3 = new Font("arial", 1, 40);

            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString("Help", 250, 80);


            graphics.setFont(font2);
            graphics.setColor(Color.red);
            graphics.drawString("Use WASD to move", 180, 200);
            graphics.drawString("Avoid enemies at all costs!", 180, 250);


            graphics.setFont(font3);
            graphics.setColor(Color.white);
            graphics.drawRect(220, 350, 200, 64);
            graphics.drawString("Back", 280, 395);

        }
        else if (game.gameState == Game.STATE.End) {
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            Font font3 = new Font("arial", 1, 40);

            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString("GAMEOVER", 180, 80);


            graphics.setFont(font2);
            graphics.setColor(Color.red);
            graphics.drawString("You lost with a score of: " + hud.getScore() , 120, 200);



            graphics.setFont(font2);
            graphics.setColor(Color.white);
            graphics.drawRect(220, 350, 200, 64);
            graphics.drawString("Try Again?", 245, 395);

        }else if (game.gameState == Game.STATE.Select) {

            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 40);

            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString("Select Difficulty", 150, 80);

            graphics.setFont(font2);
            graphics.setColor(Color.white);


            graphics.setColor(Color.white);
            graphics.drawRect(220, 150, 200, 64);
            graphics.drawString("Normal", 250, 195);

            graphics.setColor(Color.white);
            graphics.drawRect(220, 250, 200, 64);
            graphics.drawString("Hard", 280, 295);

            graphics.setColor(Color.white);
            graphics.drawRect(220, 350, 200, 64);
            graphics.drawString("Back", 280, 395);
        }


    }

    public void tick() {
    }
}
