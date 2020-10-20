package SpriteGame.UI_Menu;

import SpriteGame.Game;
import SpriteGame.GameInterFace;

import java.awt.*;

public class UIComponent implements GameInterFace {
    int xPos, yPos;
    int width, height;
    Game game;
    public boolean isHovering;
    public static Rectangle bounds;
    String words;
    Color color;

    public UIComponent(int xPos, int yPos, Game game, int width, int height, String words, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.game = game;
        this.isHovering = false;
        this.words = words;
        this.color = color;
        this.width = width;
        this.height = height;
        bounds = new Rectangle(xPos, yPos, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {

    }
}
