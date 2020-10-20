package SpriteGame;
/* For launch the game */

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game()::start);
    }
}
