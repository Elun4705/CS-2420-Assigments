package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class RandomPhraseGenerator<E> {

	HashMap<E, E> map = new HashMap<E, E>();

	public static void main(String[] args) throws FileNotFoundException {
		String grammer = args[0];
		Integer count = Integer.valueOf(args[1]);

// cd Documents\GitHub\CS-2420-Assigments\Assign\src
// java comprehensive/RandomPhraseGenerator
// C:/Users/Emoon/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// java comprehensive/RandomPhraseGenerator
// C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g 5
// cd Users\EMoon\Documents\GitHub\CS-2420-Assigments\Assign\src

		for (int i = 0; i < count; i++) {
			scanFile(grammer);
		}
	}

	private static void scanFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(new FileReader(file));

		while (scan.hasNextLine()) {
			if (scan.findInLine("<start>") != null)
				System.out.println("Found start!");
			if (scan.findInLine("<object>") != null)
				System.out.println("Found object!");
			if (scan.findInLine("<verb>") != null)
				System.out.println("Found verb!");
			if (scan.findInLine("<adverb>") != null)
				System.out.println("Found adverb!");
			scan.nextLine();
		}
		
		System.out.println();

	}

}
