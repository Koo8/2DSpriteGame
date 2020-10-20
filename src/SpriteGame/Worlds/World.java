package SpriteGame.Worlds;

import SpriteGame.Entity.EntityManager;
import SpriteGame.Entity.NonCreature.Gold;
import SpriteGame.Entity.NonCreature.Tree;
import SpriteGame.Game;
import SpriteGame.GameInterFace;
import SpriteGame.Inventory.Inventory;
import SpriteGame.ItemsOnGround.ItemManager;
import SpriteGame.Tiles.Tile;
import SpriteGame.Utils.Util;

import java.awt.*;

public class World implements GameInterFace {
    int worldWidth;
    int worldHeight;
    public EntityManager entityManager;
    public ItemManager itemManager;
    public Inventory inventory;

    private int[][] tilesIndex;
    private Camera camera;
    private Game game;
    private Tile grassTile, dirtTile, rockTile, treeTile, iconTile;

    public World(Game game, String path) {
        this.game = game;
        grassTile = new Tile(game.getAsset().getGrass(), false, false);
        dirtTile = new Tile(game.getAsset().getDirt(), false, false);
        rockTile = new Tile(game.getAsset().getRock(), true, false);
        treeTile = new Tile(game.getAsset().getTree(), true, false);
        iconTile = new Tile(game.getAsset().getInventIcon(), true, true);

        assignTilesFromFile(path);
        camera = game.getCamera();

        entityManager = new EntityManager(game);
        itemManager = entityManager.getItemManager();
        inventory = itemManager.getInventory();
        addEntitiesToWorld();

    }

    private void addEntitiesToWorld() {
        entityManager.addEntity(new Tree(game, 200,100));
        entityManager.addEntity(new Tree(game,300,230));
        entityManager.addEntity(new Tree(game, 100, 300));
        for (int i = 0; i <5 ; i++) {
          entityManager.addEntity(new Gold(game,200,400+i*70));
        }
    }

    private void assignTilesFromFile(String path) {
        // load the world file
        String worldMap = Util.loadFileToString(path);
        // break up the map string into small number strings
        String[] tokens = worldMap.split("\\s+");  // the length should be 404 digit strings
        // assign the first 4 digit strings
        worldWidth = Util.parseStringToInt(tokens[0]);
        worldHeight = Util.parseStringToInt(tokens[1]);

        // assign the 20 x 20 digits to Tiles
        tilesIndex = new int[worldWidth][worldHeight];
        for (int y = 0; y < worldHeight; y++) {
            for (int x = 0; x < worldWidth; x++) {
                tilesIndex[x][y] = Util.parseStringToInt(tokens[x + y * worldWidth + 2]);
            }
        }
    }

    public Tile getTile(int x, int y) {
        // in case x or y are illegal
        if (x < 0 || y < 0 || x >= worldWidth || y >= worldHeight) {   // "=" is important, otherwise when reach edge, outofbounderyexception will thrown
            return grassTile;
        }
        // get tile from its x and y coordinates
        if (tilesIndex[x][y] == 0) return grassTile;
        else if (tilesIndex[x][y] == 1) return rockTile;
        else if (tilesIndex[x][y] == 2) return dirtTile;
        else if (tilesIndex[x][y] == 3) return treeTile;
        else if (tilesIndex[x][y] == 4) return iconTile;
        else return grassTile;
    }
    // OOOO FORTH STEP OOOO //
    @Override
    public void tick() {
        entityManager.tick();
        itemManager.tick();
        inventory.tick();
    }

    public void render(Graphics2D g) {
        // for effectively only render tiles that within the viewPort(camera), change
        // 0 to xStart and yStart, both these can be 0 or the tile index that starts to be seen
        // in the viewPort; change worldHeight and worldWidth to xEnd and yEnd, both of
        // which can be maximum the 20 defined by the world1.txt file or can be the last tile index
        // that can be seen on the camera
        int xStart = (int) Math.max(0, camera.getxOffset() / Tile.DEFAULTWIDTH);
        int yStart = (int) Math.max(0, camera.getyOffset() / Tile.DEFAULTHEIGHT);
        int xEnd = (int) Math.min(worldWidth, (camera.getxOffset() + game.getWidth()) / Tile.DEFAULTWIDTH + 1);
        int yEnd = (int) Math.min(worldHeight, (camera.getyOffset() + game.getHeight()) / Tile.DEFAULTHEIGHT + 1);
        // change y from 0 to worldHeight  -> y from yStart to yEnd --> do the same to x
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.DEFAULTWIDTH - camera.getxOffset()), (int) (y * Tile.DEFAULTHEIGHT - camera.getyOffset()));
            }
        }
        entityManager.render(g);
        itemManager.render(g);
        inventory.render(g);
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }


}
