package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindKLargestTest {

	@Test
	void testFindKLargestHeapComparable() {
		ArrayList<Integer> test = new ArrayList<Integer>();

		test.add(20);
		test.add(10);
		test.add(71);
		test.add(49);
		test.add(19);
		test.add(23);
		test.add(14);

		List<Integer> returnList1 = FindKLargest.findKLargestHeap(test, 2);

		assertEquals(71, returnList1.get(0));
		assertEquals(49, returnList1.get(1));

		List<Integer> returnList2 = FindKLargest.findKLargestHeap(test, 0);

		assertTrue(returnList2.isEmpty());

		List<Integer> returnList3 = FindKLargest.findKLargestHeap(test, 7);

		assertEquals(71, returnList3.get(0));
		assertEquals(49, returnList3.get(1));
		assertEquals(23, returnList3.get(2));
		assertEquals(20, returnList3.get(3));
		assertEquals(19, returnList3.get(4));
		assertEquals(14, returnList3.get(5));
		assertEquals(10, returnList3.get(6));

		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestHeap(test, -1));
		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestHeap(test, 8));

	}

	@Test
	void testFindKLargestHeapComparator() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		IntegerComparator cmp = new IntegerComparator();

		test.add(20);
		test.add(10);
		test.add(71);
		test.add(49);
		test.add(19);
		test.add(23);
		test.add(14);

		List<Integer> returnList1 = FindKLargest.findKLargestHeap(test, 2, cmp);

		assertEquals(71, returnList1.get(0));
		assertEquals(49, returnList1.get(1));

		List<Integer> returnList2 = FindKLargest.findKLargestHeap(test, 0, cmp);

		assertTrue(returnList2.isEmpty());

		List<Integer> returnList3 = FindKLargest.findKLargestHeap(test, 7, cmp);

		assertEquals(71, returnList3.get(0));
		assertEquals(49, returnList3.get(1));
		assertEquals(23, returnList3.get(2));
		assertEquals(20, returnList3.get(3));
		assertEquals(19, returnList3.get(4));
		assertEquals(14, returnList3.get(5));
		assertEquals(10, returnList3.get(6));

		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestHeap(test, -1, cmp));
		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestHeap(test, 8, cmp));

	}

	@Test
	void testFindKLargestSortComparable() {
		ArrayList<Integer> test = new ArrayList<Integer>();

		test.add(20);
		test.add(10);
		test.add(71);
		test.add(49);
		test.add(19);
		test.add(23);
		test.add(14);

		List<Integer> returnList1 = FindKLargest.findKLargestSort(test, 2);

		assertEquals(71, returnList1.get(0));
		assertEquals(49, returnList1.get(1));

		List<Integer> returnList2 = FindKLargest.findKLargestSort(test, 0);

		assertTrue(returnList2.isEmpty());

		List<Integer> returnList3 = FindKLargest.findKLargestSort(test, 7);

		assertEquals(71, returnList3.get(0));
		assertEquals(49, returnList3.get(1));
		assertEquals(23, returnList3.get(2));
		assertEquals(20, returnList3.get(3));
		assertEquals(19, returnList3.get(4));
		assertEquals(14, returnList3.get(5));
		assertEquals(10, returnList3.get(6));

		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestSort(test, -1));
		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestSort(test, 8));

	}

	@Test
	void testFindKLargestSortComparator() {
		ArrayList<Integer> test = new ArrayList<Integer>();
		IntegerComparator cmp = new IntegerComparator();

		test.add(20);
		test.add(10);
		test.add(71);
		test.add(49);
		test.add(19);
		test.add(23);
		test.add(14);

		List<Integer> returnList1 = FindKLargest.findKLargestSort(test, 2, cmp);

		assertEquals(71, returnList1.get(0));
		assertEquals(49, returnList1.get(1));

		List<Integer> returnList2 = FindKLargest.findKLargestSort(test, 0, cmp);

		assertTrue(returnList2.isEmpty());

		List<Integer> returnList3 = FindKLargest.findKLargestSort(test, 7, cmp);

		assertEquals(71, returnList3.get(0));
		assertEquals(49, returnList3.get(1));
		assertEquals(23, returnList3.get(2));
		assertEquals(20, returnList3.get(3));
		assertEquals(19, returnList3.get(4));
		assertEquals(14, returnList3.get(5));
		assertEquals(10, returnList3.get(6));

		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestSort(test, -1, cmp));
		assertThrows(IllegalArgumentException.class, () -> FindKLargest.findKLargestSort(test, 8, cmp));

	}

	private class IntegerComparator implements Comparator<Integer> {

		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	}
}
