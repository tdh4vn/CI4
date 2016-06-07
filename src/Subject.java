/**
 * Created by hungtran on 6/7/16.
 */
public interface Subject {
    void addRocketListener(IRocketListener iRocketListener);
    void deleteRocketListener(IRocketListener iRocketListener);
    void fireRocket();
}
