package SpriteGame.ItemsOnGround;

import SpriteGame.Game;
import SpriteGame.GameInterFace;
import SpriteGame.Inventory.Inventory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager implements GameInterFace {
    private ArrayList<Item> items;
    public Inventory inventory;
    private Game game;

    public ItemManager(Game game) {
        this.game = game;
        items = new ArrayList<>();
        inventory = new Inventory(game);
    }
    @Override
    public void tick() {
        if (items.size() == 0) return;
        Iterator<Item> it = items.iterator();
        while(it.hasNext()) {
            Item i = it.next();
            if( i.bounds.intersects(
                    game.getWorld().getEntityManager().getPlayer().getBounds())) {
                it.remove();
                addtoInventory(i);
            }
            i.tick();
        }

    }

    private void addtoInventory(Item i) {
        inventory.getInventoryItems().add(i);
        if(i instanceof TreeItem) {
            inventory.treeCount++;
        } else if(i instanceof GoldItem) {
            inventory.goldCount++;
        }
    }

    @Override
    public void render(Graphics2D g) {
       // System.out.println("items in render() " + items.size() );
        if(items.size() == 0) return;
        for(Item i:items){
            i.render(g);
        }
    }
    public void addItem(Item item){
        items.add(item);
    }

    public Inventory getInventory() {
        return inventory;
    }
}
