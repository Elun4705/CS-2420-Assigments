package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class RandomPhraseGenerator<E> {
	
	HashMap<E,E> map = new HashMap<E,E>();

	public static void main(String[] args) throws FileNotFoundException {
//		String grammer = args[0];
//		Integer count = Integer.valueOf(args[1]);
		
		scanFile("C:/Users/u1050952/Documents/GitHub/CS-2420-Assigments/Assign/src/comprehensive/poetic_sentence.g");
//		System.out.println(count);
	}
	
	private static void scanFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scan = new Scanner(new FileReader(file));
		while(scan.hasNextLine()) {
			if (scan.nextLine().contains("{")) {
				System.out.println("Found!");
			}
			scan.nextLine();
		}
	}
	
}
