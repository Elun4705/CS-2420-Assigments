package assign05;
// Written by A

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * This class represents an ArrayList sorter with two different methods: a recursive quicksort,
 * and a recursive mergesort.  The threshold instance variable determines the threshold at which 
 * mergesort calls insertion sort.
 * 
 * @author Andy Huo and Emmanuel Luna
 * @version October 5, 2022
 */
public class ArrayListSorter {
	private static int threshold = 13;

	/**
	 * The driver method for our Recursive Mergesort
	 * @param <T> Generic
	 * @param arr is array list being inputed into mergesort
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> arr) {
//		Create a temp space and ensure it is large enough

		ArrayList<T> temp = new ArrayList<T>();

		for (int i = 0; i < arr.size(); i++) {
			temp.add(arr.get(i));
		}

		// call internal overloaded method for entire array, and merge space
		// NOTE: size()-1, not size
		mergesort(arr, temp, 0, arr.size() - 1);
	}

	/**
	 * The Driver method for our Recursive Quicksort
	 * 
	 * @param <T> Generic
	 * @param arr is the array being quicksorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr) {
		quicksort(arr, 0, arr.size() - 1);
	}

	/**
	 * This is the recursive method of quicksort
	 * 
	 * @param <T> Generic
	 * @param arr inputed array list
	 * @param left is the left limit for quicksort
	 * @param right is the right limit of quicksort
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int left, int right) {
		if (left < right) {

			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, left, right);

			// Separately sort elements before
			// partition and after partition
			quicksort(arr, left, pi - 1);
			quicksort(arr, pi + 1, right);
		}
	}

	/**
	 * Generates an Integer Arraylist in ascending order up to the input size
	 * 
	 * @param size
	 * @return An array in ascending order of the inputed size
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		// Create a new Integer ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>(size);
		
		// Fill the ArrayList with Integers in order from 1 to the input size
		for (int i = 1; i <= size; i++) {
			list.add(i);
		}
		return list;

	}

	/**
	 * Generates a randomly ordered integer ArrayList containing all integers from 1 to input size
	 * 
	 * @param size
	 * @return An array in permuted order of the inputed size
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		// Create a new Integer ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>(size);
		
		// Fill the ArrayList with Integers in order from 1 to the input size
		for (int i = 1; i <= size; i++) {
			list.add(i);
		}
		
		// Shuffle the indices of the ArrayList
		Collections.shuffle(list);
		return list;
	}

	/**
	 * Generates an Integer ArrayList in descending order of input size
	 * 
	 * @param size
	 * @return An array in descending order of the inputed size
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		// Create a new Integer ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Fill the ArrayList with Integers in order from the input size to 1
		for (int i = size; i >= 1; i--) {
			list.add(i);
		}
		return list;
	}

	/**
	 * The recursive method for MergeSort
	 * 
	 * @param <T> Generic
	 * @param arr is inputed array list
	 * @param temp is the temporary array as a place holder, holder for all data before merging
	 * @param start is the start of the merging
	 * @param end is the stopping point of the merging
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends Comparable> void mergesort(ArrayList<T> arr, ArrayList<T> temp, int start, int end) {
		
		// If the array size reaches a certain threshold, perform insertion sort
		if (end <= (arr.size()/10)) {
			insertionSort(arr);
			return;
		}
		
		// If the array passed in is of size one, simply return it
		if (start >= end)
			return;

		// Run recursive code
		int mid = start + (end - start) / 2;
		mergesort(arr, temp, start, mid);
		mergesort(arr, temp, mid + 1, end);
		merge(arr, temp, start, mid, end);
	}
	
	//
	/**
	 * The method used to merge two arraylists together
	 * 
	 * @param <T> Generic
	 * @param arr - Generic arr being inputed
	 * @param temp - Temporary array as a place holder, holder for all data before merging
	 * @param start - Where the merging begins
	 * @param mid - Midpoint of merging
	 * @param end - End of merging, tells where to stop
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Comparable> void merge(ArrayList<T> arr, ArrayList<T> temp, int start, int mid, int end) {
		// Set positions for merge
		int i = start;
		int j = mid + 1;
		int mergePos = start;
		
		// Merge the two lists together
		while (i <= mid && j <= end) {
			if (arr.get(i).compareTo(arr.get(j)) <= 0)
				temp.set(mergePos++, arr.get(i++));
			else
				temp.set(mergePos++, arr.get(j++));
		}
	}
	
	/**
	 * A generic insertion sort method which uses a comparator to help it sort an input list
	 * 
	 * @param <T> Represents Generic
	 * @param list The input list of objects
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable> void insertionSort(ArrayList<T> list) {

		// A basic for/while loop setup which works with the comparator to sort the
		// input list
		for (int i = 1; i < list.size(); ++i) {
			T item = list.get(i);
			int j = i - 1;
			while (j >= 0 && (list.get(j).compareTo(item) > 0)) {
				list.set(j + 1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, item);
		}

	}

	/**
	 * Runs the partitioning code for the QuickSort algorithm
	 * 
	 * @param <T>
	 * @param arr
	 * @param leftBound
	 * @param rightBound
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable> int partition(ArrayList<T> arr, int leftBound, int rightBound) {
		// Extreme Bounds
//		T pivot = arr.get(rightBound);
//		T pivot = arr.get(leftBound);

//		Median Piv
		T low = arr.get(leftBound), high = arr.get(rightBound), median =
		arr.get((rightBound-1)/2);
		ArrayList<T> temp = new ArrayList<T>();
		temp.add(low);
		temp.add(high);
		temp.add(median);
		
		insertionSort(temp);
		
		T pivot = temp.get(1);
		
		// Swap the pivot with the item at the right boundary
		swap(arr, arr.indexOf(pivot), rightBound);
		
		// Initialize position trackers
		int L = leftBound, R = rightBound - 1;

		// Look for potential swap points and swap if found
		while (L <= R) {
			while (L < rightBound && arr.get(L).compareTo(pivot) <= 0)
				L++;
			while (R >= leftBound && arr.get(R).compareTo(pivot) >= 0)
				R--;

			if (L < R)
				swap(arr, L, R);
		}

		swap(arr, L, rightBound);

		return L;

	}

	/**
	 * Swaps two items in an ArrayList at the input indices
	 * 
	 * @param <T> Generic Type
	 * @param arr The input array containing objects to be swapped
	 * @param i The index of the first object to be swapped
	 * @param j The index of the second object to be swapped
	 */
	public static <T extends Comparable> void swap(ArrayList<T> arr, int i, int j) {

		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);

	}
}
