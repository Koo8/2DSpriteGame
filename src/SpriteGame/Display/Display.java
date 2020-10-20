package SpriteGame.Display;
import javax.swing.*;
import java.awt.*;

/**
 *  JFrame from Swing, canvas from awt. check
 *  https://www.oracle.com/technical-resources/articles/java/mixing-components.html
 */

public class Display extends JFrame {
    private Canvas canvas; // play game use canvas instead of JPanel
    private int width, height;
    public Display () {
//        width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//        height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        width = 500;
        height = 500;
        setTitle("2D Sprite Game in Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // next two lines work together to set the JFrame in the center

        setSize(width, height); // this defination
        setLocationRelativeTo(null);
        setResizable(false);

        canvas= new Canvas(); // canvas has bufferStrategy which has getDrawGraphics() to produce a Graphics2D
        // set canvas to a fixed size
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        add(canvas);

        pack();
        setVisible(true);
    }
    public Canvas getCanvas(){
        return canvas;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
