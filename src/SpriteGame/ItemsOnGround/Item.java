package SpriteGame.ItemsOnGround;

import SpriteGame.Game;
import SpriteGame.GameInterFace;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item implements GameInterFace {
    public BufferedImage image;
    public int xPos, yPos;
    public Rectangle bounds;
    public Game game;

    public Item(Game game,BufferedImage image, int xPos, int yPos) {
        this.game = game;
        this.image = image;
        this.xPos = xPos;
        this.yPos = yPos;
        bounds = new Rectangle((int)xPos-5,(int) yPos-5, 20,20);
    }
    @Override
    public void render(Graphics2D g) {
        g.drawImage(image, (int) (xPos - game.getCamera().getxOffset())-30, (int) (yPos - game.getCamera().getyOffset())-30, 30, 30, null) ;
    }
}
