package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void testAdd() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		ArrayList<Integer> testArr = new ArrayList<Integer>();
		assertTrue(test.add(1));
		assertFalse(test.add(1));

		assertTrue(test.add(2));
		assertTrue(test.add(0));

		testArr.add(0);
		testArr.add(1);
		testArr.add(2);

		assertEquals(testArr, test.toArrayList());
	}

	@Test
	void testaddAll() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> test2 = new BinarySearchTree<Integer>();

		ArrayList<Integer> testarr = new ArrayList<Integer>();
		ArrayList<Integer> testarr2 = new ArrayList<Integer>();

		testarr.add(8);
		testarr.add(4);
		testarr.add(12);
		testarr.add(2);
		testarr.add(6);
		testarr.add(10);
		testarr.add(14);
		testarr.add(1);
		testarr.add(3);
		testarr.add(5);
		testarr.add(7);
		testarr.add(9);
		testarr.add(11);
		testarr.add(13);
		testarr.add(15);

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);
		test.add(16);
		
		testarr2.add(14);
		testarr2.add(16);

		assertTrue(test2.addAll(testarr));
		assertFalse(test2.addAll(testarr));
		assertTrue(test2.addAll(testarr2));

		assertEquals(test.toArrayList(), test2.toArrayList());
	}

	@Test
	void testClear() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		ArrayList<Integer> testarr = new ArrayList<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);
	
		test.clear();
		
		assertEquals(testarr, test.toArrayList());
	}

	@Test
	void testContains() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);

		assertTrue(test.contains(14));
		assertFalse(test.contains(0));
	}
	
	@Test
	void testContainsAll() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();

		ArrayList<Integer> testarr = new ArrayList<Integer>();

		testarr.add(8);
		testarr.add(4);
		testarr.add(12);
		testarr.add(2);
		testarr.add(6);
		testarr.add(10);
		testarr.add(14);
		testarr.add(1);
		testarr.add(3);
		testarr.add(5);
		testarr.add(7);
		testarr.add(9);
		testarr.add(11);
		testarr.add(13);
		testarr.add(15);

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);
		test.add(16);
		
		assertTrue(test.containsAll(testarr));
		
		testarr.add(17);
		
		assertFalse(test.containsAll(testarr));
	}
	@Test
	void testFirst() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> test2 = new BinarySearchTree<Integer>();


		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);

		assertEquals(1, test.first());
		assertThrows(NoSuchElementException.class, () -> test2.first());	
	}

	@Test
	void testIsEmpty() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();

		assertTrue(test.isEmpty());
		
		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);

		assertFalse(test.isEmpty());
	}

	@Test
	void testLast() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> test2 = new BinarySearchTree<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);

		assertEquals(15, test.last());
		assertThrows(NoSuchElementException.class, () -> test2.last());	
		
	}
	
	@Test
	void testRemove() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		ArrayList<Integer> testarr = new ArrayList<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		
		testarr.add(2);
		testarr.add(8);
		testarr.add(10);
		testarr.add(12);
		testarr.add(14);
		
		assertTrue(test.remove(6));
		assertTrue(test.remove(4));
		assertFalse(test.remove(13));

		assertFalse(test.contains(6));
		assertFalse(test.contains(4));
		
		assertEquals(testarr, test.toArrayList());
	}

	@Test
	void testRemoveAll() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();

		ArrayList<Integer> testarr = new ArrayList<Integer>();
		ArrayList<Integer> testarr2 = new ArrayList<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);

		testarr.add(2);
		testarr.add(4);
		testarr.add(6);
		testarr.add(8);
		testarr.add(10);
		testarr.add(12);
		testarr.add(14);

		testarr2.add(1);
		testarr2.add(3);
		testarr2.add(5);
		testarr2.add(7);
		testarr2.add(9);
		testarr2.add(11);
		testarr2.add(13);
		testarr2.add(15);

		assertTrue(test.removeAll(testarr2));
		assertFalse(test.containsAll(testarr2));
		assertEquals(testarr, test.toArrayList());
	}

	@Test
	void testSize() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);

		assertEquals(15, test.size());
	}
	
	@Test
	void testToArray() {
		BinarySearchTree<Integer> test = new BinarySearchTree<Integer>();
		ArrayList<Integer> testarr = new ArrayList<Integer>();

		test.add(8);
		test.add(4);
		test.add(12);
		test.add(2);
		test.add(6);
		test.add(10);
		test.add(14);
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		test.add(13);
		test.add(15);
		
		testarr.add(1);
		testarr.add(2);
		testarr.add(3);
		testarr.add(4);
		testarr.add(5);
		testarr.add(6);
		testarr.add(7);
		testarr.add(8);
		testarr.add(9);
		testarr.add(10);
		testarr.add(11);
		testarr.add(12);
		testarr.add(13);
		testarr.add(14);
		testarr.add(15);
		
		assertEquals(testarr, test.toArrayList());
	}

}
