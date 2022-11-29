package assign10;

import java.util.ArrayList;
import java.util.Random;

import assign09.HashTable;
import assign09.StudentGoodHash;

public class PQTester {

	public static int timesToLoop = 5000;
	public static Random rand = new Random();

	public static void main(String[] args) {

		for (int N = 1000; N <= 20000; N += 1000) {
			ArrayList<Integer> arrTest = new ArrayList<Integer>();

			for (int j = 0; j < N; j++) {
				arrTest.add(rand.nextInt());
			}			

			testCode(N, arrTest);
		}

	}

	public static void testCode(int N, ArrayList<Integer> items) {

		long start, middle, end;

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		start = System.nanoTime();
		
		for (int i = 0; i < timesToLoop; i++) {	
			BinaryMaxHeap<Integer> bmh = new BinaryMaxHeap<Integer>(items);
			for (int j = 0; j < N; j++) {			
				bmh.extractMax();
			}
		}

		middle = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {	
			BinaryMaxHeap<Integer> bmh = new BinaryMaxHeap<Integer>(items);
			for (int j = 0; j < N; j++) {			
				//nothing
			}
		}

		end = System.nanoTime();

		long averageTime = ((middle - start) - (end - middle)) /timesToLoop;

		System.out.println(N + " " + averageTime);

	}

}
