import java.awt.*;

/**
 * Created by hungtran on 6/12/16.
 */
public class Cat {
    Animation animation;
    private int x;
    private int y;

    public Cat(int x, int y){
        this.x = x;
        this.y = y;
        animation = new Animation("Resources/PLANE", 512, 256, 34, 4);
    }

    public void update(){
        animation.update(x, y);
    }

    public void draw(Graphics g){
        animation.draw(g);
    }
}
