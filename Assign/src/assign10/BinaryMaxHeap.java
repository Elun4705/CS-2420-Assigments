package assign10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap<E> implements PriorityQueue<E> {

	private ArrayList<E> backingArray = new ArrayList<E>();
	private int index = 0;
	private Comparator<? super E> cmp;

	// If this constructor is used to create an empty binary heap,
	// it is assumed that the elements are ordered using their natural
	// ordering (i.e., E implements Comparable<? super E>).
	public BinaryMaxHeap() {
	}

	// If this constructor is used to create an empty binary heap, it
	// is assumed that the elements are ordered using the provided Comparator
	// object.
	public BinaryMaxHeap(Comparator<? super E> cmp) {
		this.cmp = cmp;
	}

	// If this constructor is used, then the binary heap is constructed from the
	// given list.
	// Also, it is assumed that the elements are ordered using their natural
	// ordering
	// (i.e., E implements Comparable<? super E>). RECALL: Using the buildHeap
	// operation,
	// we can construct a binary heap from these N items in O(N) time, which is more
	// efficient
	// than adding them to the binary heap one at a time. This constructor must use
	// such an operation.
	public BinaryMaxHeap(List<? extends E> list) {
	}

	// If this constructor is used, then the binary heap is constructed from the
	// given list
	// (see RECALL note above). Also, it is assumed that the elements are ordered
	// using
	// the provided Comparator object.
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> cmp) {
		this.cmp = cmp;
	}

	@Override
	public void add(E item) {
		if (backingArray.isEmpty()) {
			backingArray.add(item);
		} else {
			backingArray.add(item);
			int index = backingArray.indexOf(item);
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

	@Override
	public E peek() throws NoSuchElementException {
		if (backingArray.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return backingArray.get(0);
		}
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		E max;
		if (backingArray.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			max = backingArray.get(0);
			E replacement = backingArray.get(backingArray.size() - 1);
			backingArray.set(0, replacement);
			if (backingArray.size() != 1) {
				percolateDown(replacement);
			}
			backingArray.remove(backingArray.size() - 1);
		}
		return max;
	}

	@Override
	public int size() {
		return backingArray.size();
	}

	@Override
	public boolean isEmpty() {
		return backingArray.isEmpty();
	}

	@Override
	public void clear() {
		backingArray.clear();
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[backingArray.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = backingArray.get(i);
		}

		return array;
	}

	@SuppressWarnings("unused")
	private void buildHeap(List<? extends E> list) {
		for (E item : list) {
			backingArray.add(item);
		}

		int lastNonLeaf = ((backingArray.size()) / 2) - 1;

		for (int i = lastNonLeaf; i >= 0; i--) {
			percolateDown(backingArray.get(i));
		}

	}

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

	private void percolateDown(E o1) {
		int index = backingArray.indexOf(o1);
		E item = backingArray.get(index);
		E biggerChild;
		int biggerChildIndex;

		if ((index * 2) + 2 >= backingArray.size()) {
			biggerChild = backingArray.get((index * 2) + 1);
			biggerChildIndex = (index * 2) + 1;
		} else {
			if (innerCompare(backingArray.get((index * 2) + 1), backingArray.get((index * 2) + 2)) > 0) {
				biggerChild = backingArray.get((index * 2) + 1);
				biggerChildIndex = (index * 2) + 1;
			} else {
				biggerChild = backingArray.get(index * 2 + 2);
				biggerChildIndex = (index * 2) + 2;
			}
		}
		while (innerCompare(item, biggerChild) < 0) {

			backingArray.set(index, biggerChild);
			backingArray.set(biggerChildIndex, item);

			index = biggerChildIndex;

			if (index > backingArray.size() - 1) {
				break;
			}

			if ((index * 2) + 2 >= backingArray.size()) {
				biggerChild = backingArray.get((index * 2) + 1);
				biggerChildIndex = (index * 2) + 1;
			} else {

				if (innerCompare(backingArray.get((index * 2) + 1), backingArray.get((index * 2) + 2)) > 0) {
					biggerChild = backingArray.get((index * 2) + 1);
					biggerChildIndex = (index * 2) + 1;
				} else {
					biggerChild = backingArray.get(index * 2 + 2);
					biggerChildIndex = (index * 2) + 2;
				}

				item = backingArray.get(index);
				biggerChild = backingArray.get(biggerChildIndex);
			}
		}
	}

	// An innerCompare method is intended to isolate your decision of whether to
	// invoke a Comparable or Comparator method to just one place in your program.
	@SuppressWarnings("unchecked")
	private int innerCompare(E o1, E o2) {

		if (cmp == null) {
			return ((Comparable<E>) o1).compareTo((E) o2);
		} else {
			return cmp.compare(o1, o2);
		}
	}

	public static void main(String[] args) {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		ArrayList<Integer> testList = new ArrayList<Integer>();
		
		testList.add(9);
		testList.add(23);
		testList.add(2);
		testList.add(5);
		testList.add(7);
		testList.add(3);
		
		test.buildHeap(testList);

		System.out.println(Arrays.toString(test.toArray()));
	}

}
