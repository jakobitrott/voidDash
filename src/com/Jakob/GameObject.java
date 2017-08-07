package com.Jakob;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by jakob on 02/08/2017.
 */
public abstract class GameObject {

    protected  float x,y; //protected means it can only be accessed by an object that inherits GameObject
    protected ID id;
    protected float vX,vY; //velocity

    private Handler handler;

    public GameObject(float x, float y, ID id,Handler handler) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler =handler;
        handler.addObject(this);
    }

    public abstract void tick();
    public abstract void render(Graphics graphics);
    public abstract Rectangle getBounds();


    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getvX() {
        return vX;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public float getvY() {
        return vY;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }
}
