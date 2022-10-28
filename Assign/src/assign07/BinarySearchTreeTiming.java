package assign07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

import assign06.ArrayStack;
import assign06.Stack;

public class BinarySearchTreeTiming {
	
	private static Random rand;
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		// Time adding N values to different kinds of queues
		for(int N = 1000; N <= 15000; N += 1000)
		{
			// Generate random input before starting the timer
			ArrayList<Integer> testValues = new ArrayList<Integer>();

			for(int i=0; i < N; i++) {
				testValues.add(i);
			}
			
			Collections.shuffle(testValues);
			
			timeTest2(N, testValues);
			
			
		}


		

	}

	private static void timeTest1(int N)
	{
		long startTimeUB, midpointTimeUB, stopTimeUB, startTimeB, midpointTimeB, stopTimeB;
		int timesToLoop = 5000;

		// Generate random input before starting the timer
		ArrayList<Integer> testInOrder = new ArrayList<Integer>();
		ArrayList<Integer> testShuffled = new ArrayList<Integer>();

		for(int i=0; i < N; i++) {
			testInOrder.add(i);
			testShuffled.add(i);
		}
		
		Collections.shuffle(testShuffled);
		
		BinarySearchTree<Integer> treeUnbalanced = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> treeShuffled = new BinarySearchTree<Integer>();

		treeUnbalanced.addAll(testInOrder);
		treeShuffled.addAll(testShuffled);
		
		startTimeUB = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			treeUnbalanced.containsAll(testInOrder);
			// treeShuffled.containsAll(testInOrder);
		}

		midpointTimeUB = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			// nothing
		}

		stopTimeUB = System.nanoTime();

		startTimeB = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			
			treeShuffled.containsAll(testInOrder);
		}

		midpointTimeB = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			// nothing
		}

		stopTimeB = System.nanoTime();
		
		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTimeUB = ((midpointTimeUB - startTimeUB) - (stopTimeUB - midpointTimeUB)) / timesToLoop;
		double averageTimeB = ((midpointTimeB - startTimeB) - (stopTimeB - midpointTimeB)) / timesToLoop;

		System.out.println(N + "\t"+ averageTimeUB + "\t" + averageTimeB);
	}
	
	private static void timeTest2(int N, ArrayList<Integer> test)
	{
		long startTimeUB, midpointTimeUB, stopTimeUB, startTimeB, midpointTimeB, stopTimeB;
		long startTimeUBC, midpointTimeUBC, stopTimeUBC, startTimeBC, midpointTimeBC, stopTimeBC;
		int timesToLoop = 5000;
		
		BinarySearchTree<Integer> treeUnbalanced = new BinarySearchTree<Integer>();
		TreeSet<Integer> treeShuffled = new TreeSet<Integer>();
		
		startTimeUB = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			treeUnbalanced.addAll(test);
		}

		midpointTimeUB = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			//nothing
		}

		stopTimeUB = System.nanoTime();
		
		startTimeB = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			
			treeShuffled.addAll(test);
		}

		midpointTimeB = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			//nothing
		}

		stopTimeB = System.nanoTime();
		
		startTimeUBC = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			treeUnbalanced.containsAll(test);
		}

		midpointTimeUBC = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			//nothing
		}

		stopTimeUBC = System.nanoTime();
		
		startTimeBC = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			treeShuffled.containsAll(test);
		}

		midpointTimeBC = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			//nothing
		}

		stopTimeBC = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTimeUB = ((midpointTimeUB - startTimeUB) - (stopTimeUB - midpointTimeUB)) / timesToLoop;
		double averageTimeB = ((midpointTimeB - startTimeB) - (stopTimeB - midpointTimeB)) / timesToLoop;
		double averageTimeUBC = ((midpointTimeUBC - startTimeUBC) - (stopTimeUBC - midpointTimeUBC)) / timesToLoop;
		double averageTimeBC = ((midpointTimeBC - startTimeBC) - (stopTimeBC - midpointTimeBC)) / timesToLoop;

		
		System.out.println(N + "\t"+ averageTimeUB + "\t" + averageTimeB + "\t" + averageTimeUBC + "\t" + averageTimeBC);
	}
	
}
