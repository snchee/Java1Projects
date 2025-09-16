// James Dizikes and Deborah Trytten
// CS 1324 Fall 2019
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/** This program will take a file name, read in data in the file, and fine the line that occurred
 * most frequently (not considering case).
 * 
 * @author Deborah A. Trytten and 
 * @version 1.0
 *
 */
public class Project7
{
	/** Read in a file name from the user. The file should contain the names of movies, one
	 * to a line. These names will be converted to lower case, sorted, and the most common movie
	 * name found and reported to the user.
	 * 
	 * @param args There are no command line arguments.
	 * @throws FileNotFoundException If the file name the user enters is not stored in the appropriate
	 * project directory.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		// TODO Create a Scanner to allow the user to enter the file name
		Scanner keyboard = new Scanner(System.in);
		// TODO Get the file name from the user
		System.out.println("Enter a file name: ");
		String filename = keyboard.nextLine();
		// TODO Read the movies from the file and store them in an array.
		String[] listOfMovies = readFile(filename);
		// TODO Convert the movie titles to all lowercase letters.
		lowercase(listOfMovies);
		// TODO Find the most popular movie.
		String popularMovie = findMostFrequent(listOfMovies);
		// TODO Print the most popular movie.
		System.out.println("Most popular movie: " + popularMovie);
	}

	/** Read the contents of a file into an array. The size of the array will be determined by the
	 * number of lines in the file.
	 * 
	 * @param filename The name of the file that contains the data.
	 * @return An array that contains the contents of the file, one line to an array element.
	 * @throws FileNotFoundException If the given file name does not exist in the project directory.
	 */
	public static String[] readFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(filename));
		// TODO Count the number of lines in the file--remember to close it
		int size = 0;
		while (file.hasNextLine()) {
			file.nextLine();
			size++;
		}
		file.close();

		// TODO Use the number of lines to construct a perfect size array.
		String[] array = new String [size];

		// TODO Iterate through the file again, adding each line to the array.
		file = new Scanner(new File(filename));
		
		for(int i = 0; i < size; ++i) {
			array[i] = file.nextLine();
		}
		
		file.close();

		// TODO Return the lines of the file--the code below is a stub
		return array;
	}

	/** Convert each line in an array of Strings to lower case.
	 * 
	 * @param array The array to be converted. The contents of this array, but not its location in the heap
	 * will be modified by this method.
	 */
	public static void lowercase(String[] array)
	{
		// TODO Convert each title in the array to lower case--remember to save the lower case String in the array
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i].toLowerCase();
		}
	}

	/** Find the line in the array that occurs most frequently. The array contents will be modified by this method.
	 * 
	 * @param array An array that contains movie titles. This array must not have differences by case.
	 * @return The most commonly occurring line in the array.
	 */
	public static String findMostFrequent(String[] array)
	{
		// TODO Sort the array so identical items appear sequentially.
		Arrays.sort(array);
		String current = array[0];
		
		String mostPopular = "";
		// TODO Create variables that will store the title of the most popular film found so far, the number of
		// times that film has been found, the current film, and the number of times that the current film has been
		// found. These should be initialized from the first element in the array.
		int count = 1;
		int popular = 1;
		// TODO Step through the sorted array, counting the frequency of each item. If 
		// the frequency is greater than the current max, store the new max.
		// Note that index should start at 1, since the first item has been counted.
		for (int i =1; i < array.length; i++) {
			if (current.equals(array[i])) {
				++count;
				if (count > popular) {
					popular = count;
					mostPopular = array[i];
				}
			}
			else { 
				count = 1;
				current = array[i];
			}
		}
		// TODO Return the maximum number of times an item appeared
		return mostPopular; // This is a stub
	}
}