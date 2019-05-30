package finalproject;

import static java.lang.Character.toUpperCase;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.util.ArrayList;

public class Board extends Canvas implements Runnable, KeyListener {
	
	private DmCards pinks = new DmCards(200, 150); ;
	private DmCard[][] pinkmat; 
	public boolean initialized = false; 
	public boolean title = true; 
	public boolean match = false; 
	public boolean notMatch = false; 
	public boolean isCardFlipped = false; 
	public boolean gameStart = false;
	public int pairsleft = 8; 

	private boolean[] keys;
	private BufferedImage back;

	public Board()
	{
		setBackground(Color.WHITE);
		
		keys = new boolean[4];
		
		pinkmat = pinks.pMatrix(); 

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

   public void paint( Graphics window )
	{	   
		//set up the double buffering to make the game animation nice and smooth
 		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		
		Graphics graphToBack = back.createGraphics();
		
		if(initialized == false)

		{
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("Lynne Dillman, APCS-A p.1", 500, 300);
			graphToBack.drawString("Office-Themed Matching Game", 490, 350 );
			graphToBack.drawString("If you see a matching pair, please press Y, if not a matching pair, please press N", 360, 400);
			graphToBack.drawString("Press Space key to begin!", 500, 450);
		}
		
		if(keys[0] == true && !initialized)
		{
//			System.out.println("Space key pressed");
//			System.out.println("Canvas initialized");
			initialized = true;
			graphToBack.clearRect(0, 0, 800, 800);
			
			for (int i = 0; i < pinkmat.length; i++) {
				for (int j = 0; j < pinkmat[i].length; j++) {
					pinkmat[i][j].draw(graphToBack);
				}
			}
			
			graphToBack.drawString("Please press S key to flip two cards", 25, 50 );
		
		}
		
		if(keys[3] && !isCardFlipped)
		{
//			System.out.println("S key is pressed");
			gameStart = true;
			isCardFlipped = true;
			ArrayList<Square> twoFlipCard = pinks.rand();
			twoFlipCard.get(0).draw(graphToBack);
			twoFlipCard.get(1).draw(graphToBack);
			
			graphToBack.clearRect(0, 0, 800, 50);
			graphToBack.drawString("If two cards match, please press Y key", 25, 50 );
			graphToBack.drawString("If two cards do NOT match, please press N key", 25, 100);
		}
		
		if(keys[1] && isCardFlipped)
		{
//			System.out.println("Two cards match, Y key is pressed");
			isCardFlipped = false;
			if(!pinks.getTwoFlipCardsPair().get(0).getClass().equals(pinks.getTwoFlipCardsPair().get(1).getClass()))
			{
//				System.out.println("But they are not matching cards");
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(0, 0, 1300, 1300);
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("YOU INCORRECTLY ANSWERED! THERE WAS NOT A MATCH!", 400, 300);
				return;
			}
			else
			{
				match = true;
				int xPos1 = pinks.getTwoFlipCardsPair().get(0).getxPos();
				int yPos1 = pinks.getTwoFlipCardsPair().get(0).getyPos();
				graphToBack.clearRect(xPos1, yPos1, 150, 150);
				
				int xPos2 = pinks.getTwoFlipCardsPair().get(1).getxPos();
				int yPos2 = pinks.getTwoFlipCardsPair().get(1).getyPos();
				graphToBack.clearRect(xPos2, yPos2, 150, 150);
				
				pairsleft = pairsleft - 1; 
//				System.out.println(pairsleft);
				pinks.addMatch();
				
				graphToBack.clearRect(0, 0, 800, 50);
				graphToBack.drawString("Please press S key to flip another two cards", 25, 50);
				
			}
			
		}
		
		if(keys[2] && isCardFlipped)
		{
//			System.out.println("Two cards doesn't match, N key is pressed");
			isCardFlipped = false;
			if(pinks.getTwoFlipCardsPair().get(0).getClass().equals(pinks.getTwoFlipCardsPair().get(1).getClass()))
			{
//				System.out.println("But they are matching cards");
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(0, 0, 1300, 1300);
				graphToBack.setColor(Color.BLACK);
				graphToBack.drawString("YOU INCORRECTLY ANSWERED. THERE WAS A MATCH!", 400, 300);
				return;
			}
			else
			{
				match = false;
				pinks.getTwoFlipCardsPair().get(0).drawBack(graphToBack);
				pinks.getTwoFlipCardsPair().get(1).drawBack(graphToBack);
				
				graphToBack.clearRect(0, 0, 800, 100);
				graphToBack.drawString("Please press S key to flip another two cards", 25, 50);
				
				
			}
		}
		
		if (pairsleft == 0) {
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(0, 0, 1300, 1300);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("YOU WIN!", 400, 300);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
   
   
   public void keyPressed(KeyEvent e)
   {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[0] = true;
		}
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'Y' : keys[1]=true; break;
			case 'N' : keys[2]=true; break;
			case 'S' : keys[3]=true; break;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[0] = false;
		}
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'Y' : keys[1]=false; break;
			case 'N' : keys[2]=false; break;
			case 'S' : keys[3]=false; break; 
			
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
	}
 
	public void run()
	{
		try
		{
	   		while(true)
	   		{
	   			Thread.currentThread().sleep(5);
//	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	} 
   
	}
