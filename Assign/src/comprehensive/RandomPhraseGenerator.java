package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Emmanuel Luna and Andy Huo
 * 
 * A random phrase generator class which takes an input grammer file, scans it for
 * production rules,terminal, and non- terminal objects, then returns a random phrase 
 * based off of those rules.  Uses a HashMap filled with ArrayList objects corresponding
 * to the given non-terminal.
 *
 */
public class RandomPhraseGenerator {

	private static HashMap<String, ArrayList<String>> groups = new HashMap<String, ArrayList<String>>();
	private static ArrayList<String> pattern;
	private static String[] startPattern;

	public static void main(String[] args) throws FileNotFoundException {
		String grammer = args[0];
		Integer count = Integer.valueOf(args[1]);

// cd Documents\GitHub\CS-2420-Assigments\Assign\src
// java comprehensive/RandomPhraseGenerator
// C:/Users/Emoon/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// java comprehensive/RandomPhraseGenerator
// C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// cd Users\EMoon\Documents\GitHub\CS-2420-Assigments\Assign\src

		scanFile(grammer);
		pattern = groups.get("<start>");
		startPattern = pattern.get(0).split(" ");
		for (int i = 0; i < 5; i++) {Start();}
	}

	/**
	 * A method which scans a given grammer file and sorts everything within
	 * into a HashTable object, sorted by non-terminals and terminals.
	 * 
	 * @param fileName - Input Grammer file with very strict formatting rules
	 * @throws FileNotFoundException
	 */
	private static void scanFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(new FileReader(file));

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
	}

	/**
	 * A method which essentially serves as a starting point, by scanning the items in
	 * the grammer pattern and inserting the string objects as needed.  If a recursive
	 * pattern is found (in which a non-terminal is contained in a non-terminal answer,)
	 * then the recursive findTerminal method is called to resolve the matter.
	 */
	private static void Start() {
		String result = "";

		for (String word : startPattern) {
			result += "" + findTerminal(word.split(" "));
		}
		
		result = result.substring(1);
		System.out.println(result);

	}

	/**
	 * A method which finds a random integer within the bounds of the given ArrayList size and 
	 * returns the String object found at that index.
	 * 
	 * @param arr - The input ArrayList
	 * @return The String found at that index
	 */
	private static String getRandom(ArrayList<String> arr) {
		Random rand = new Random();
		int index = rand.nextInt(arr.size() * 100) % arr.size();

		return arr.get(index);
	}
	
	/**
	 * A recursive method which resolves any situation in which a chosen example of a
	 * non-terminal contains another non-terminal, then returns the result.  It does so
	 * by navigating an input String array with all values and splitting the Strings inside
	 * into more arrays for analysis.
	 * 
	 * @param ladder - The given String array to start analyzing.
	 * @return The resulting String pattern
	 */
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
