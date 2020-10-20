package SpriteGame.Entity.Creatures;

import SpriteGame.Game;
import SpriteGame.Graphics.Animation;
import SpriteGame.Graphics.Assets;
import SpriteGame.Inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    private int speed;
    private Animation upAnim, downAnim;
    private Assets assets;

    public Player(Game game, int xPos, int yPos) {
        super(game, xPos, yPos, Assets.DEFAULTWIDTH, Assets.DEAFULTHEIGHT,16,32,-36,-32);
        speed = 3;
        // collision test bounds - inherited from Entity
        // the player  bounds are smaller than entity
        assets = Assets.getInstance();

        upAnim = new Animation(assets.getUpImages());
        downAnim = new Animation(assets.getDownImages());

    }

    // OOOO SIXTH STEP OOOO //
    @Override
    public void tick() {
        // update the four key boolean status from listener info
        xMoveyMove();
        move(); // sometimes can't move smoothly due to collision - defined by superclass Creature
        game.getCamera().centerOnEntity(this);

    }



    public Rectangle getBounds() {
       return super.getBounds();
    }


    public void xMoveyMove() {
        xMove = 0;   // without this xMove yMove, xPos and yPos is kept on accelarating
        yMove = 0;
        game.getKeyListener().whichKeyIsMoving();
        if(game.getKeyListener().isLastInvetory()) {
            return;
        }

        if (game.getKeyListener().isUp()) {
           // System.out.println("up key pressed");

            yMove -= speed;
        }
        if (game.getKeyListener().isDown()) {
            yMove += speed;

        }
        if (game.getKeyListener().isLeft()) {
            xMove -= speed;
        }
        if (game.getKeyListener().isRight()) {
            xMove += speed;
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(getPlayerImage(), (int) (xPos - game.getCamera().getxOffset()), (int) (yPos - game.getCamera().getyOffset()), Assets.DEFAULTWIDTH, Assets.DEAFULTHEIGHT, null);
//        g.setColor(Color.red);
//        g.fillRect((int)(xPos+bounds.x -game.getCamera().getxOffset()), (int)(yPos + bounds.y - game.getCamera().getyOffset()),bounds.width,bounds.height);

    }

    private BufferedImage getPlayerImage() {
        if (xMove > 0 || xMove < 0) {
            return assets.getPlayer();
        }
        if (yMove > 0) {
          return  downAnim.getCurrentImage();
        }
        if (yMove < 0) {
           return upAnim.getCurrentImage();
        }
        return assets.getPlayer();

    }


}
