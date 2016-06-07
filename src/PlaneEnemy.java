/**
 * Created by hungtran on 6/7/16.
 */
public class PlaneEnemy extends Plane implements IRocketListener {
    public PlaneEnemy(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }
    @Override
    public void planeFireRocket() {
        System.out.println("Chet roi nhe");
    }
}
