import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements Runnable {
    final int size = 16;
    final int scale = 3;

    /* create the size for the game window*/
    final int tileSize = size * scale;
    final int column = 16;
    final int row = 12;
    final int screenWidth = tileSize * column;
    final int screenHeight = tileSize * row;
    Input keyH = new Input();
    int fps = 60;

    /* set playing location*/
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    /* Create a Game clock for animation*/
    Thread gameThread;

    /* set the panel size*/
    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /* The main game loop is done in the run() method*/
    @Override
    public void run() {
        double interval = 1000000000 / fps;
        double nextDrawTime = System.nanoTime() + interval;
        while (gameThread != null) {
            //System.out.println("The game is running");
            // used for things like this:

            //1.Updating character position
            update();

            //2.Drawing the screen(character position) with updated info
            repaint();
            try {
                double currentTime = nextDrawTime - System.nanoTime();
                currentTime /= 1000000;
                if (currentTime < 0) {
                    currentTime = 0;
                }
                Thread.sleep((long) currentTime);
                nextDrawTime += interval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

}