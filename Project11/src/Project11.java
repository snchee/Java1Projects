// James Dizikes
// CS 1323/1324, Fall 2019
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Project11 {

	public static void main(String[] args)
		throws FileNotFoundException, IOException {

		final String FILENAME_COMMON = "common-dictionary.txt";
		final String FILENAME_PERSONAL = "personal-dictionary.txt";
		final int CAPACITY_PERSONAL_DICT = 100;
		String prompt = "Enter a word or 'quit' to stop: ";

		// Read the common dictionary and store the words in an array.
		List<String> common = readFile(FILENAME_COMMON);

		// Construct an oversize array to store the personal dictionary.
		List<String> personal = new ArrayList<>();

		// Read the personal dictionary, creating the file if it doesn't 
		// exist. Store the words in an oversize array.
		readFile(FILENAME_PERSONAL, personal);
		
		// Construct a Scanner to read user input from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Spell Checker");
		System.out.println("-------------");
		
		// Perform a priming read to get the first word.
		System.out.print(prompt);
		String word = keyboard.nextLine().toLowerCase();
		
		// Enter the user input loop.
		while (!word.equals("quit")) {
			
			// Check if the word is in either dictionary.
			if (checkSpelling(word, common, personal)) {
				System.out.println("The word is spelled correctly.");
			} 
			else {
				System.out.println("The word was not found in the dictionary.");			
				System.out.println("Would you like to add it to your personal dictionary (yes/no)?");
				String response = keyboard.nextLine().toLowerCase();
				
				// If the user responds "yes" and there is room in the oversize
				// array, add the word to the end of the array and sort it.
				if (response.equals("yes") && personal.size() < CAPACITY_PERSONAL_DICT) {
					personal.add(word);
					personal.sort(String :: compareTo);
				}
			}
			
			// Get the next word from the user.
			System.out.println();
			System.out.print(prompt);
			word = keyboard.nextLine().toLowerCase();
		}
		
		keyboard.close();
		writeFile(FILENAME_PERSONAL, personal);
		System.out.println("Goodbye!");
	}
	
	// Read each line of a file and store them in a perfect size array.
	public static ArrayList<String> readFile(String filename) 
		throws FileNotFoundException {
			
		ArrayList<String> lines = new ArrayList<>();
		
		try (Scanner file = new Scanner(new File(filename))) {
			while (file.hasNextLine()) {
				lines.add(file.nextLine());
			}
		}
		return lines;
	}
	// Read each line of a file and store them in an oversize array. If the 
	// file does not exist, create an empty file with the given name.
	public static void readFile(String filename, List<String> list) 
		throws FileNotFoundException, IOException {
		
		File file = new File(filename);
		file.createNewFile();
		
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				list.add(fileScanner.nextLine());
			}
		}
	}
		

	// Return true if word is in either array; otherwise, return false. Note 
	// that the arrays are sorted, so binary search can be used.
	public static boolean checkSpelling(String word, List<String> common, 
		List<String> personal) {
		
		return common.contains(word) || personal.contains(word);
	}
			
	
	// Write the nonempty elements of an oversize array to a given file.
	public static void writeFile(String filename, List<String> list) throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(filename)) {
			for (String word : list) {
				writer.println(word);
			}
		}
	}
}
		
