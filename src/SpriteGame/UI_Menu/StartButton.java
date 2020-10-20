package SpriteGame.UI_Menu;

import SpriteGame.Game;

import java.awt.*;

public class StartButton extends UIComponent {


    public StartButton(Game game, int xPos, int yPos, int width, int height, Color color, String words) {
        super(xPos,yPos,game,width, height, words,color);

    }

    @Override
    public void render(Graphics2D g) {
        if(game.getMouseManager().isHovering) {
            g.setColor(color);
            g.fillRect(xPos,yPos,width,height);
            g.setColor(Color.WHITE);
            g.drawString(words, xPos + 35, yPos + 25);

        } else{
            g.setColor(color);
            g.drawRect(xPos,yPos,width,height);
            g.setColor(color);
            g.drawString(words, xPos + 35, yPos + 25);

        }

    }

}
