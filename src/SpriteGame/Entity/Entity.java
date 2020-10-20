package SpriteGame.Entity;

import SpriteGame.Game;
import SpriteGame.GameInterFace;

import java.awt.*;

/* This is an abstract class  - to create players and Trees etc*/
public abstract class Entity implements GameInterFace {
    public Game game;
    protected int xPos, yPos;
    public int width, height;
    protected int health;
    protected Rectangle bounds; // for collision detection;
    public int bx,by,bwidth, bheight; // for (0,0,width,height) relative to the entity itself

    public Entity(Game game, int xPos, int yPos, int width, int height, int health,int bx,int by, int bwidth, int bheight) {
        this.game = game;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.health = health;
        this.bx = bx;
        this.by = by;
        this.bwidth = bwidth;
        this.bheight = bheight;
       // bounds = new Rectangle((int)xPos+bx, (int)yPos+by, width+bwidth, height+bheight);
    }
    public Rectangle getBounds(){
          return bounds = new Rectangle((int)xPos+bx, (int)yPos+by, width+bwidth, height+bheight);
    }


    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
