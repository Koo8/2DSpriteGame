package SpriteGame.Entity.NonCreature;

import SpriteGame.Entity.Entity;
import SpriteGame.Game;
import SpriteGame.Graphics.Assets;

import java.awt.*;

public abstract class NonCreature extends Entity {
    private Rectangle entityBounds, playerBounds;
    private long timer, now, before;
    public boolean showAlert;

    public NonCreature(Game game, int xPos, int yPos) {
        super(game, xPos, yPos, Assets.DEFAULTWIDTH, Assets.DEAFULTHEIGHT,3,-20,-20,40, 40);
        showAlert = false;
    }
    // OOOO SIXTH STEP OOOO //
    @Override
    public void tick() {
        entityBounds = super.getBounds();
        playerBounds = game.getWorld().entityManager.getPlayer().getBounds();
        if (entityBounds.intersects(playerBounds)) {
            // todo: render alert image
            if (game.getKeyListener().isAttack()) {

                showAlert = true;
                timer = 0;
                before = System.currentTimeMillis();
                setTimer(200);
                health--;

                // todo: render explosive image
            }
        }
    }


    public void setTimer(int time) {
        while (timer < time) {
            now = System.currentTimeMillis();
            timer += now - before;
            before = now;
        }
    }

}