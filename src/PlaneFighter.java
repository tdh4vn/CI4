import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hungtran on 6/4/16.
 */
public class PlaneFighter extends Plane implements IFighter, IStrategy, Subject {

    private ArrayList<IRocketListener> iRocketListenerList;

    private ArrayList<Bullet> listBullets;

    private static PlaneFighter sharePointer;

    public ArrayList<Bullet> getListBullets() {
        return listBullets;
    }

    public static PlaneFighter getInstance(){
        if(sharePointer == null){
            sharePointer = new PlaneFighter(200, 300);
        }
        return sharePointer;
    }

    private PlaneFighter(int x, int y) {
        super(x, y);
        iRocketListenerList = new ArrayList<>();
        listBullets = new ArrayList<>();
    }

    @Override
    public void update() {
        super.update();
        for (Bullet b : listBullets){
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for (Bullet b : listBullets){
            b.draw(g);
        }
    }

    @Override
    public void shot() {
        listBullets.add(new Bullet(this.positionX, this.positionY, this));
    }

    @Override
    public void deleteBullet(Bullet bullet) {
        System.out.println("Xoa dan");
    }

    @Override
    public void dropBom() {
        System.out.println("asdas");
    }

    @Override
    public void addRocketListener(IRocketListener iRocketListener) {
        iRocketListenerList.add(iRocketListener);
    }

    @Override
    public void deleteRocketListener(IRocketListener iRocketListener) {
        iRocketListenerList.remove(iRocketListener);
    }

    @Override
    public void fireRocket() {
        System.out.println("Ban Ten Lua");
        for (IRocketListener iRocketListener : iRocketListenerList){
            iRocketListener.planeFireRocket();
        }
    }
}
