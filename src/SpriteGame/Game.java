package SpriteGame;

import SpriteGame.Display.Display;
import SpriteGame.Graphics.Assets;
import SpriteGame.State.GameState;
import SpriteGame.State.MenuState;
import SpriteGame.State.State;
import SpriteGame.State.StateController;
import SpriteGame.Listeners.MouseManager;
import SpriteGame.Listeners.KeyBoardListener;
import SpriteGame.Worlds.Camera;
import SpriteGame.Worlds.World;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * There are several States - gameState, menuState, etc
 * StateController switch around the States.
 * Game.java is the control panel to show display and call all necessary classes
 * Launch.java is the main() for start the game
 * GameState has world.java as background and player as foreground. They both are
 * instantiated inside the gameState.
 *
 * I change all xPos and yPos to int instead of float
 */

public class Game implements Runnable {
    Display display;
    Thread thread; // treat this game as a new thread
    static boolean running = true;
    // render images
    Graphics2D g;
    BufferStrategy bs;
    // Assets
    Assets asset;
    // Input
    KeyBoardListener keyListener;
    MouseManager mouseManager;
    // State
    GameState gameState;
    MenuState menuState;
    State state;
    // Camera
    Camera camera;

    public Game() {
        // not define anything here - in case there are exception, game can't be started
        // also any super abstract class method can't be called inside constructor because it
        // it hasn't been created yet
    }

    // layout the components
    public void init() {

        display = new Display();
        asset = Assets.getInstance();
        camera = new Camera(this);
        gameState = new GameState(this);
        menuState = new MenuState(this);
        keyListener = new KeyBoardListener();
        mouseManager = new MouseManager();
        display.getCanvas().addKeyListener(keyListener);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        // this state has to be connected with game.java, for state switch
        state = StateController.setState(menuState);
    }

    public void tick() {
        state.tick();
    }

    public void render() {
        // create bufferStrategy inside render(), not init()
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = (Graphics2D) bs.getDrawGraphics();
        ///////drawing start here
        // must constantly clear the previous drawing
        g.clearRect(0, 0, display.getWidth(), display.getHeight());

        //oooo FIRST STEP oooo//
        state.render(g);

        /////// drawing end here
        bs.show(); // move graphics from one back buffer to the front buffer
        g.dispose();

    }

    @Override
    public void run() {

        init();
        // set up timer
        int fps = 60;
        long nanoTimePerFrame = (long) (1e9 / fps);
        //  System.out.println("nanoTimePerFrame :" + nanoTimePerFrame);
        long timeElipsed = 0;
        long startCountingTime = System.nanoTime();  // not currentMilliTime
        long now;
//        int counter = 0;
//        long oneSecond = 0;

        while (running) {
            // every one time frame update once the tick and render
            now = System.nanoTime();
            timeElipsed += now - startCountingTime;
            // System.out.println("timeElipsed :" + timeElipsed);
            startCountingTime = now;
            if (timeElipsed >= nanoTimePerFrame) {
                //System.out.println("inside if block inside while loop");
                tick();
                render();
//                counter++;
//                oneSecond +=timeElipsed;
                timeElipsed = 0;
            }
            // for testing if the 60 fps is achieved
//            if(oneSecond >= 1e9){
//                System.out.println("Ticks " + counter );
//                oneSecond = 0;
//                counter =0;
//            }
        }
        stop();
    }

    // to be called to start the game thread
    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Camera getCamera() {
        return camera;
    }

    public int getWidth() {
        return display.getWidth();
    }

    public int getHeight() {
        return display.getHeight();
    }

    public World getWorld() {
        return gameState.getWorld();
    }

    public KeyBoardListener getKeyListener() {
        return keyListener;
    }

    public MouseManager getMouseManager(){ return mouseManager;}
    public Assets getAsset() {
        return asset;
    }
    public GameState getGameState() {
        return gameState;
    }
    public MenuState getMenuState() {
        return menuState;
    }

    public State getState() {
        return state;
    }

    public Graphics2D getGraphics() {
        return g;
    }

    public void setState(State state) {
        this.state = state;
    }
}
