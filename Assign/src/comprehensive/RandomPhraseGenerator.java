package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Emmanuel Luna and Andy Huo
 * 
 *         A random phrase generator class which takes an input grammer file,
 *         scans it for production rules,terminal, and non- terminal objects,
 *         then returns a random phrase based off of those rules. Uses a HashMap
 *         filled with ArrayList objects corresponding to the given
 *         non-terminal.
 *
 */
public class RandomPhraseGenerator {

	private static HashMap<String, ArrayList<String>> groups = new HashMap<String, ArrayList<String>>();
	private static String pattern;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		String grammer = args[0];
//		setCount(Integer.valueOf(args[1]));

// cd Documents\GitHub\CS-2420-Assigments\Assign\src
// java comprehensive/RandomPhraseGenerator
// C:/Users/Emoon/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// java comprehensive/RandomPhraseGenerator
// C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// cd Users\EMoon\Documents\GitHub\CS-2420-Assigments\Assign\src

		scanFile(grammer);

		pattern = groups.get("<start>").get(0);
		Start();
	}

	public static void setCount(int newCount) {
		count = newCount;
	}

	/**
	 * A method which scans a given grammer file and sorts everything within into a
	 * HashTable object, sorted by non-terminals and terminals.
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
	 * A method which essentially serves as a starting point, by scanning the items
	 * in the grammer pattern and inserting the string objects as needed. If a
	 * recursive pattern is found (in which a non-terminal is contained in a
	 * non-terminal answer,) then the recursive findTerminal method is called to
	 * resolve the matter.
	 * @throws IOException 
	 */
	private static void Start() throws IOException {
		String result = "";
		
		result = findTerminal(pattern);

		System.out.println(result);

	}

	/**
	 * A method which finds a random integer within the bounds of the given
	 * ArrayList size and returns the String object found at that index.
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
	 * A recursive method which resolves any situation in which a chosen example of
	 * a non-terminal contains another non-terminal, then returns the result. It
	 * does so by navigating an input String array with all values and splitting the
	 * Strings inside into more arrays for analysis.
	 * 
	 * @param ladder - The given String array to start analyzing.
	 * @return The resulting String pattern
	 * @throws IOException 
	 */
	private static String findTerminal(String start) throws IOException {
		String returnWord = "";
		String nonTerminal = "";
		
		StringReader sr = new StringReader(start);
		BufferedReader br = new BufferedReader(sr);
		
		int i;
		while ((i = br.read()) != -1) {
			if ((char) i == '<') {
				nonTerminal = "";
				nonTerminal += "<";
				int j;
				while ((j = br.read()) != 62) {
					nonTerminal += (char)j;
				}
				nonTerminal += ">";
				
				returnWord += findTerminal(getRandom(groups.get(nonTerminal)));
			} else {
				returnWord += (char)i;
			}
		}
		br.close();
		sr.close();
		
		return returnWord;
		
//		for (String word : ladder) {
//			if (groups.containsKey((word))) {
//				String randomWord = getRandom(groups.get(word));
//				returnWord += findTerminal(randomWord.split(" "));
//			} else {
//				String shortenedWord = word.substring(0, word.length() - 1);
//				if (groups.containsKey(shortenedWord)) {
//					returnWord += findTerminal(shortenedWord.split(" ")) + (word.substring(word.length() - 1));
//				} else {
//					returnWord += " " + word;
//				}
//			}
//		}
	}

}
