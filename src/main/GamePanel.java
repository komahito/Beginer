package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTING
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = 48; // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //FPS
    int FPS = 60;

    //SYSTEM and WORLD SETTING
    public int maxWorldCol;
    public int maxWorldRow; // defined by tileM
    public int currentMapNum = 0;
    public final int maxMapNum = 10;
    public TileManager tileM = new TileManager(this); // handle mapTileNum[row][col]
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);

    //ENTITY AND OBJECT
    public Player player = new Player(this, keyH);

    // STATE
    public boolean gameFinished = false;
    public boolean inventoryState = false;
    public boolean playerState = true;
    public boolean chestState = false;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {
        aSetter.setObject();

        //playMusic(0);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        double currentTime;
        double lastTime = System.nanoTime();

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                // UPDATE
                update();
                // DRAW
                repaint();

                if (gameFinished) {
                    //System.out.println("(*''*)");
                    gameThread = null;
                }

                delta--;
            }
        }
    }

    public void update() {

        player.update();

    }
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // TILE
        tileM.draw(g2);
        
        // OBJECT
        for (int i = 0; i < aSetter.getSize(); i++) {
            aSetter.getObj(i).draw(g2, this);
        }

        // PLAYER
        player.draw(g2);

        // UI
        ui.draw(g2);

        g2.dispose();
    }

    // public void playMusic (int i) {
    //     sound.setFile(i);
    //     sound.play();
    //     sound.loop();

    // }

    // public void stopMusic () {
    //     sound.stop();
    // }

    // public void playSE (int i) {
    //     sound.setFile(i);
    //     sound.play();
    // }
}
