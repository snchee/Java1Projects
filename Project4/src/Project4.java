import java.util.Scanner;
public class Project4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		
		String data = "";
		System.out.println("Answer yes or no to the following questions");
		System.out.println("I am losing my sense of humor.");
		data = input.nextLine();
		
		if (data.equals("Yes") || data.equals("YES") || data.equals("yes") || data.equals("yeS") || data.equals("YEs")) {
			sum = sum + 1;
		}
		else {
			sum = sum + 0;
		}
		
		System.out.println("I find it more and more difficult to see people socially.");
		data = input.nextLine();
		
		if (data.equals("Yes") || data.equals("YES") || data.equals("yes") || data.equals("yeS") || data.equals("YEs")) {
			sum = sum + 1;
		}
		else {
			sum = sum + 0;
		}
		
		System.out.println("I feel tired most of the time.");
		data = input.nextLine();
		
		if (data.equals("Yes") || data.equals("YES") || data.equals("yes") || data.equals("yeS") || data.equals("YEs")) {
			sum = sum + 1;
		}
		else {
			sum = sum + 0;
		}
		
		
		if (sum == 3) {
			System.out.println("You are probably stressed out");
		}
		else if (sum == 2) {
			System.out.println("You are possibly stressed out");
		}
		else if (sum == 1) {
			System.out.println("You are beginning to stress out");
		}
		else {
			System.out.println("You are more exhausted than stressed out");
		}
		
		input.close();
	}
}

