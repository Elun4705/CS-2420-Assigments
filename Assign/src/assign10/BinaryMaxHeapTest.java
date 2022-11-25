package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryMaxHeapTest {

	@Test
	void testAdd() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		Integer[] follow = new Integer[] {3, 1, 2};
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(Arrays.toString(follow), Arrays.toString(test.toArray()));
	}
	
	@Test
	void testAdd2() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		Integer[] follow = new Integer[] {6, 1, 2};
		
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
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(3, test.peek());
	}
	
	@Test
	void testExtractMax() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(3, test.extractMax());
	}
	
	@Test
	void testSize() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertEquals(3, test.size());
	}
	
	@Test
	void testIsNotEmpty() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		
		test.add(1);
		test.add(2);
		test.add(3);
		
		assertFalse(test.isEmpty());
	}
	
	@Test
	void testIsEmpty() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();
		
		assertTrue(test.isEmpty());
	}
	
	@Test
	void testClear() {
		BinaryMaxHeap<Integer> test = new BinaryMaxHeap<Integer>();

		test.add(1);
		test.add(2);
		test.add(3);
		
		test.clear();
		
		assertTrue(test.isEmpty());
	}
	
	@Test
	void testBuildHeap() {
		BinaryMaxHeap<Integer> result = new BinaryMaxHeap<Integer>();
		ArrayList<Integer> testList = new ArrayList<Integer>();
		Integer[] test = new Integer[] {3, 1, 2, 5, 5, 6, 8, 9};
		
		testList.add(3);
		testList.add(1);
		testList.add(2);
		testList.add(5);
		testList.add(5);
		testList.add(6);
		testList.add(8);
		testList.add(9);
		
		result.buildHeap(testList);
		
		System.out.println(Arrays.toString(result.toArray()));
	}
	
}
