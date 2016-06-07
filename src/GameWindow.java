import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hungtran on 5/28/16.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Plane player1;
    Plane player2;
    Plane player3;

    ArrayList<PlaneEnemy> enemies;

    BufferedImage bufferedImage;
    public GameWindow(){
        this.setSize(480, 600);
        this.setTitle("1945");
        this.setVisible(true);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        player1 = PlaneFighter.getInstance();
        player3 = PlaneFighter.getInstance();
        System.out.println("Da khoi tao xong");
        player2 = new PlaneSuppoter();


        enemies = new ArrayList<>();
        enemies.add(new PlaneEnemy(100, 220));
        enemies.add(new PlaneEnemy(150, 230));
        enemies.add(new PlaneEnemy(130, 210));
        enemies.add(new PlaneEnemy(110, 220));
        enemies.add(new PlaneEnemy(130, 100));
        enemies.add(new PlaneEnemy(120, 200));
        enemies.add(new PlaneEnemy(110, 300));



        for (IRocketListener iRocketListener : enemies){
            ((Subject)player1).addRocketListener(iRocketListener);
        }

        ((Subject)player1).addRocketListener(new SpaceShip());

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                player2.move(e.getX(), e.getY());
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3){
                    ((Subject)player1).fireRocket();
                }
                if (e.getButton() == MouseEvent.BUTTON2){
                    ((Subject)player1).fireRocket();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //vua an phim
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //phim duoc an va giu
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W:
                        player3.speedY = -3;
                        break;
                    case KeyEvent.VK_A:
                        player3.speedX = -3;
                        break;
                    case KeyEvent.VK_S:
                        player1.speedY = 3;
                        break;
                    case KeyEvent.VK_D:
                        player1.speedX = 3;
                        break;
                    case KeyEvent.VK_SPACE:
                        ((IFighter)player1).shot();
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //tha phim ra
                player3.speedX = 0;
                player3.speedY = 0;
            }
        });

        try {
            background = ImageIO.read(new File("Resources/Background.png"));
            player2.image = ImageIO.read(new File("Resources/PLANE2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    long count = 0;
    public void gameUpdate(){
        for (PlaneEnemy p : enemies){
            p.update();
        }
        player1.update();
        player2.update();
        count++;
        if(count == 600){
            count = 0;
            if (player2 instanceof ISupport){
                if (kc(player1.positionX, player1.positionY, player2.positionX, player2.positionY) <= 100.0f) {
                    System.out.println("abdd");
                    ((ISupport) player2).bonusHP(player1);
                }
            }
            if (player1 instanceof ISupport){
                System.out.println("abdd");
                if (kc(player1.positionX, player1.positionY, player2.positionX, player2.positionY) <= 100.0f) {
                    ((ISupport) player1).bonusHP(player2);
                }
            }
        }
    }

    private double kc(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    @Override
    public void update(Graphics g) {//de? ve~//hieu la ham draw

        if(bufferedImage == null){
            bufferedImage = new BufferedImage(480, 600, 1);
        }
        Graphics bufferedGraphics = bufferedImage.getGraphics();
        bufferedGraphics.drawImage(background, 0, 0, null);
        for (PlaneEnemy p : enemies){
            p.draw(bufferedGraphics);
        }
        player1.draw(bufferedGraphics);
        player2.draw(bufferedGraphics);
        g.drawImage(bufferedImage, 0, 0,null);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(17);
                gameUpdate();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
