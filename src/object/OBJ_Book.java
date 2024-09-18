package object;

import entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;

public class OBJ_Book extends SuperObject {
    public OBJ_Book (GamePanel gp) {
        this.gp = gp;
        name = "Book";
        try {
            image = ImageIO.read(new File(main.Property.res + "/objects/book_blue.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void pickedUp (Player player) {
        disappear = true;
        if (!player.addObject(this)) {
            disappear = false;
        } else {
            gp.ui.showMessage("You got a book!");
        }
    }
}