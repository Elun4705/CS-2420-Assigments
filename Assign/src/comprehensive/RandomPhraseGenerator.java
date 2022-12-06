package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RandomPhraseGenerator<E> {

	private static String StartPoint = null;
	private static HashMap<String, ArrayList<String>> groups = new HashMap<String, ArrayList<String>>();
	private static int currCount = 1;
	private static boolean open = false;

	public static void main(String[] args) throws FileNotFoundException {
//		String grammer = args[0];
		Integer count = 5;

// cd Documents\GitHub\CS-2420-Assigments\Assign\src
// java comprehensive/RandomPhraseGenerator
// C:/Users/Emoon/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// java comprehensive/RandomPhraseGenerator
// C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// cd Users\EMoon\Documents\GitHub\CS-2420-Assigments\Assign\src

		scanFile("C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/assignment_extension_request.g");
		for (int i = 0; i < count; i++) {extractStart();}
	}

	private static void scanFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(new FileReader(file));

		// From: Andy, To: Emmanuel
		// Please don't touch this, I worked hard on it. It's three in the morning as
		// I'm typing this.
		// For easier access, I changed our HashMap to a HashMap of ArrayLists. Why this
		// is important will be shown
		// soon.
		// Basically, what this will do is when it finds an open bracket, it sets the
		// next line as "cat" (short for
		// category.) It will then set the life after cat to "check." "Cat" will become
		// the Key in our HashMap.
		// Then it runs a while loop, adding each example of the category to the
		// ArrayList at the appropriate key.
		// The examples are kept track of by "check," which is updated through every
		// iteration of the while loop, and
		// will continue to do so as long as "check" doesn't become the closed bracket.
		// Once check finds a closed
		// bracket, it will go back out to the original while loop, which looks for more
		// open brackets.
		while (scan.hasNextLine()) {
			if (scan.nextLine().compareTo("{") == 0) {
				String cat = scan.nextLine();
				String check = scan.nextLine();
				while (check.compareTo("}") != 0) {
					if (groups.containsKey(cat) == false) {
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
		
		for (String key : groups.keySet()) {
			System.out.println(key);
		}

		// This is what I used to check out the inside of my HashMap.

	}

	private static void extractStart() {
		String result = "";
		ArrayList<String> pattern = groups.get("<start>");
		for (String item : pattern) {
			String[] innerPattern = item.split(" ");

			String lastWord = innerPattern[innerPattern.length - 1];
			lastWord = lastWord.substring(0, lastWord.length() - 1);
			innerPattern[innerPattern.length - 1] = lastWord;

			for (String word : innerPattern) {
				if (groups.containsKey(word)) {
					String[] wordSplit = word.split(" ");
					String terminal = findTerminal(wordSplit);
					result += "" + terminal;
				} else {
					result += " " + word;
				}
			}
		}
		result = result.substring(1);
		result += ".";
		System.out.println(result);

	}

	private static String getRandom(ArrayList<String> arr) {
		Random rand = new Random();
		int index = rand.nextInt(arr.size() * 100) % arr.size();

		return arr.get(index);
	}
	
	private static String findTerminal(String[] ladder) {
		String returnWord = "";
		for (String word : ladder) {
			if (groups.containsKey((word))) {
				String randomWord = getRandom(groups.get(word));
				returnWord += findTerminal(randomWord.split(" "));
			} else {
				String shortenedWord = word.substring(0, word.length()-1);
				if (groups.containsKey(shortenedWord)) {
					returnWord += findTerminal(shortenedWord.split(" ")) + (word.substring(word.length()-1));
				} else {
					returnWord += " " + word;
				}
			}	
		}
		
		return returnWord;
	}

}
