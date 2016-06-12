import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hungtran on 6/12/16.
 */
public class Animation {
    public static final int SPRITE_SHEET = 1;
    public static final int SPRITE_WITH_IMAGES = 2;
    private int x;
    private int y;
    private int index;
    private int speed;
    private int count;
    private ArrayList<BufferedImage> spriteFrames;

    public Animation(String imagePath, int width, int height, int speed){
        index = 0;
        count = 0;
        this.speed = speed;
        spriteFrames = new ArrayList<>();
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            for (int i = 0; i < image.getHeight() / height; i++) {
                for (int j = 0; j < image.getWidth() / width; j++) {
                    spriteFrames.add(image.getSubimage(width * j, height * i, width, height));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Animation(String imagePath, int width, int height, int speed, int numberFrame){
        index = 0;
        count = 0;
        this.speed = speed;
        spriteFrames = new ArrayList<>();

        for (int i = 1; i <= numberFrame; i++){
            try {
                spriteFrames.add(
                        ImageIO.read(new File(imagePath + i +".png")));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void update(int x, int y){//17ms
        this.x = x;
        this.y = y;
        count++;
        if (count * 17 >= speed){
            index++;
            if (index == spriteFrames.size()){
                index = 0;
            }
            count = 0;
        }

    }
    public void draw(Graphics g){
        g.drawImage(spriteFrames.get(index), x, y, null);
    }
}
