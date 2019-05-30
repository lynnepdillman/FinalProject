package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class AngelaCard extends Square{
    private Image image;
    private DmCard back;
	
    public AngelaCard(){
        this(0,0);
    }

    public AngelaCard(int x, int y){
        super(x, y);
        back = new DmCard(x, y);
        try{
            image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\MatchingGame\\src\\Matchingame\\angela.JPG"));
        }
        catch(Exception e){
            System.out.println("AngelaCard: error");
        }
    }

    public void draw( Graphics window ){
        window.drawImage(image,getxPos(),getyPos(),130,130,null);
    }
	
    public void drawBack(Graphics window){
        back.draw(window);
    }

    public String toString(){
        return super.toString();
    }
}
