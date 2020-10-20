package SpriteGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static final int DEFAULTHEIGHT = 64;
    public static final int DEFAULTWIDTH = 64;
    private BufferedImage image;
    private boolean isSolid;
    private boolean isIcon;

    public Tile(BufferedImage image, boolean isSolid, boolean isIcon){
        this.image = image;
        this.isSolid = isSolid;
        this.isIcon = isIcon;
    }

    public void render(Graphics2D g, int x, int y) {
        g.drawImage(image, x, y,DEFAULTWIDTH, DEFAULTHEIGHT, null);
    }
    // for collision detection
    public boolean checkisSolid() {
        return isSolid; // default the tile is ok to walk on.
    }
    public boolean checkisIcon(){
        return isIcon;
    }
}
