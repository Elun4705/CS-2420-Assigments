package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryMaxHeapTest {

	@Test
	void testAdd() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		Integer[] follow = new Integer[] { 3, 1, 2 };

		test.add(1);
		test.add(2);
		test.add(3);

		assertEquals(Arrays.toString(follow), Arrays.toString(test.toArray()));
	}

	@Test
	void testAdd2() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		Integer[] follow = new Integer[] { 6, 1, 2 };

		test.add(1);
		test.add(2);
		test.add(3);
		test.extractMax();
		test.add(6);

		assertEquals(Arrays.toString(follow), Arrays.toString(test.toArray()));
	}

	@Test
	void testPeek() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();

		assertThrows(NoSuchElementException.class, () -> test.peek());

		test.add(1);
		test.add(2);
		test.add(3);

		assertEquals(3, test.peek());

		test.add(10);
		assertEquals(10, test.peek());
	}

	@Test
	void testExtractMax() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		Integer[] testResult = new Integer[] { 2, 1 };

		assertThrows(NoSuchElementException.class, () -> test.extractMax());

		test.add(1);
		test.add(2);
		test.add(3);

		assertEquals(3, test.extractMax());
		assertEquals(Arrays.toString(testResult), Arrays.toString(test.toArray()));

		assertEquals(2, test.extractMax());
		assertEquals(1, test.extractMax());

		assertThrows(NoSuchElementException.class, () -> test.extractMax());

	}

	@Test
	void testSize() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		assertEquals(0, test.size());

		test.add(1);
		assertEquals(1, test.size());

		test.add(2);
		assertEquals(2, test.size());

		test.add(3);
		assertEquals(3, test.size());

		test.extractMax();
		assertEquals(2, test.size());
	}

	@Test
	void testExpandCapacity() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);

		test.expandCapacity();

		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);
		test.add(1);

		assertEquals(12, test.size());

		test.extractMax();
		test.extractMax();
		test.extractMax();

		assertEquals(9, test.size());

		test.add(2);
		Integer[] testArr = new Integer[] { 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));

		assertEquals(2, test.extractMax());
	}

	@Test
	void testIsNotEmpty() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();

		test.add(1);
		test.add(2);
		test.add(3);

		assertFalse(test.isEmpty());

		test.extractMax();
		test.extractMax();
		test.extractMax();

		assertTrue(test.isEmpty());
	}

	@Test
	void testIsEmpty() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();

		assertTrue(test.isEmpty());

		test.add(1);

		assertFalse(test.isEmpty());
	}

	@Test
	void testClear() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();

		test.add(1);
		test.add(2);
		test.add(3);

		test.clear();

		assertTrue(test.isEmpty());
		assertThrows(NoSuchElementException.class, () -> test.extractMax());
		assertThrows(NoSuchElementException.class, () -> test.peek());

	}

	@Test
	void testBuildHeap() {
		BinaryMaxHeap<Integer> result = new BinaryMaxHeap<Integer>();
		ArrayList<Integer> testList = new ArrayList<Integer>();
		Integer[] test = new Integer[] { 9, 5, 8, 5, 3, 6, 2, 1 };

		testList.add(3);
		testList.add(1);
		testList.add(2);
		testList.add(5);
		testList.add(5);
		testList.add(6);
		testList.add(8);
		testList.add(9);

		result.buildHeap(testList);

		assertEquals(Arrays.toString(test), Arrays.toString(result.toArray()));
		assertFalse(result.isEmpty());
	}
	
	@Test
	void testBuildHeapEffect() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		ArrayList<Integer> testList = new ArrayList<Integer>();
		Integer[] follow1 = new Integer[] {3, 3, 3, 2, 2, 3, 1, 2, 1, 1, 2, 1};
		
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(1);
		testList.add(2);
		testList.add(3);
		
		test.buildHeap(testList);
		assertEquals(12, test.size());
		
		assertEquals(Arrays.toString(follow1), Arrays.toString(test.toArray()));
		test.add(20);
		assertEquals(13, test.size());
		
		Integer[] follow2 = new Integer[] {20, 3, 3, 2, 2, 3, 1, 2, 1, 1, 2, 1, 3};
		assertEquals(Arrays.toString(follow2), Arrays.toString(test.toArray()));
		
		assertEquals(20, test.extractMax());
		assertEquals(12, test.size());
	}

	@Test
	void testCmpConstructor() {
		IntegerComparator intCmp = new IntegerComparator();
		BinaryMaxHeap<Integer> testCmp = new BinaryMaxHeap<Integer>(intCmp);

		Integer[] test1 = new Integer[] { 29, 17, 20, 1, 7, 4 };

		testCmp.add(1);
		testCmp.add(20);
		testCmp.add(29);
		testCmp.add(17);
		testCmp.add(7);
		testCmp.add(4);

		assertEquals(Arrays.toString(test1), Arrays.toString(testCmp.toArray()));
		assertEquals(6, testCmp.size());

		Integer[] test2 = new Integer[] { 20, 17, 4, 1, 7 };

		testCmp.extractMax();

		assertEquals(Arrays.toString(test2), Arrays.toString(testCmp.toArray()));
		assertEquals(5, testCmp.size());

		Integer[] test3 = new Integer[] { 7, 1, 4 };

		testCmp.extractMax();
		testCmp.extractMax();

		assertEquals(Arrays.toString(test3), Arrays.toString(testCmp.toArray()));
		assertEquals(3, testCmp.size());
	}

	@Test
	void testListConstructor() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(20);
		list.add(29);
		list.add(17);
		list.add(7);
		list.add(4);

		BinaryMaxHeap<Integer> testList = new BinaryMaxHeap<Integer>(list);

		Integer[] test1 = new Integer[] { 29, 20, 4, 17, 7, 1 };

		assertEquals(Arrays.toString(test1), Arrays.toString(testList.toArray()));
		assertEquals(6, testList.size());

		Integer[] test2 = new Integer[] { 20, 17, 4, 1, 7 };

		testList.extractMax();

		assertEquals(Arrays.toString(test2), Arrays.toString(testList.toArray()));
		assertEquals(5, testList.size());

		Integer[] test3 = new Integer[] { 7, 1, 4 };

		testList.extractMax();
		testList.extractMax();

		assertEquals(Arrays.toString(test3), Arrays.toString(testList.toArray()));
		assertEquals(3, testList.size());
	}

	@Test
	void testListCmpConstructor() {
		IntegerComparator intCmp = new IntegerComparator();
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(20);
		list.add(29);
		list.add(17);
		list.add(7);
		list.add(4);
		BinaryMaxHeap<Integer> testCmp = new BinaryMaxHeap<Integer>(list, intCmp);

		Integer[] test1 = new Integer[] { 29, 20, 4, 17, 7, 1 };

		assertEquals(Arrays.toString(test1), Arrays.toString(testCmp.toArray()));
		assertEquals(6, testCmp.size());

		Integer[] test2 = new Integer[] { 20, 17, 4, 1, 7 };

		testCmp.extractMax();

		assertEquals(Arrays.toString(test2), Arrays.toString(testCmp.toArray()));
		assertEquals(5, testCmp.size());

		Integer[] test3 = new Integer[] { 7, 1, 4 };

		testCmp.extractMax();
		testCmp.extractMax();

		assertEquals(Arrays.toString(test3), Arrays.toString(testCmp.toArray()));
		assertEquals(3, testCmp.size());
	}

	private class IntegerComparator implements Comparator<Integer> {

		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	}
}
