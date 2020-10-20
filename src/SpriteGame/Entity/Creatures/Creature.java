package SpriteGame.Entity.Creatures;

import SpriteGame.Entity.Entity;
import SpriteGame.Game;
import SpriteGame.Tiles.Tile;

public abstract class Creature extends Entity {

    protected long speed;
    protected long xMove, yMove;

    public Creature(Game game, int xPos, int yPos, int width, int height, int bx, int by, int bwidth, int bheight) {
        super(game, xPos, yPos, width, height,5, bx, by, bwidth, bheight);
        speed = 0;
        xMove = 0;
        yMove = 0;
    }
       //highlight: I changed the collision detection - "collision detected" means player bounds moves into a tile that is solid, so use the bounds
//    public void setBoundsValue() {
//        xLeftBounds = (int) (xPos + bounds.x);
//        xRightBounds = xLeftBounds + bounds.width;
//        yTopBounds = (int) (yPos + bounds.y);
//        yBottomBounds = yTopBounds + bounds.height;
//    }

    // all creatures can move, this is controlled by UI_Menu
    public void move() {
        xToMove();
        yToMove();
    }

    // needs to refer to tiles in the World for isSolid() result
    public boolean detectCollision(int x, int y) {
        return game.getWorld().getTile(x, y).checkisSolid();
    }

    public void xToMove() {

        if(xMove > 0 ){
            super.getBounds();
            if (!detectCollision((int) ((bounds.x+bounds.getWidth() + xMove) / Tile.DEFAULTWIDTH), (bounds.y / Tile.DEFAULTHEIGHT)) &&
                    !detectCollision((int) ((bounds.x+bounds.getWidth() + xMove) / Tile.DEFAULTWIDTH), (int) (bounds.y +bounds.getHeight() / Tile.DEFAULTHEIGHT))) {
                xPos += xMove;
            } else {
               // System.out.println("tile number is " + (int)(bounds.x + bounds.getWidth() + xMove) / Tile.DEFAULTWIDTH);
                xPos = (int) (((int)((bounds.x + bounds.getWidth() + xMove) / Tile.DEFAULTWIDTH) )* Tile.DEFAULTWIDTH - bx - bounds.getWidth() -1);
            }
        }
        if(xMove < 0) {
            super.getBounds();
            if (!detectCollision((int) ((bounds.x + xMove) / Tile.DEFAULTWIDTH), (bounds.y / Tile.DEFAULTHEIGHT)) &&
                    !detectCollision((int) ((bounds.x + xMove) / Tile.DEFAULTWIDTH), (int) (bounds.getY() + bounds.getHeight() / Tile.DEFAULTHEIGHT))) {
                xPos += xMove;
            } else {
                //System.out.println("tile number is " + (bounds.x + xMove) / Tile.DEFAULTWIDTH);
                xPos = (int) ((int)((bounds.x + xMove) / Tile.DEFAULTWIDTH) * Tile.DEFAULTWIDTH + this.getWidth() - bx + 1);  // note: the (int) is important to get the right tile index
            }
        }
//        if (xMove > 0) {
//            // only when the tile that moves to is not solid
//           // setBoundsValue();  // needs to be set constantly
//            if (!detectCollision((int) ((xRightBounds + xMove) / Tile.DEFAULTWIDTH), (yTopBounds / Tile.DEFAULTHEIGHT)) &&
//                    !detectCollision((int) ((xRightBounds + xMove) / Tile.DEFAULTWIDTH), (yBottomBounds / Tile.DEFAULTHEIGHT))) {
//                xPos += xMove;
//            } else {
//                xPos = (float) (((xRightBounds + xMove) / Tile.DEFAULTWIDTH) * Tile.DEFAULTWIDTH - bounds.getX() - bounds.getWidth() - 1);
//            }
//        }
//        if (xMove < 0) {
//            setBoundsValue();
//            if (!detectCollision((int) ((xLeftBounds + xMove) / Tile.DEFAULTWIDTH), (yTopBounds / Tile.DEFAULTHEIGHT)) &&
//                    !detectCollision((int) ((xLeftBounds + xMove) / Tile.DEFAULTWIDTH), (yBottomBounds / Tile.DEFAULTHEIGHT))) {
//                xPos += xMove;
//            } else {
//                xPos = (float) (((xLeftBounds + xMove) / Tile.DEFAULTWIDTH) * Tile.DEFAULTWIDTH + this.getWidth() - bounds.getX() + 1);
//            }
//        }
    }


    public void yToMove() {
        if(yMove  > 0 ) {
           super.getBounds();
            if (!detectCollision((int) ((bounds.x) / Tile.DEFAULTWIDTH), (int) ((bounds.y + bounds.getHeight() + yMove) / Tile.DEFAULTHEIGHT)) &&
                    !detectCollision((int) ((bounds.x + bounds.getWidth()) / Tile.DEFAULTWIDTH), (int) ((bounds.y + bounds.getHeight() + yMove) / Tile.DEFAULTHEIGHT))) {
                yPos += yMove;
            } else {
                yPos = (int) ((int)((bounds.y + bounds.getHeight() + yMove) / Tile.DEFAULTHEIGHT) * Tile.DEFAULTHEIGHT  - this.height -1 );
               // System.out.println((bounds.y + bounds.getHeight() + yMove) / Tile.DEFAULTHEIGHT + " is the tile index");
            }
        }
        if (yMove < 0){
            super.getBounds();
            if (!detectCollision((int) ((bounds.x) / Tile.DEFAULTWIDTH), (int) ((bounds.y + yMove) / Tile.DEFAULTHEIGHT)) &&
                    !detectCollision((int) ((bounds.x + bounds.getWidth()) / Tile.DEFAULTWIDTH), (int) ((bounds.y + yMove) / Tile.DEFAULTHEIGHT))) {
                yPos += yMove;
            } else {
                yPos = (int) ((int)((bounds.y + yMove) / Tile.DEFAULTHEIGHT) * Tile.DEFAULTHEIGHT + this.getHeight() - bounds.getHeight() + 1);
            }
        }

//        if (yMove > 0) {
//           // setBoundsValue();
//            if (!detectCollision((int) ((xLeftBounds) / Tile.DEFAULTWIDTH), (int) ((yBottomBounds + yMove) / Tile.DEFAULTHEIGHT)) &&
//                    !detectCollision((int) ((xRightBounds) / Tile.DEFAULTWIDTH), (int) ((yBottomBounds + yMove) / Tile.DEFAULTHEIGHT))) {
//                yPos += yMove;
//            } else {
//                yPos = (float) (((yBottomBounds + yMove) / Tile.DEFAULTHEIGHT) * Tile.DEFAULTHEIGHT - this.getHeight() - 1);
//            }
//        }
//        if (yMove < 0) {
//           // setBoundsValue();
//            if (!detectCollision((int) ((xLeftBounds) / Tile.DEFAULTWIDTH), (int) ((yTopBounds + yMove) / Tile.DEFAULTHEIGHT)) &&
//                    !detectCollision((int) ((xRightBounds) / Tile.DEFAULTWIDTH), (int) ((yTopBounds + yMove) / Tile.DEFAULTHEIGHT))) {
//                yPos += yMove;
//            } else {
//                yPos = (float) (((yTopBounds + yMove) / Tile.DEFAULTHEIGHT) * Tile.DEFAULTHEIGHT + this.getHeight() - bounds.getHeight() + 1);
//            }
//        }
    }


}
