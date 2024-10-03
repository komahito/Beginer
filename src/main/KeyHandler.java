package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import object.EnterKey;
import object.OBJ_Chest;
import object.OBJ_MapDoor;

public class KeyHandler implements KeyListener {
    private GamePanel gp;

    //  PLAYER STATE
    public boolean downPressed;
    public boolean upPressed;
    public boolean rightPressed;
    public boolean leftPressed;

    public boolean cPressed;

    // INVENTORY STATE
    public boolean inventoryPressed;

    // CHEST INVENTORY STATE
    //int i = 0;


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
            if (code == KeyEvent.VK_ENTER) {
                gp.ui.useObj();
            }
            else if (code == KeyEvent.VK_W) {
                gp.ui.minCursorRow();
            }
            else if (code == KeyEvent.VK_S) {
                gp.ui.pluCursorRow();
            }
            else if (code == KeyEvent.VK_A) {
                gp.ui.minCursorCol();
            }
            else if (code == KeyEvent.VK_D) {
                gp.ui.pluCursorCol();
            }
            else if (code == KeyEvent.VK_E) {
                gp.inventoryState = false;
                gp.playerState = true;
            }
        }

        // CHESTSTATE
        else if (gp.chestState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.chestState = false;
                gp.playerState = true;
            }
            else if (code == KeyEvent.VK_C) {
                if (gp.ui.invISChest) gp.ui.invISChest = false;
                else gp.ui.invISChest = true;
            }
            else if (!gp.ui.invISChest /*player's inv*/){
                if (code == KeyEvent.VK_W) {
                    gp.ui.minCursorRow();
                }
                else if (code == KeyEvent.VK_S) {
                    gp.ui.pluCursorRow();
                }
                else if (code == KeyEvent.VK_A) {
                    gp.ui.minCursorCol();
                }
                else if (code == KeyEvent.VK_D) {
                    gp.ui.pluCursorCol();
                }
                else if (code == KeyEvent.VK_SPACE) {
                    gp.ui.storeInChest();
                }
            } else {
                if (code == KeyEvent.VK_W) {
                    gp.ui.minCCursorRow();
                }
                else if (code == KeyEvent.VK_S) {
                    gp.ui.pluCCursorRow();
                }
                else if (code == KeyEvent.VK_A) {
                    gp.ui.minCCursorCol();
                }
                else if (code == KeyEvent.VK_D) {
                    gp.ui.pluCCursorCol();
                }
                else if (code == KeyEvent.VK_SPACE) {
                    gp.ui.takoutFromChest();
                }
            }
        
            
        }        

        // PLAYERSTATE
        else if (gp.playerState){
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }
            else if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            else if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            else if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            else if (code == KeyEvent.VK_E) {
                gp.inventoryState = true;
                gp.ui.inventoryIni();
                gp.playerState = false;
            }

            // pickup object
            else if (code == KeyEvent.VK_ENTER){
                for (int i = 0; i < gp.objs.size(); i++) {
                    if (gp.objs.get(i).adjFlag) {
                        if (gp.objs.get(i).name == "Chest" || gp.objs.get(i).name == "MapDoor" || gp.objs.get(i).name == "House") {
                            EnterKey obj = (EnterKey) gp.objs.get(i);
                            obj.run();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        else if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        else if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        else if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
