package assign04;

import java.util.Random;

public class AnagramCheckerTimer {
private static Random rand;
	
	public static void main(String[] args)
	{
		rand = new Random();
		
		int timesToLoop = 1000;
		
		// For each problem size n . . .
		for (int n = 1000; n <= 20000; n += 1000) {
			
			String[] testArray = new String[n];
			String compareWord = randomString(5);
			
			for(int i = 0;  i < n; i++) {
				testArray[i] = randomString(5);
			}
			
			long startTime, midpointTime, stopTime, DebugTime;
			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			DebugTime = System.currentTimeMillis();
			
			while (System.currentTimeMillis() - DebugTime < 10000) { 
				// empty block
			}
			
			// Now, run the test.
			startTime = System.currentTimeMillis();
			
			for (int i = 0; i < timesToLoop; i++) {
				for(int j = 0; j < n; j++) {
					AnagramChecker.areAnagrams(compareWord, testArray[j]);
				}
			}
			
			midpointTime = System.currentTimeMillis();
			
			// Run a loop to capture the cost of running the "timesToLoop" loop
			for (int i = 0; i < timesToLoop; i++) {
				// Blank Space
			}
			
			stopTime = System.currentTimeMillis();
			
			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(n + "\t" + averageTime);

		}
	}

	

	public static String randomString(int size)
	{
		char[] charList = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String word = "";
		for(int i = 0; i < size; i++) {
			word += charList[rand.nextInt(26)];
		}
		
		return word;
	}
	
}
