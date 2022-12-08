package comprehensive;

import java.io.IOException;

public class RPGtimer {

	public static int timesToLoop = 500;
	public static RandomPhraseGenerator rpg = new RandomPhraseGenerator();

	public static void main(String[] args) throws IOException {

//		for (int N = 1000; N <= 20000; N += 1000) {
//
//			testNumberOfPhrases(N);
//
//		}

		testNumberOfProductionRules();
		
	}

	public static void testNumberOfPhrases(int N) throws IOException {

		long debugTime, startTime, midTime, endTime;

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		debugTime = System.nanoTime();
		while (System.nanoTime() - debugTime < 1000000000) { // empty block
		}
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < timesToLoop; i++) {
			rpg.Test(N);
		}
		
		midTime = System.currentTimeMillis();
		
		for (int i = 0; i < timesToLoop; i++) {
			// HeaderSpace
		}

		endTime = System.currentTimeMillis();
		
		long averageTime = ((midTime - startTime) - (endTime - midTime)) / timesToLoop;

		System.out.println(N + " " + averageTime);
		
	}
	
	public static void testNumberOfProductionRules() throws IOException {
		
		long debugTime, startTime, midTime, endTime;

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		debugTime = System.nanoTime();
		while (System.nanoTime() - debugTime < 1000000000) { // empty block
		}
		
		startTime = System.nanoTime();
		
		for (int i = 0; i < timesToLoop; i++) {
			rpg.Test(1000);
		}
		
		midTime = System.nanoTime();
		
		for (int i = 0; i < timesToLoop; i++) {
			// HeaderSpace
		}

		endTime = System.nanoTime();
		
		long averageTime = ((midTime - startTime) - (endTime - midTime)) / timesToLoop;

		System.out.println(averageTime);
	}

}
