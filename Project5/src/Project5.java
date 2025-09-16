import java.util.Scanner;
public class Project5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Response Dial Simulator");
		System.out.println("-----------------------");
		
		System.out.println("Initial setting: 3");
		
		final int SENTINEL = -1;
		int data = 3;
		int newData;
		int positiveChange = 0;
		int negativeChange = 0;
		int noChange = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		
		while (data != SENTINEL) {
			System.out.println("Enter the next setting (1-5) or -1 to stop.");
			newData = input.nextInt();
			if (newData > data) {
				System.out.println("Positive change: " + data + " to " + newData);
				System.out.println("Current setting: " + newData);
				positiveChange += 1;
				
			} else if (newData < data && newData != -1) {
				System.out.println("Negative change: " + data + " to " + newData);
				System.out.println("Current setting: " + newData);
				negativeChange += 1;
				
			} else if (newData == data) {
				System.out.println("No change: " + data + " to " + newData);
				System.out.println("Current setting: " + newData);
				noChange += 1;
				
			}
			if (newData == 1) {
				num1 = num1 + 1;
			} else if (data == 2) {
				num2 = num2 + 1;
			} else if (data == 3) {
				num3 = num3 + 1;
			} else if (data == 4) { 
				num4 = num4 + 1;
			} else if (data == 5) {
				num5 = num5 + 1;
			}
			data = newData;
		}
		
		num3 = num3 -1;
		num2 = num2 + 1;
		
		System.out.println();
		System.out.println("Response Summary");
		System.out.println("----------------");
		System.out.println("1 was chosen " + num1 + " time(s).");
		System.out.println("2 was chosen " + num2 + " time(s).");
		System.out.println("3 was chosen " + num3 + " time(s).");
		System.out.println("4 was chosen " + num4 + " time(s).");
		System.out.println("5 was chosen " + num5 + " time(s).");
		System.out.println();
		System.out.println("Positive changes: " + positiveChange);
		System.out.println("Negative changes: " + negativeChange);
		System.out.println("No changes: " + noChange);
		
		input.close();
	}
}
