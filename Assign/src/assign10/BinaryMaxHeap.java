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

	@SuppressWarnings("unchecked")
	private E[] backingArray = (E[]) new Object[10];
	private int currentIndex = 0;
	private int currentSize = 0;
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
		if (currentSize == 0) {
			backingArray[currentIndex] = item;
		} else {
			currentIndex++;
			backingArray[currentIndex] = item;
			int index = currentIndex;
			int parentIndex;

			if (index % 2 == 0) {
				parentIndex = (index - 2) / 2;
			} else {
				parentIndex = (index - 1) / 2;
			}

			E parent = backingArray[parentIndex];

			percolateUp(index, parentIndex);
		}
		currentSize++;
	}

	/**
	 * Returns, but doesn't remove, the maximum value in the Binary Heap (insofar as
	 * it has one)
	 * 
	 * @return The maximum value in the BinaryHeap
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if (currentSize == 0) {
			throw new NoSuchElementException();
		} else {
			return backingArray[0];
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
		if (currentSize == 0) {
			throw new NoSuchElementException();
		} else {
			max = backingArray[0];
			int replacementIndex = (currentSize - 1);
			E replacementItem = backingArray[replacementIndex];
			backingArray[0] = replacementItem;
			if (currentSize != 1) {
				percolateDown(0);
			}
			backingArray[replacementIndex] = null;
		}
		currentIndex--;
		currentSize--;
		return max;
	}

	/**
	 * Returns the number of objects in the Binary Array
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * A method which determines if a BinaryHeap is empty or not
	 * 
	 * @return true if the BinaryHeap is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	/**
	 * A method which clears out the BinaryHeap by clearing out it's backing storage
	 */
	@Override
	public void clear() {
		backingArray = (E[]) new Object[10];
		currentSize = 0;
		currentIndex = 0;
	}

	/**
	 * A method which turns our BinaryHeap into an easy-to-read array
	 *
	 * @return An array of our BinaryHeap as it appears in it's backing storage
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[currentSize];
		for (int i = 0; i < array.length; i++) {
			array[i] = backingArray[i];
		}

		return array;
	}

	/**
	 * Builds a heap out of a given list object
	 * 
	 * @param list - the input list
	 */
	public void buildHeap(List<? extends E> list) {
		for (int i = 0; i < list.size(); i++ ) {
			backingArray[i] = list.get(i);
		}
		
		currentSize = list.size();

		int lastNonLeaf = (currentSize / 2) - 1;

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
	private void percolateUp(int o1, int o2) {
		int index = o1;
		int parentIndex = o2;

		E child = backingArray[o1];
		E parent = backingArray[o2];

		while (innerCompare(child, parent) > 0) {

			backingArray[parentIndex] = child;
			backingArray[index] = parent;

			index = parentIndex;

			if (index == 0) {
				break;
			}

			if (index % 2 == 0) {
				parentIndex = (index - 2) / 2;
			} else {
				parentIndex = (index - 1) / 2;
			}

			child = backingArray[index];
			parent = backingArray[parentIndex];
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
		E item = backingArray[index];
		int biggerChildIndex = returnBiggerChildIndex(index);
		E biggerChild;

		if (biggerChildIndex != -1) {
			biggerChild = backingArray[biggerChildIndex];

			while (innerCompare(item, biggerChild) < 0 && biggerChildIndex != -1) {

				if (biggerChildIndex != -1)
					biggerChild = backingArray[biggerChildIndex];

				backingArray[biggerChildIndex] = item;
				backingArray[index] = biggerChild;

				index = biggerChildIndex;
				item = backingArray[index];
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
		if (leftChildIndex >= currentSize || backingArray[leftChildIndex] == null) {
			return -1;
		}

		if (rightChildIndex >= currentSize || backingArray[rightChildIndex] == null) {
			return leftChildIndex;
		}

		if (innerCompare(backingArray[rightChildIndex], backingArray[leftChildIndex]) >= 0) {
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
