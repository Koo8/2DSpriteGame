package SpriteGame.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class SpriteSheet {
    private String path;
    private BufferedImage image;

    public SpriteSheet(String path) {
        this.path = path;
    }

    public BufferedImage getImage() {
        try {
            image = ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            System.out.println("file path is not found.");
        }
        return image;
    }
}
