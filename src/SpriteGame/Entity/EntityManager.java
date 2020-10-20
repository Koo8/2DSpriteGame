package SpriteGame.Entity;

import SpriteGame.Entity.Creatures.Player;
import SpriteGame.Entity.NonCreature.Gold;
import SpriteGame.Entity.NonCreature.Tree;
import SpriteGame.Game;
import SpriteGame.GameInterFace;
import SpriteGame.ItemsOnGround.GoldItem;
import SpriteGame.ItemsOnGround.ItemManager;
import SpriteGame.ItemsOnGround.TreeItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager implements GameInterFace {
    private ArrayList<Entity> entities;
    // for sorting entity y coordiate for rendering order. this will solve the player
    // appear in the front with lower y than other entity, appear in the back when higher
    //y than other entity
    private Comparator<Entity> comparator;
    public Player player;
    private ItemManager itemManager;
    private Game game;

    public EntityManager(Game game) {
        this.game = game;
        entities = new ArrayList<>();
        itemManager = new ItemManager(game);
        player = new Player(game, 100, 150);
        // player is added to entityManager so that its yPos can be compared with other entities
        entities.add(player);
        comparator = new Comparator<Entity>() {
            @Override
            public int compare(Entity a, Entity b) {
                if (a.getyPos() + a.getHeight() < b.getyPos() + b.getHeight()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
    }

    // OOOO FIFTH STEP OOOO //
    @Override
    public void tick() {
        /**
         *  To solve the ConCurrentModificationException check
         *  https://stackoverflow.com/questions/223918/iterating-through-a-collection-avoiding-concurrentmodificationexception-when-re
         */

        // loop through all entities, all needs to tick()
        // solution for avoid exception: 
//        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
//            String string = iterator.next();
//            if (string.isEmpty()) {
//                // Remove the current element from the iterator and the list.
//                iterator.remove();
//            }
//        }
        for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext(); ) {
            Entity e = iterator.next();
            if (e.health <= 0) {
                if (e instanceof Tree)
                    itemManager.addItem(new TreeItem(game, e.getxPos(), e.getyPos()));
                else if(e instanceof Gold)
                    itemManager.addItem(new GoldItem(game,e.getxPos(),e.getyPos()));
                iterator.remove();
                continue;
            }
            e.tick();
        }
        // sort entities in yPos order before rendering
        entities.sort(comparator);
    }

    @Override
    public void render(Graphics2D g) {
        // System.out.println("Total "+ entities.size());
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void addEntity(Entity ent) {
        entities.add(ent);
    }

    // this method cause exception, use iterator<Entity> instead
//    public void removeEntity(Entity ent) {
//        entities.remove(ent);
//    }

    public Player getPlayer() {
        return player;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
