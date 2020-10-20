package SpriteGame.Graphics;

import java.awt.image.BufferedImage;

/**
 * load assets once and retrieve all images from it
 * changed Assets to Singleton Pattern
 */


public class Assets {
    private static Assets instance = new Assets();
    SpriteSheet spriteSheet;
    BufferedImage player, dirt, rock, tree, grass, gold, inventoryIcon;
    BufferedImage[] playerDown = new BufferedImage[3];
    BufferedImage[] playerUp = new BufferedImage[3];
//    BufferedImage[] playerLeft = new BufferedImage[3];
//    BufferedImage[] playerRight = new BufferedImage[3];
    BufferedImage[] explosives = new BufferedImage[3];

    int width, height;
    public static final int DEFAULTWIDTH = 64;
    public static final int DEAFULTHEIGHT = 64;

    private Assets() {  // private constructor - Singleton Pattern
        width = 32;
        height = 32;
        spriteSheet = new SpriteSheet("res/textures/spritesheet.png");
        grass = crop(0, 0, width, height);
        player = crop(0, height, width, height);
        dirt = crop(width, 0, width, height);
        rock = crop(width * 2, 0, width, height);
        tree = crop(width * 3, 0, width, height);
        gold = crop(0,height*2, width, height);
        inventoryIcon = crop(0,height*3, width, height);
        setDownImages();
        setUpImages();
        setExplosives();

    }

    private void setExplosives() {
        explosives[0] = crop(width, height*2, width, height);
        explosives[1] = crop(width*2, height*2, width, height);
        explosives[2] = crop(width*3, height*2, width, height);

    }

    public static Assets getInstance() {
        return instance;
    }

    public void setDownImages() {
        playerDown[0] = crop(width, height, width, height);
        playerDown[1] = crop(width * 2, height, width, height);
        playerDown[2] = crop(width * 3, height, width, height);
    }

    public void setUpImages() {
        playerUp[2] = crop(width, height, width, height);
        playerUp[1] = crop(width * 2, height, width, height);
        playerUp[0] = crop(width * 3, height, width, height);
    }

    private BufferedImage crop(int x, int y, int width, int height) {
        return spriteSheet.getImage().getSubimage(x, y, width, height);
    }

    public BufferedImage getDirt() {
        return dirt;
    }

    public BufferedImage getPlayer() {
        return player;
    }

    public BufferedImage getRock() {
        return rock;
    }

    public BufferedImage getTree() {
        return tree;
    }

    public BufferedImage getGrass() {
        return grass;
    }

    public BufferedImage[] getDownImages() {
        return playerDown;
    }

    public BufferedImage[] getUpImages() {
        return playerUp;
    }
    public  BufferedImage getGold (){ return gold;}

    public BufferedImage[] getExplosives() {
        return explosives;
    }
    public BufferedImage getInventIcon(){ return inventoryIcon;}
}
