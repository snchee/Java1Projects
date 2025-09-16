import java.util.Scanner;
public class Project3 {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String yarnName = "";
		System.out.println("Enter the name of the yarn specified by your pattern.");
		yarnName = keyboard.nextLine();
		
		System.out.println("Enter the number of balls of " + yarnName + " that are required.");
		int numBalls = keyboard.nextInt();
		
		System.out.println("Enter the number of yards per ball of " + yarnName + ".");
		int yardsPerBall = keyboard.nextInt();
		
		String subYarnName = "";
		System.out.println("Enter the name of the substitute yarn.");
		keyboard.nextLine();
		subYarnName = keyboard.nextLine();
		
		System.out.println("Enter the number of yards per ball of " + subYarnName + ".");
		int subYardsPerBall = keyboard.nextInt();

		double subNumBalls = numBalls * yardsPerBall / subYardsPerBall;
		
		int finalSubNumBalls = (int)Math.round(subNumBalls);
		
		finalSubNumBalls = finalSubNumBalls + 1;
		
		System.out.println("You should purchase " + finalSubNumBalls + " balls of " + subYarnName + " instead of " + numBalls + " balls of " + yarnName + ".");
		keyboard.close();
	}
}
