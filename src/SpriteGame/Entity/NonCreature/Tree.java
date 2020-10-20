package SpriteGame.Entity.NonCreature;

import SpriteGame.Game;

import java.awt.*;

public class Tree extends NonCreature {

    public Tree(Game game, int xPos, int yPos) {
        super(game, xPos, yPos);  // width and height are inhered from NonCreature
    }


    @Override
    public void render(Graphics2D g) {
        if (showAlert) {
            // todo: change to enlarge balooning shape
            g.drawImage(game.getAsset().getExplosives()[1], (int) (xPos - 10 - game.getCamera().getxOffset()), (int) (yPos - 10 - game.getCamera().getyOffset()), null);
            g.drawImage(game.getAsset().getTree(), (int) (xPos - game.getCamera().getxOffset()), (int) (yPos - game.getCamera().getyOffset()), width, height, null);
            // todo: set timer right OOOO
            showAlert = false;
        }
        g.drawImage(game.getAsset().getTree(), (int) (xPos - game.getCamera().getxOffset()), (int) (yPos - game.getCamera().getyOffset()), width, height, null);
        
    }

}
