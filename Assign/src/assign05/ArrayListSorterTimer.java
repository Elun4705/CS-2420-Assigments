package assign05;

import java.util.ArrayList;

import assign05.ArrayListSorter;

public class ArrayListSorterTimer {
	public static void main(String[] args) {

		int timesToLoop = 10000;

		// For each problem size n . . .
		for (int n = 1000; n <= 20000; n += 1000) {

			ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(n);

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
				for (int j = 0; j < n; j++)
					ArrayListSorter.mergesort(unsorted);
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
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / ((double) timesToLoop);
			System.out.println(n + "\t" + averageTime);

		}
	}
}
