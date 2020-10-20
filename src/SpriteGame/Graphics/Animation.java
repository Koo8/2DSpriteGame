package SpriteGame.Graphics;

import java.awt.image.BufferedImage;

/**
 * This class is used as BufferedImage[] where a single image
 * can be replaced with an animation
 */

public class Animation {
   // it has two direction animations
   //private int upAnim, downAnim, leftAnim, rightAnim;
   private long timer, timeElasped, now;
   private BufferedImage[] images;
   private int index;

   public Animation(BufferedImage[] myImages ) {
       images = myImages;
       index = 0;
       timer = 0;
       now = 0;
       timeElasped = 500;
   }

   public void getImageIndex(){
       if (timer < timeElasped) {
           timer += System.currentTimeMillis() - now;
           now = System.currentTimeMillis();
       } else {
           index++;
           timer = 0;
           if(index >=images.length ) index = 0;
       }
   }
   

   public  BufferedImage getCurrentImage() {
       getImageIndex();
       return images[index];
   }


}
