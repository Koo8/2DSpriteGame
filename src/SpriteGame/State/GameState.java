package SpriteGame.State;

import SpriteGame.Game;
import SpriteGame.Worlds.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    public GameState(Game game) {
        super(game);
        // instantiate world and player inside GameSate
        world = new World(game,"res/worlds/world1.txt");
    }
    // OOOO THIRD STEP OOOO //
    @Override
    public void tick() {
         world.tick();
         // for state switch
        if(game.getKeyListener().isExit()) {
            System.out.println("game state is exited");
            game.setState(game.getMenuState());
        }

    }

    @Override
    public void render(Graphics2D g) {
        world.render(g);
    }

    public World getWorld() {
        return world;
    }
}
