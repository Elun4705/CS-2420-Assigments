package assign10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A custom BinaryHeapClass which can be used to initialize a priority queue.
 * 
 * @author Andy Huo and Emmanuel Luna
 *
 * @param <E>
 */
public class BinaryMaxHeap<E> implements PriorityQueue<E> {

	private ArrayList<E> backingArray = new ArrayList<E>();
	private int currentIndex = 0;
	private Comparator<? super E> cmp;

	/**
	 * A default constructor for an empty BinaryHeap
	 */
	public BinaryMaxHeap() {
	}

	/**
	 * A constructor which notifies the BinaryHeap class that it intends to use its
	 * own comparator object
	 * 
	 * @param cmp - comparator object
	 */
	public BinaryMaxHeap(Comparator<? super E> cmp) {
		this.cmp = cmp;
	}

	/**
	 * A constructor which creates the BinaryHeap with its input list
	 * 
	 * @param list - input list
	 */
	public BinaryMaxHeap(List<? extends E> list) {
		this.buildHeap(list);
	}

	/**
	 * A constructor which creates the BinaryHeap with its input list and notifies
	 * the class that it intends to use its own comparator
	 * 
	 * @param list - input list
	 * @param cmp  - comparator object
	 */
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> cmp) {
		this.cmp = cmp;
		this.buildHeap(list);
	}

	/**
	 * Adds the given object to the binary heap, and adjusts it's position
	 * accordingly.
	 */
	@Override
	public void add(E item) {
		if (backingArray.isEmpty()) {
			backingArray.add(item);
		} else {
			backingArray.add(item);
			currentIndex++;
			int index = currentIndex;
			int parentIndex;

			if (index % 2 == 0) {
				parentIndex = (index - 2) / 2;
			} else {
				parentIndex = (index - 1) / 2;
			}

			E parent = backingArray.get(parentIndex);

			percolateUp(item, parent);
		}
	}

	/**
	 * Returns, but doesn't remove, the maximum value in the Binary Heap (insofar as
	 * it has one)
	 * 
	 * @return The maximum value in the BinaryHeap
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if (backingArray.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return backingArray.get(0);
		}
	}

	/**
	 * Removes the maximum (root) of the BinaryHeap and returns it
	 * 
	 * @return The maximum value in the BinaryHeap
	 */
	@Override
	public E extractMax() throws NoSuchElementException {
		E max;
		if (backingArray.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			max = backingArray.get(0);
			int replacementIndex = (backingArray.size() - 1);
			E replacementItem = backingArray.get(replacementIndex);
			backingArray.set(0, replacementItem);
			if (backingArray.size() != 1) {
				percolateDown(0);
			}
			backingArray.remove(replacementIndex);
		}
		currentIndex--;
		return max;
	}

	/**
	 * Returns the number of objects in the Binary Array
	 */
	@Override
	public int size() {
		return backingArray.size();
	}

	/**
	 * A method which determines if a BinaryHeap is empty or not
	 * 
	 * @return true if the BinaryHeap is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return backingArray.isEmpty();
	}

	/**
	 * A method which clears out the BinaryHeap by clearing out it's backing storage
	 */
	@Override
	public void clear() {
		backingArray.clear();
	}

	/**
	 * A method which turns our BinaryHeap into an easy-to-read array
	 *
	 * @return An array of our BinaryHeap as it appears in it's backing storage
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[backingArray.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = backingArray.get(i);
		}

		return array;
	}

	/**
	 * Builds a heap out of a given list object
	 * 
	 * @param list - the input list
	 */
	public void buildHeap(List<? extends E> list) {
		for (E item : list) {
			backingArray.add(item);
		}

		int lastNonLeaf = ((backingArray.size()) / 2) - 1;

		for (int i = lastNonLeaf; i >= 0; i--) {
			percolateDown(i);
		}

	}

	/**
	 * A helper method which contains code for percolating an object upward
	 * 
	 * @param o1 - the object to be percolated upward
	 * @param o2 - the object's initial parent object
	 */
	private void percolateUp(E o1, E o2) {
		int index = backingArray.indexOf(o1);
		int parentIndex = backingArray.indexOf(o2);

		E child = o1;
		E parent = o2;

		while (innerCompare(child, parent) > 0) {

			backingArray.set(parentIndex, child);
			backingArray.set(index, parent);

			index = parentIndex;

			if (index == 0) {
				break;
			}

			if (index % 2 == 0) {
				parentIndex = (index - 2) / 2;
			} else {
				parentIndex = (index - 1) / 2;
			}

			child = backingArray.get(index);
			parent = backingArray.get(parentIndex);
		}

	}

	/**
	 * A helper method which contains the code for percolating an object down
	 * through the heap
	 * 
	 * @param o1 - the index of the object being percolated
	 */
	private void percolateDown(int o1) {
		int index = o1;
		E item = backingArray.get(index);
		int biggerChildIndex = returnBiggerChildIndex(index);
		E biggerChild;

		if (biggerChildIndex != -1) {
			biggerChild = backingArray.get(biggerChildIndex);

			while (innerCompare(item, biggerChild) < 0 && biggerChildIndex != -1) {

				if (biggerChildIndex != -1)
					biggerChild = backingArray.get(biggerChildIndex);

				backingArray.set(biggerChildIndex, item);
				backingArray.set(index, biggerChild);

				index = biggerChildIndex;
				item = backingArray.get(index);
				biggerChildIndex = returnBiggerChildIndex(index);
			}
		}
	}

	/**
	 * A private helper method which helps to determine the index of the larger
	 * child of the object at the given index.
	 * 
	 * @param o1 - The int to caluculate biggerChild int off of.
	 * @return -1 if there is no bigger child index, or else either leftChildIndex
	 *         or rightChildIndex depending on which child is larger
	 */
	private int returnBiggerChildIndex(int o1) {
		int leftChildIndex = (o1 * 2) + 1;
		int rightChildIndex = (o1 * 2) + 2;
		if (leftChildIndex >= backingArray.size()) {
			return -1;
		}

		if (rightChildIndex >= backingArray.size()) {
			return leftChildIndex;
		}

		if (innerCompare(backingArray.get(rightChildIndex), backingArray.get(leftChildIndex)) >= 0) {
			return rightChildIndex;
		} else {
			return leftChildIndex;
		}

	}

	/**
	 * A private helper method which determines whether or not to use a given
	 * Comparator object, then compares the input elements and returns an
	 * appropriate int value depending on the comparison.
	 * 
	 * @param o1 - First object to be compared
	 * @param o2 - Second object to be compared
	 * @return A negative int if o1 is less than o2, 0 if they're equal, and a
	 *         positive int if o1 is greather than o2.
	 */
	@SuppressWarnings("unchecked")
	private int innerCompare(E o1, E o2) {

		if (cmp == null) {
			return ((Comparable<E>) o1).compareTo((E) o2);
		} else {
			return cmp.compare(o1, o2);
		}
	}
}
