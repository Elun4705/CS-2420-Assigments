package assign05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayListSorter {
	private static int threshold = 3;

	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
//		Create a temp space and ensure it is large enough

		ArrayList<T> temp = new ArrayList<T>();
		
		for (int i = 0; i < arr.size(); i++) {
			temp.add(arr.get(i));
		}
		
		// call internal overloaded method for entire array, and merge space
		// NOTE: size()-1, not size
		mergesort(arr, temp, 0, arr.size()-1);
	}

	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {

	}

	public static ArrayList<Integer> generateAscending(int size) {

	}

	public static ArrayList<Integer> generatePermuted(int size) {

	}

	public static ArrayList<Integer> generateDescending(int size) {

	}

	@SuppressWarnings("rawtypes")
	public static <T extends Comparable> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int start, int end) {

		if (end <= threshold) {
			insertionSort(arr);
			return;
		}
		
		if (start >= end)
			return;

		int mid = start + (end - start) / 2;
		mergesort(arr, temp, start, mid);
		mergesort(arr, temp, mid + 1, end);
		merge(arr, temp, start, mid, end);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })

	public static <T extends Comparable> void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid, int end) {

		int i = start;
		int j = mid + 1;
		int mergePos = start;

		while (i <= mid && j <= end) {
			if (arr.get(i).compareTo(arr.get(j)) <= 0)
				temp.set(mergePos++, arr.get(i++));
			else
				temp.set(mergePos++, arr.get(j++));
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable> void insertionSort(ArrayList<T> list) {

		// A basic for/while loop setup which works with the comparator to sort the
		// input list
		for (int i = 1; i < list.size() - 1; ++i) {
			T item = list.get(i);
			int j = i - 1;
			while (j >= 0 && (list.get(j).compareTo(item) > 0)) {
				list.set(j + 1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, item);
		}

	}
	
	public static void main(String[]args) {
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(9);
		test.add(7);
		test.add(8);
		test.add(3);
		test.add(4);
		test.add(6);
		test.add(5);
		test.add(2);
		test.add(10);
		
		System.out.println(test.size());
		
		mergesort(test);
		
		System.out.println(test);
	}

}
