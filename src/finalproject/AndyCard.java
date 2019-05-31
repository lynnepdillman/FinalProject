package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class AndyCard extends Square{
    private Image image;
    private DmCard back;
	
    public AndyCard(){
        this(0,0);
    }

    public AndyCard(int x, int y){
        super(x, y);
        back = new DmCard(x, y);
        try{
            image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\FinalProject\\src\\finalproject\\andy.jpg"));
        }
        catch(Exception e){
            System.out.println("AndyCard: error");
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
