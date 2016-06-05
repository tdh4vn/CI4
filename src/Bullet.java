import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungtran on 6/5/16.
 */
public class Bullet {
    BufferedImage sprite;
    private int positionX;
    private int positionY;
    public Bullet(int x, int y) {
        try {
            sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.positionX = x;
        this.positionY = y;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void draw(Graphics g){
        g.drawImage(sprite, this.positionX, this.positionY, null);
    }

    public void update(){
        this.positionY -= 5;
    }
}
