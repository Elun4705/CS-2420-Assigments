package assign10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class contains generic static methods for finding the k largest items in
 * a list.
 * 
 * @author Erin Parker & Emmanuel Luna & Andy Huo
 * @version ??
 */
public class FindKLargest {

	/**
	 * Determines the k largest items in the given list, using a binary max heap and
	 * the natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k     - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of
	 *                                  the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestHeap(List<E> items, int k)
			throws IllegalArgumentException {
		
		if (k < 0 || k > items.size()) {
			throw new IllegalArgumentException();
		}
		
		BinaryMaxHeap<E> BMH = new BinaryMaxHeap<E>(items);
		
		ArrayList<E> returnList = new ArrayList<E>();

		for (int i = 0; i < k; i++) {
			returnList.add(BMH.extractMax());
		}

		return returnList;
	}

	/**
	 * Determines the k largest items in the given list, using a binary max heap.
	 * 
	 * @param items - the given list
	 * @param k     - the number of largest items
	 * @param cmp   - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of
	 *                                  the given list
	 */
	public static <E> List<E> findKLargestHeap(List<E> items, int k, Comparator<? super E> cmp)
			throws IllegalArgumentException {
		
		if (k < 0 || k > items.size()) {
			throw new IllegalArgumentException();
		}
		
		BinaryMaxHeap<E> BMH = new BinaryMaxHeap<E>(items, cmp);
		
		ArrayList<E> returnList = new ArrayList<E>();

		for (int i = 0; i < k; i++) {
			returnList.add(BMH.extractMax());
		}

		return returnList;
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine
	 * and the natural ordering of the items.
	 * 
	 * @param items - the given list
	 * @param k     - the number of largest items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of
	 *                                  the given list
	 */
	public static <E extends Comparable<? super E>> List<E> findKLargestSort(List<E> items, int k)
			throws IllegalArgumentException {
		if (k < 0 || k > items.size()) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<E> returnList = new ArrayList<E>();
		
		Collections.sort(items);
		
		for (int i = items.size() - 1; i >= items.size() - k; i--) {
			returnList.add(items.get(i));
		}
		
		return returnList;
		
	}

	/**
	 * Determines the k largest items in the given list, using Java's sort routine.
	 * 
	 * @param items - the given list
	 * @param k     - the number of largest items
	 * @param cmp   - the comparator defining how to compare items
	 * @return a list of the k largest items, in descending order
	 * @throws IllegalArgumentException if k is negative or larger than the size of
	 *                                  the given list
	 */
	public static <E> List<E> findKLargestSort(List<E> items, int k, Comparator<? super E> cmp)
			throws IllegalArgumentException {
		
		if (k < 0 || k > items.size()) {
			throw new IllegalArgumentException();
		}
		
		ArrayList<E> returnList = new ArrayList<E>();
		
		Collections.sort(items, cmp);
		
		for (int i = items.size() - 1; i >= items.size() - k; i--) {
			returnList.add(items.get(i));
		}
		
		return returnList;
	}
}