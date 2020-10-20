package SpriteGame.Worlds;

import SpriteGame.Entity.Entity;
import SpriteGame.Game;
import SpriteGame.Tiles.Tile;

/**
 * Change World xpos and yPos to set the viewPort to match camera coordiation
 */
public class Camera {
    private float xOffset, yOffset; // offsets are determined by the center of player
    private Game game;
    public Camera (Game game) {
        this.game = game;
    }
    // set offsets
    public void centerOnEntity(Entity entity){
        xOffset = entity.getxPos() - (float)game.getWidth()/2 + (float)entity.getWidth()/2;
        yOffset = entity.getyPos() -(float)game.getHeight()/2 + (float)entity.getHeight()/2;
        removeWhiteSpace();
    }

    private void removeWhiteSpace() {
       if(xOffset<0) xOffset = 0;
       if(xOffset >game.getWorld().worldWidth* Tile.DEFAULTWIDTH-game.getWidth())
           xOffset = game.getWorld().worldWidth* Tile.DEFAULTWIDTH-game.getWidth();
        if(yOffset<0) yOffset = 0;
        if(yOffset >game.getWorld().worldHeight* Tile.DEFAULTHEIGHT-game.getHeight())
            yOffset = game.getWorld().worldHeight* Tile.DEFAULTHEIGHT-game.getHeight();
    }

    public float getxOffset() {
        return xOffset;
    }
    public float getyOffset (){
        return yOffset;
    }

}
