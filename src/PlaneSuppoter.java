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

}
