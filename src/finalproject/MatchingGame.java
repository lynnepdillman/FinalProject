package finalproject;
import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;

public class MatchingGame extends JFrame
{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 1300;

	public MatchingGame()
	{
		super("MATCHING GAME");
		setSize(WIDTH,HEIGHT);

		Board theGame = new Board();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		MatchingGame run = new MatchingGame();
}
}
