package SpriteGame.State;

import SpriteGame.Game;
import SpriteGame.UI_Menu.StartButton;

import java.awt.*;

public class MenuState extends State {
    StartButton startButton;

    public MenuState(Game game) {   
        super(game);
        startButton = new StartButton(game,200,200,128,64,new Color(255,33,50),"Go to Game");
    }

    //OOOO SECOND STEP OOOO//
    @Override
    public void tick() {
        game.getMouseManager().checkMouseOverButton();
        if (game.getMouseManager().isLeftPressed()&& game.getMouseManager().isHovering) {
            game.setState(game.getGameState());
            //System.out.println(game.getState() + " is the new state");

        }
    }

    @Override
    public void render(Graphics2D g) {
        startButton.render(g);
        
    }
}
