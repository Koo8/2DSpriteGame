package SpriteGame.Entity.NonCreature;

import SpriteGame.Game;
import SpriteGame.Graphics.Animation;
import SpriteGame.Graphics.Assets;

import java.awt.*;

public class Gold extends NonCreature{
    Animation explosives;
    Assets assets;
    public Gold(Game game, int xPos, int yPos) {
        super(game, xPos, yPos);
        assets = Assets.getInstance();
        explosives = new Animation(assets.getExplosives());
    }

    @Override
    public void render(Graphics2D g) {
        if (showAlert) {
            // todo: change to enlarge balooning shape
            g.drawImage(explosives.getCurrentImage(),(int) (xPos - 10 - game.getCamera().getxOffset()), (int) (yPos - 10 - game.getCamera().getyOffset()), null);
            g.drawImage(game.getAsset().getGold(), (int) (xPos - game.getCamera().getxOffset()), (int) (yPos - game.getCamera().getyOffset()), width, height, null);
            // todo: set timer right OOOO
            showAlert = false;
        }

        g.drawImage(game.getAsset().getGold(),(int) (xPos - game.getCamera().getxOffset()), (int) (yPos - game.getCamera().getyOffset()), width, height, null );

    }

}
