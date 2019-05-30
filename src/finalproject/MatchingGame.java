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

//possible new matching game method
                
//		int ans1, ans2; 
//		boolean ans = false; 
//	
//		Scanner keyboard = new Scanner(System.in);
//		   
//		System.out.println("Type the smaller number of your match: ");
//		ans1 = keyboard.nextInt(); 
//		System.out.println("Type the second square of your match: ");
//		ans2 = keyboard.nextInt();
//		
//		if (ans1 == 1 && ans2 == 14) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 2 && ans2 == 11) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 3 && ans2 == 9) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 4 && ans2 == 13) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 5 && ans2 == 8) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 6 && ans2 == 16) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 7 && ans2 == 12) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if (ans1 == 10 && ans2 == 15) {
//			System.out.println("Correct!");
//			ans = true; 
//		}
//		if ((ans1 != 1 && ans2 != 14) && (ans1 != 2 && ans2 != 11) && (ans1 != 3 && ans2 != 9)
//			&& (ans1 != 4 && ans2 != 13) && (ans1 != 5 && ans2 != 8) && (ans1 != 6 && ans2 != 16)
//			&& (ans1 != 10 && ans2 != 15)) {
//			System.out.println("Try again");
//		}
//
//		
	}
}
