package assign09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HashTableAnalysis {

	private static Random rand;
	private static int timesToLoop = 100;

	private static void countCollisions(int N) {
		long starttime, mediumtime, endtime;
		rand.setSeed(System.currentTimeMillis());

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}
		starttime = System.currentTimeMillis();

		for (int i = 0; i < timesToLoop; i++) {
			HashTable<StudentGoodHash, Integer> test = new HashTable<StudentGoodHash, Integer>();

			for (int j = 0; j < N; j++) {
				test.put(new StudentGoodHash(rand.nextInt(), randomString(10), randomString(10)), rand.nextInt());
			}
		}

		mediumtime = System.currentTimeMillis();

		for (int i = 0; i < timesToLoop; i++) {
			HashTable<StudentGoodHash, Integer> test = new HashTable<StudentGoodHash, Integer>();
			for (int j = 0; j < N; j++) {
				new StudentGoodHash(rand.nextInt(), randomString(10), randomString(10));
				rand.nextInt();
			}
		}
		
		endtime = System.currentTimeMillis();
		
		long averageTime = ((mediumtime - starttime) - (endtime - mediumtime)) / timesToLoop;
		
		System.out.println(N + " " + averageTime);

	}

	public static void main(String[] args) {
		rand = new Random();

		// Time adding N values to different kinds of queues
		for (int N = 1000; N <= 15000; N += 1000) {
			countCollisions(N);
		}
	}

	public static String randomString(int size) {
		char[] charList = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		String word = "";
		for (int i = 0; i < rand.nextInt(10); i++) {
			word += charList[rand.nextInt(26)];
		}

		return word;
	}
}
