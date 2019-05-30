package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class DmCard extends Square{
    private Image image;
    private DmCard back;
	
    public DmCard(){
        this(0,0);
    }

    public DmCard(int x, int y){
        super(x, y);
        try{
            image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\MatchingGame\\src\\Matchingame\\dm.JPG"));
        }
        catch(Exception e){
            System.out.println("DmCard: error");
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