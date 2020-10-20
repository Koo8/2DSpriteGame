package SpriteGame.ItemsOnGround;

import SpriteGame.Game;

public class TreeItem extends Item {

    public TreeItem(Game game, int xPos, int yPos) {
        super(game, game.getAsset().getTree(), xPos, yPos);
    }

    @Override
    public void tick() {

    }

}
