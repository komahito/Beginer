package main;

import entity.Player;
import object.OBJ_Key;
import object.ObjectMap;
import object.SuperObject;
import state.State;
import state.StateManager;
import tile.TileManager;
import tile.Map;

import javax.swing.JPanel;

import action.Action;
import actor.Actor;
import display.Display;
import drawer.Drawer;

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
    public int maxWorldCol = 50;
    public int maxWorldRow = 50; // defined by tileM
    // public TileManager tileM = new TileManager(this); // handle mapTileNum[row][col]
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    public Map map = new Map(this, "world01");
    public ObjectMap objectMap = new ObjectMap(this);
    public KeyHandler keyH = new KeyHandler(this);
    public StateManager stateM = new StateManager(this);
    Thread gameThread;
    // public CollisionChecker cChecker = new CollisionChecker(this);
    // public AssetSetter aSetter = new AssetSetter(this);
    // public int currentMapNum = 0;
    // public Map currentMap = aSetter.maps[currentMapNum];
    //public Map map = new Map(this, "world01");
    //public ArrayList<SuperObject> objs = new ArrayList<>();
    //public UI ui = new UI(this);
    //public ChangeWorld cWorld = new ChangeWorld(this);

    //TMP ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public OBJ_Key tstKey = new OBJ_Key(this);

    // STATE
    public boolean gameFinished = false;
    public boolean inventoryState = false;
    public boolean playerState = true;
    public boolean chestState = false;

    // TEMP
    public ArrayList<Actor> actors = new ArrayList<>();
    public ArrayList<Drawer> drawers = new ArrayList<>(); 

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        //TEMP INI
        this.actors.add(this.player.actor);
        
        this.drawers.add(this.map.drawer);
        this.drawers.add(this.tstKey.drawer);
        this.drawers.add(this.player.drawer);

        this.objectMap.add(this.tstKey, 23, 9);
    }

    public void setUpGame() {
        //aSetter.setObject();
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
                    gameThread = null;
                }

                delta--;
            }
        }
    }

    public void update() {
        State currentState = this.stateM.takeTurn();
        if (currentState != null) currentState.run();
        else System.err.println("currenState is null! (*''*)");
        // cWorld.changeMap();
        // player.update();

    }
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < this.drawers.size(); i++) {
            Drawer drawer = this.drawers.get(i);
            Display display = drawer.takeTurn();
            if (display != null) {
                display.draw(g2);
            }
        }

        // // TILE
        // currentMap.draw(g2);
        
        // // OBJECT
        // for (int i = 0; i < objs.size(); i++) {
        //     objs.get(i).draw(g2, this);
        // }

        // // PLAYER
        // player.draw(g2);

        // // UI
        // ui.draw(g2);

        g2.dispose();
    }

}
