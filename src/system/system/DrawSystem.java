package system.system;

import system.SuperSystem;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import components.SuperComponent;
import components.system.DrawComponent;

import main.World;

public class DrawSystem implements SuperSystem {
    private static ArrayList<DrawComponent> drawComponents = new ArrayList<>();
    private World world;
    private Graphics2D g2;

    public DrawSystem (World world, Graphics2D g2) {
        this.world = world;
        this.g2 = g2;
    }

    public void registration (SuperComponent superComponents) {
        DrawComponent drawComponent = (DrawComponent) superComponents;
        this.drawComponents.add(drawComponent);
    }

    public void registerToWorld () {
        world.registration(this);
    }

    public void updateAllComponent () {
        for (int i = 0; i < this.drawComponents.size(); i++) {
            DrawComponent dComponent = drawComponents.get(i);
            this.draw(dComponent);
        }
    }
    
    private void draw (DrawComponent dComponent) {
        BufferedImage image = dComponent.image;
        int screenX = dComponent.screenX;
        int screenY = dComponent.screenY;
        int width = dComponent.width;
        int height = dComponent.height;

        g2.drawImage(image, screenX, screenY, width, height, null);
    }
}
