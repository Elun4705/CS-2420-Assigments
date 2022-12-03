package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RandomPhraseGenerator<E> {

	private static String StartPoint = null;
	private static HashMap<String, ArrayList<String>> groups = new HashMap<String, ArrayList<String>>();
	private static int currCount = 1;
	private static boolean open = false;

	public static void main(String[] args) throws FileNotFoundException {
//		String grammer = args[0];
//		Integer count = Integer.valueOf(args[1]);

// cd Documents\GitHub\CS-2420-Assigments\Assign\src
// java comprehensive/RandomPhraseGenerator
// C:/Users/Emoon/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// java comprehensive/RandomPhraseGenerator
// C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// cd Users\EMoon\Documents\GitHub\CS-2420-Assigments\Assign\src

		scanFile("C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g");
	}

	private static void scanFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(new FileReader(file));

		
		// From: Andy, To: Emmanuel
		// Please don't touch this, I worked hard on it.  It's three in the morning as I'm typing this.
		// For easier access, I changed our HashMap to a HashMap of ArrayLists.  Why this is important will be shown
		// soon.
		// Basically, what this will do is when it finds an open bracket, it sets the next line as "cat" (short for
		// category.)  It will then set the life after cat to "check."  "Cat" will become the Key in our HashMap.
		// Then it runs a while loop, adding each example of the category to the ArrayList at the appropriate key.
		// The examples are kept track of by "check," which is updated through every iteration of the while loop, and
		// will continue to do so as long as "check" doesn't become the closed bracket.  Once check finds a closed
		// bracket, it will go back out to the original while loop, which looks for more open brackets.
		while (scan.hasNextLine()) {
			if (scan.nextLine().compareTo("{") == 0) {
				String cat = scan.nextLine();
				cat = cat.substring(1, cat.length() - 1);
				String check = scan.nextLine();
				while (check.compareTo("}") != 0) {
					if(groups.containsKey(cat) == false) {
						ArrayList<String> arr = new ArrayList<String>();
						arr.add(check);
						groups.put(cat, arr);
					} else {
						groups.get(cat).add(check);
					}
					check = scan.nextLine();
				}
			}
		}

		// This is what I used to check out the inside of my HashMap.
		System.out.println(Arrays.asList(groups));

	}

}
