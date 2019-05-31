package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class KellyCard extends Square
{
	private Image image;
	private DmCard back; 

	public KellyCard()
	{
		this(0,0);
	}

	public KellyCard(int x, int y)
	{
		super(x, y);
		back = new DmCard(x, y);
		try
		{
			image = ImageIO.read(new File("\\Users\\dillmanl2093\\Documents\\NetBeansProjects\\FinalProject\\src\\finalproject\\kelly.JPG"));

		}
		catch(Exception e)
		{
			System.out.println("KellyCard: we have a problem!");
		}
	}


	public void draw( Graphics window )
	{
		window.drawImage(image,getxPos(),getyPos(),130,130,null);
	}
	
	public void drawBack(Graphics window)
	{
		back.draw(window);
	}

	public String toString()
	{
		return super.toString();
	}
}
