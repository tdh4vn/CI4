import java.awt.*;
import java.util.List;

/**
 * Created by hungtran on 6/4/16.
 */

//khi o gan dong doi, tang cho dong doi 10mau 1 giay
public class PlaneSuppoter extends Plane implements ISupport {
    @Override
    public void bonusHP(List<Plane> planes) {
        for(Plane plane : planes){
            plane.healthPoint += 10;
            System.out.println(plane.healthPoint);
        }

    }

    @Override
    public void bonusHP(Plane plane) {
        plane.healthPoint += 10;
        System.out.println(plane.healthPoint);
    }

    @Override
    public void update() {
        super.update();
        Rectangle myPlane = new Rectangle(this.positionX, this.positionY
                , this.image.getWidth(), this.image.getHeight());
        for(Bullet b : PlaneFighter.getInstance().getListBullets()){
            Rectangle rectCurrentBullet = new Rectangle(b.getPositionX(), b.getPositionY(),
                                            b.getSprite().getWidth(), b.getSprite().getHeight());

            if (myPlane.intersects(rectCurrentBullet)){
                this.healthPoint -= 5;
                PlaneFighter.getInstance().getListBullets().remove(b);
            }
        }
    }
}
