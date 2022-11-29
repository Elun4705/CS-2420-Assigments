package assign10;

import java.util.ArrayList;
import java.util.Random;

public class FindKLargestTester {

	public static int timesToLoop = 5000;
	public static Random rand = new Random();
	public static int k = 10;

	public static void main(String[] args) {

		for (int N = 1000; N <= 20000; N += 1000) {
			ArrayList<Integer> arrTest = new ArrayList<Integer>();

			for (int j = 0; j < N; j++) {
				arrTest.add(rand.nextInt());
			}

			timeHeap(N, k, arrTest);
			timeSort(N, k, arrTest);
		}

	}

	public static void timeHeap(int N, int k, ArrayList<Integer> items) {

		long start, middle, end;

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		start = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
			FindKLargest.findKLargestHeap(items, k);
		}

		middle = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
		}

		end = System.nanoTime();

		long averageTime = ((middle - start) - (end - middle)) / timesToLoop;

		System.out.println(N + " heap " + averageTime);

	}
	
	public static void timeSort(int N, int k, ArrayList<Integer> items) {

		long start, middle, end;

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		start = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
			FindKLargest.findKLargestSort(items, k);
		}

		middle = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
		}

		end = System.nanoTime();

		long averageTime = ((middle - start) - (end - middle)) / timesToLoop;

		System.out.println(N + " sort " + averageTime);

	}

}
