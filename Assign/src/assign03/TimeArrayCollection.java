package assign03;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TimeArrayCollection {
	
	private static Random rand;
	
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		ArrayCollection<Integer> testArray = new ArrayCollection<Integer>();
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		IntegerComparator intcmp = new IntegerComparator();
		int timesToLoop = 1000000;
		sortedArray = testArray.toSortedList(intcmp);
		

		
		// For each problem size n . . .
		for (int n = 1000; n <= 20000; n += 1000) {
			
			while (testArray.size() < n) {
				testArray.add(randomInt());
			}
			
			long startTime, midpointTime, stopTime, DebugTime;
			
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			DebugTime = System.currentTimeMillis();
			
			while (System.currentTimeMillis() - DebugTime < 5000) { 
				// empty block
			}
			
			// Now, run the test.
			startTime = System.currentTimeMillis();
			
			for (int i = 0; i < timesToLoop; i++) {
				testArray.contains(randomInt());
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

	

	public static Integer randomInt()
	{
		return rand.nextInt();
	}

}
