import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hungtran on 5/29/16.
 */

public class Plane {
    public int positionX;
    public int positionY;
    public BufferedImage image;
    public int healthPoint;
    public int maxHP;
    public int speedX;
    public int speedY;
    private Image hpBar;
    public Plane(){
        this.positionX = 200;
        this.positionY = 300;
        healthPoint = 200;
        maxHP = 200;
        try {
            this.image = ImageIO.read(new File("Resources/PLANE1.png"));
            this.hpBar = ImageIO.read(new File("Resources/hp.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Plane(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        healthPoint = 200;
        maxHP = 200;
        try {
            this.image = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move(int x, int y){
        positionY = y;
        positionX = x;
    }

    public void update(){
        this.positionX += this.speedX;
        this.positionY += this.speedY;
    }
    public void draw(Graphics g){
        g.drawImage(this.image, this.positionX, this.positionY, null);
        g.drawImage(this.hpBar, this.positionX, this.positionY + 65,
                                this.positionX + 70 * healthPoint/maxHP, this.positionY + 79,
                                0, 0, 200, 14, null);
    }
}
