package SpriteGame.Inventory;

import SpriteGame.Game;
import SpriteGame.GameInterFace;
import SpriteGame.ItemsOnGround.GoldItem;
import SpriteGame.ItemsOnGround.Item;
import SpriteGame.ItemsOnGround.ItemManager;
import SpriteGame.ItemsOnGround.TreeItem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ToDo: to build an inventory system that
 * 1. can be opened up by click its icon
 * 2. can be moved by mouse drag
 * 3. can display image of Inventory and its count
 * 4.
 *
 * this class is triggered by ItemManager.java when items are removed.
 */

public class Inventory implements GameInterFace {
    private ArrayList<Item> inventoryItems;
    private String gold = "Gold", tree = "Tree";
    public int goldCount, treeCount;
    private Game game;
    private boolean enterClicked;
    private BufferedImage inventoryChart;
    public Inventory(Game game){
        this.game = game;
        inventoryItems = new ArrayList<>();
        goldCount = 0;
        treeCount = 0;
        enterClicked = false;
        inventoryChart = loadChart();
    }

    private BufferedImage loadChart() {
        try {
           return ImageIO.read(new File("res/inventory/inventorychart.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    @Override
    public void tick() {
        // constantly listen to the keyboard event
        checkEnterKey();

    }
    private void checkEnterKey() {
        if (game.getKeyListener().isLastInvetory()) {
            enterClicked = true;
           // System.out.println("inside if block - enterClicked is true");
        }else if (!game.getKeyListener().isLastInvetory()){

            enterClicked = false;
        }
    }

    @Override
    public void render(Graphics2D g) {
        // draw inventory window when Enter is true;
        // draw a table with item name and item count
        // once rendered, stop player's move
        //g.drawString("this is for inventory window", 100, 300);
        if(enterClicked) {
           // System.out.println("inside if block of render in inventory - should draw inventory");
           g.drawImage(inventoryChart,50,50,300, 380, null);
           g.drawString("Gold",125, 136);
           g.drawString(Integer.toString(goldCount), 260, 136);
           g.drawString("Tree",125, 176);
           g.drawString(Integer.toString(treeCount), 260, 176);
        }
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }
}
