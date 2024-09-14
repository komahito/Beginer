package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gp;

    //  PLAYER STATE
    public boolean downPressed;
    public boolean upPressed;
    public boolean rightPressed;
    public boolean leftPressed;

    // INVENTORY STATE
    public boolean inventoryPressed;

    public KeyHandler (GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        // INVENTORYSTATE

        if (gp.inventoryState) {
            if (code == KeyEvent.VK_W) {
                gp.ui.minCursorRow();
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.pluCursorRow();
            }
            if (code == KeyEvent.VK_A) {
                gp.ui.minCursorCol();
            }
            if (code == KeyEvent.VK_D) {
                gp.ui.pluCursorCol();
            }
        }

        // PLAYERSTATE
        if (gp.playerState){
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
        }

        if (code == KeyEvent.VK_C) {
            if (!gp.inventoryState) {
                gp.inventoryState = true;
                gp.ui.inventoryIni();
                gp.playerState = false;
            }
            else {
                gp.inventoryState = false;
                gp.playerState = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
