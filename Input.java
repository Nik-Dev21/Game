import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
    public boolean upPressed,  downPressed, leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // gets the key that was pressed
        if(code == KeyEvent.VK_W) { // Checks if "W" was pressed
            upPressed = true;
        }
        if(code == KeyEvent.VK_A) { // Checks if "A" was pressed
            leftPressed  = true;
        }
        if(code == KeyEvent.VK_S) { // Checks if "S" was pressed
            downPressed = true;
        }
        if(code == KeyEvent.VK_D) { // Checks if "D" was pressed
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W) { // Checks if "W" was unpressed
            upPressed = false;
        }
        if(code == KeyEvent.VK_A) { // Checks if "A" was unpressed
            leftPressed  = false;
        }
        if(code == KeyEvent.VK_S) { // Checks if "S" was unpressed
            downPressed = false;
        }
        if(code == KeyEvent.VK_D) { // Checks if "D" was unpressed
            rightPressed = false;
        }
    }
}
