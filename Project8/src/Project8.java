import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Project8 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        final String FILENAME_COMMON = "common-dictionary.txt";
        final String FILENAME_PERSONAL = "personal-dictionary.txt";
        final int CAPACITY_PERSONAL_DICT = 100;
        String prompt = "Enter a word or 'quit' to stop: ";

        // Read the common dictionary and store the words in an array.
        String[] commonDictionary = readFilePerfect(FILENAME_COMMON);

        // Construct an oversize array to store the personal dictionary.
        String[] personalDictionary = new String[CAPACITY_PERSONAL_DICT];

        // Read the personal dictionary, creating the file if it doesn't
        // exist. Store the words in an oversize array.
        int sizePersonalDict = readFileOversize(FILENAME_PERSONAL, personalDictionary);

        // Construct a Scanner to read user input from the keyboard.
        Scanner scanner = new Scanner(System.in);

        // Perform a priming read to get the first word.
        System.out.print(prompt);
        String word = scanner.nextLine();

        // Enter the user input loop.
        while (!word.equals("quit")) {

            // Check if the word is in either dictionary.
            if (!checkSpelling(word, commonDictionary, personalDictionary, sizePersonalDict)) {

                // If the user responds "yes" and there is room in the oversize
                // array, add the word to the end of the array and sort it.
                if (sizePersonalDict < personalDictionary.length) {
                    System.out.println("The word was not found in the dictionary.");
                    System.out.print("Would you like to add it to your personal dictionary (yes/no)? ");
                    String response = scanner.nextLine().toLowerCase();
                    if (response.equals("yes")) {
                        personalDictionary[sizePersonalDict++] = word;
                        Arrays.sort(personalDictionary, 0, sizePersonalDict);
                        System.out.println("The word '" + word + "' has been added to your personal dictionary.");
                    }
                } else {
                    System.out.println("Your personal dictionary is full. Cannot add new word.");
                }
            } else {
                System.out.println("The word '" + word + "' is spelled correctly.");
            }

            // Get the next word from the user.
            System.out.print(prompt);
            word = scanner.nextLine();
        }

        scanner.close();

        System.out.println("Goodbye!");
        
        // Write personal dictionary back to file
        writeFile(FILENAME_PERSONAL, personalDictionary, sizePersonalDict);
    }

    public static String[] readFilePerfect(String filename) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(filename));
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        scanner.close();

        String[] array = new String[lines];
        scanner = new Scanner(new File(filename));
        for (int i = 0; i < lines; i++) {
            array[i] = scanner.nextLine();
        }
        scanner.close();
        return array;
    }

    public static int readFileOversize(String filename, String[] array) throws FileNotFoundException, IOException {

        File file = new File(filename);
        file.createNewFile();

        Scanner fileScanner = new Scanner(file);
        int i = 0;
        for(i = 0; fileScanner.hasNextLine() && i < array.length; i++) {
        	array[i] = fileScanner.nextLine();
        }
        fileScanner.close();

        return i;
    }

    public static boolean checkSpelling(String word, String[] common, String[] personal, int sizePersonal) {

        int index = Arrays.binarySearch(common, word);
        if (index >= 0) {
            return true;
        }
        index = Arrays.binarySearch(personal, 0, sizePersonal, word);
        return index >= 0;
    }

    public static void writeFile(String filename, String[] array, int size) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(filename);
        for (int i = 0; i < size; i++) {
            writer.println(array[i]);
        }
        writer.close();
    }
}

