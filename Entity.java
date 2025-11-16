import java.awt.*;

public class Entity {
    int xPos;
    int yPos;
    Color c;
    int sizeX;
    int sizeY;
    Entity(int sizeX, int sizeY, int xPos, Color c,int yPos) {
        this.c = c;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void paint(Graphics g, Color c, int xPos, int yPos, int sizeX, int sizeY  ) {
        Graphics2D g2d = (Graphics2D)g; // convert g to graphics 2d
        g2d.setColor(c);
        g2d.fillRect(xPos, yPos, sizeX, sizeY); // draw something
    }
}
