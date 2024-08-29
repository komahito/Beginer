package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);

    //ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public SuperObject[] obj = new SuperObject[10];
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setUpGame() {
        aSetter.setObject();

        playMusic(0);
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

                delta--;
            }
        }
    }

    public void update() {

        player.update();

    }
    public void paintComponent(Graphics g) {
        
        //System.out.println("Hello World!!");

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // TILE
        tileM.draw(g2);
        
        // OBJECT
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        // PLAYER
        player.draw(g2);

        g2.dispose();
    }

    public void playMusic (int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();

    }

    public void stopMusic () {
        sound.stop();
    }

    public void playSE (int i) {
        sound.setFile(i);
        sound.play();
    }
}