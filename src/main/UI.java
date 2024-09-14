package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {
    GamePanel gp;
    Font arial_40, arial_80B;
    Graphics2D g2;
    
    //MESSAGE
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    
    //KEY
    BufferedImage keyImage;
    
    //TIME
    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.0");

    //INVENTORY
    private final int maxCursorcol = 5;
    private final int maxCursorRow = 4;
    protected int cursorCol = 0;
    protected int cursorRow = 0;

    public UI (GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);

        OBJ_Key key = new OBJ_Key(gp);
        keyImage = key.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw (Graphics2D g2) {
        this.g2 = g2;
        if (gp.gameFinished) {
            drawFinish();
        } else {
            // KEY
            drawKey();

            // TIME
            drawTime();

            // MESSAGE
            if (messageOn) {
                drawMessage();
            }

            // INVENTORY
            if (gp.inventoryState) {
                drawInventory();
            }
        }
    }

    public void drawSubwindow(int x, int y, int width, int height) {
        Color color = new Color(255, 255, 255, 210);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        color = new Color(0, 0, 0);
        g2.setColor(color);
        g2.setStroke(new BasicStroke());
        g2.fillRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void inventoryIni() {
        cursorCol = 0;
        cursorRow = 0;
    }

    public void pluCursorCol () {
        if (cursorCol < maxCursorcol - 1) cursorCol++;
    }

    public void minCursorCol () {
        if (cursorCol > 0) cursorCol--;
    }

    public void pluCursorRow() {
        if (cursorRow < maxCursorRow - 1) cursorRow++;
    }

    public void minCursorRow () {
        if (cursorRow > 0) cursorRow--;
    }
    
    private void drawInventory() {
        final int framX = gp.tileSize * 9;
        final int framY = gp.tileSize;
        final int framWidth = gp.tileSize * 6;
        final int framHeight = gp.tileSize * 5;
        drawSubwindow(framX, framY, framWidth, framHeight);

        final int slotStartX = framX + 20;
        final int slotStartY = framY + 20;
        int slotX = slotStartX;
        int slotY = slotStartY;
        int slotSize = gp.tileSize - 4;

        for (int i = 0; i < gp.player.inventory.size(); i++) {
            g2.drawImage(gp.player.inventory.get(i).image, slotX + 2, slotY + 2, slotSize, slotSize, null);
            slotX += gp.tileSize;

            if (i == 4 || i == 9 || i == 14) {
                slotX = slotStartX;
                slotY += gp.tileSize;
            }
        }

        slotX = slotStartX;
        slotY = slotStartY;

        int cursorX = slotX + cursorCol * gp.tileSize;
        int cursorY = slotY + cursorRow * gp.tileSize;
        int cursorSize = gp.tileSize - 2;

        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke());
        g2.drawRoundRect(cursorX + 1, cursorY + 1, cursorSize, cursorSize, 10, 10);
    }
    
    public void drawMessage() {
        g2.setFont(g2.getFont().deriveFont(30F));
        g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

        messageCounter++;
        if (messageCounter > 120) {
            messageCounter = 0;
            messageOn = false;
        }
    }

    public void drawTime() {
        playTime += (double) 1/60;
        // g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize*11, 65); // I hate to display this for all time...
    }

    public void drawKey() {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.hasKey, 74, 65);
    }

    public void drawFinish () {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        String text;
        int textLength;
        int x;
        int y;

        text = "You found the treasure!";
        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth / 2 - textLength / 2;
        y = gp.screenHeight / 2 - (gp.tileSize * 3);

        g2.drawString(text, x, y);


        text = "Your time is " + dFormat.format(playTime) + "sec.";
        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth / 2 - textLength / 2;
        y = gp.screenHeight / 2 + (gp.tileSize * 4);

        g2.drawString(text, x, y);


        g2.setFont(arial_80B);
        g2.setColor(Color.yellow);
        text = "Congratulation!";
        textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth / 2 - textLength / 2;
        y = gp.screenHeight / 2 + (gp.tileSize * 2);

        g2.drawString(text, x, y);
    }
}
