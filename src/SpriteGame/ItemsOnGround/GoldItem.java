package SpriteGame.ItemsOnGround;

import SpriteGame.Game;

public class GoldItem extends Item {

    public GoldItem(Game game, int xPos, int yPos) {
        super(game,game.getAsset().getGold(), xPos, yPos);
    }

    @Override
    public void tick() {

    }

}
