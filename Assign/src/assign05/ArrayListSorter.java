package assign05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

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
		quicksort(arr, 0, arr.size()-1);
	}
	
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> arr, int left, int right) {
		if (left < right) {
			  
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, left, right);
            
            System.out.println(pi);
  
            // Separately sort elements before
            // partition and after partition
            quicksort(arr, left, pi - 1);
            quicksort(arr, pi + 1, right);
        }
	}

	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>(size);
		
		for(int i = 1; i <= size; i++) {
			list.add(i);
		}
		return list;

	}

	public static ArrayList<Integer> generatePermuted(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>(size);
		
		for(int i = 1; i <= size; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		return list;
	}

	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
			for(int i = size; i >= 1; i--) {
				list.add(i);
			}
		return list;
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
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable> int partition(ArrayList<T> arr, int leftBound, int rightBound) {
		// Extreme Bounds
		 T pivot = arr.get(rightBound);
//		T pivot = arr.get(leftBound);
		
		// Median Piv
//		T low = arr.get(leftBound), high = arr.get(rightBound), median = arr.get((rightBound-1)/2);
//		ArrayList<T> temp = new ArrayList<T>();
//		temp.add(low);
//		temp.add(high);
//		temp.add(median);
		
//		insertionSort(temp);
//		
//		T pivot = temp.get(1);
		swap(arr, arr.indexOf(pivot), rightBound);

		int L = leftBound, R = rightBound-1;

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
	
	public static <T extends Comparable> void swap(ArrayList<T> arr, int i, int j) {
		
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
		
	}
	
	public static void main(String[]args) {
		ArrayList<Integer> test = generateAscending(10);
		ArrayList<Integer> test1 = generatePermuted(10);
		
		System.out.println(test);
		System.out.println(test1);
	}

}
