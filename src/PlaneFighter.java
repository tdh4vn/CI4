/**
 * Created by hungtran on 6/4/16.
 */
public class PlaneFighter extends Plane implements IFighter, IStrategy {
    public PlaneFighter(int x, int y) {
        super(x, y);
    }

    @Override
    public void shot() {
        System.out.println("Shot");
    }

    @Override
    public void dropBom() {
        System.out.println("asdas");
    }
}
