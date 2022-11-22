package assign10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap<E> implements PriorityQueue<E> {

	private ArrayList<E> backingArray = new ArrayList<E>();
	private int index = 0;
	private Comparator<? super E> cmp = null;

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
			
			E parent;

			if (index % 2 == 0) {
				parent = backingArray.get((index - 2) / 2);
			} else {
				parent = backingArray.get((index - 1) / 2);
			}
			
//			if (innerCompare() == true) {
//				if(cmp.compare(item, parent) > 0) {
//					percolateUp();
//				}
//			} else {
//				if (item.compareTo(parent) > 0) {
//					percolateUp();
//				}
//			}
			
			// Check if object is >= to its parent, and percolate up if so.
		}
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (backingArray.isEmpty()) {
			throw new NoSuchElementException();
		} else {return backingArray.get(0);}
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		if (backingArray.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			E max = backingArray.get(0);
			
		}
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
	// invoke a Comparable or Comparator method to just one place in your program.
	private <E extends Comparable<E>> int innerCompare(E o1, E o2) {
		if (cmp == null) {
			return o1.compareTo(o2);
		} else {
			return(cmp.compare(o1, o2));
		}
	}

	public static void main(String[] args) {
		
	}

}
