package assign10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap<E> implements PriorityQueue<E> {

	private ArrayList<E> backingArray = new ArrayList<E>();
	private int index = 0;

	// If this constructor is used to create an empty binary heap,
	// it is assumed that the elements are ordered using their natural
	// ordering (i.e., E implements Comparable<? super E>).
	public BinaryMaxHeap() {
		// do
	}

	// If this constructor is used to create an empty binary heap, it
	// is assumed that the elements are ordered using the provided Comparator
	// object.
	public BinaryMaxHeap(Comparator<? super E> cmp) {

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

	}

	@Override
	public void add(E item) {
		if (backingArray.isEmpty()) {
			backingArray.add(item);
		} else {
			backingArray.add(item);
			int index = backingArray.indexOf(item);
			
			E parent;

			if (index % 2 == 0) {
				parent = backingArray.get((index - 2) / 2);
			} else {
				parent = backingArray.get((index - 1) / 2);
			}
			
			if (item.compareTo(parent) > 0);

		}
	}

	@Override
	public E peek() throws NoSuchElementException {
		return backingArray.get(0);
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	private void buildHeap() {
	}

	private void percolateUp() {
	}

	private void percolateDown() {
	}

	// An innerCompare method is intended to isolate your decision of whether to
	// invoke a
	// Comparable or Comparator method to just one place in your program.
	private void innerCompare() {
	}

}
