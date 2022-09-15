package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTest {

	@Test
	void testAdd() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		
		assertEquals(0, arc1.size());
		arc1.add("Word");
		assertEquals("Word", arc1.get(0));
		assertEquals(1, arc1.size());
		
	}
	
	@Test
	void testRemove() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		
		assertEquals(0, arc1.size());
		arc1.add("Word");
		assertEquals("Word", arc1.get(0));
		assertEquals(1, arc1.size());
		
		arc1.remove("Word");
		assertEquals(0, arc1.size());
		assertEquals(null, arc1.get(0));
		
		arc2.add("a");
		arc2.add("b");
		arc2.add("c");
		arc2.add("d");
		
		assertEquals("a", arc2.get(0));
		assertEquals("b", arc2.get(1));
		assertEquals("c", arc2.get(2));
		assertEquals("d", arc2.get(3));
		
		arc2.remove("b");
		
		assertEquals("a", arc2.get(0));
		assertEquals("c", arc2.get(1));
		assertEquals("d", arc2.get(2));
		
	}
	
	@Test
	void testContains() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		
		assertEquals(0, arc1.size());
		arc1.add("Word");
		arc1.add("Worth");
		arc1.add("Rolo");
		
		assertTrue(arc1.contains("Word"));
		assertFalse(arc1.contains("Pistachio"));
		
	}
	
	@Test
	void testSize() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		
		assertEquals(0, arc1.size());
		arc1.add("Word");
		arc1.add("Worth");
		arc1.add("Rolo");
		
		assertEquals(3, arc1.size());
		
		arc1.add("Walk");
		
		assertEquals(4, arc1.size());
		
	}
	
	@Test
	void testContainsAll() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		
		arc2.add("a");
		arc2.add("b");
		arc2.add("c");
		arc2.add("d");
		arc2.add("e");
		
		assertTrue(arc1.containsAll(arc2));
		
		arc2.add("f");
		
		assertFalse(arc1.containsAll(arc2));
		assertTrue(arc2.containsAll(arc1));
		
	}
	
	@Test
	void testAddAll() {
		
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		
		arc2.add("a");
		arc2.add("b");
		arc2.add("d");
		arc2.add("e");
		arc2.add("f");
		
		assertEquals(5, arc1.size());
		assertEquals("a", arc1.get(0));
		assertEquals("b", arc1.get(1));
		assertEquals("c", arc1.get(2));
		assertEquals("d", arc1.get(3));
		assertEquals("e", arc1.get(4));
		assertEquals(null, arc1.get(5));
		
		assertTrue(arc1.addAll(arc2));
		
		assertEquals("a", arc1.get(0));
		assertEquals("b", arc1.get(1));
		assertEquals("c", arc1.get(2));
		assertEquals("d", arc1.get(3));
		assertEquals("e", arc1.get(4));
		assertEquals("f", arc1.get(5));
	}
	
	@Test
	void testRemoveAll() {
		
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		ArrayCollection<String> arc3 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		arc1.add("f");
		arc1.add("g");
		arc1.add("h");
		arc1.add("i");
		
		arc2.add("a");
		arc2.add("b");
		arc2.add("d");
		arc2.add("e");
		arc2.add("f");
		
		arc3.add("j");
		arc3.add("k");
		
		assertTrue(arc1.removeAll(arc2));
		
		assertEquals("c", arc1.get(0));
		assertEquals("g", arc1.get(1));
		assertEquals("h", arc1.get(2));
		assertEquals("i", arc1.get(3));
		
		assertEquals(4, arc1.size());
		
		assertFalse(arc1.removeAll(arc3));
	}
	
	@Test
	void testGrow() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		arc1.add("f");
		arc1.add("g");
		arc1.add("h");
		arc1.add("i");
		arc1.add("j");
		assertEquals(10, arc1.size());
		
		arc1.add("k");
		assertEquals(11, arc1.size());
		
		assertEquals("a", arc1.get(0));
		assertEquals("b", arc1.get(1));
		assertEquals("c", arc1.get(2));
		assertEquals("d", arc1.get(3));
		assertEquals("e", arc1.get(4));
		assertEquals("f", arc1.get(5));
		assertEquals("g", arc1.get(6));
		assertEquals("h", arc1.get(7));
		assertEquals("i", arc1.get(8));
		assertEquals("j", arc1.get(9));
		assertEquals("k", arc1.get(10));
		assertEquals(null, arc1.get(11));
		assertEquals(null, arc1.get(12));
		assertEquals(null, arc1.get(13));
		assertEquals(null, arc1.get(14));
		assertEquals(null, arc1.get(15));
	}
	
	@Test
	void testClear() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		arc1.add("f");
		arc1.add("g");
		arc1.add("h");
		arc1.add("i");
		arc1.add("j");
		
		arc1.clear();
		
		assertEquals(null, arc1.get(0));
		assertEquals(0, arc1.size());

	}
	
	@Test
	void testIsEmpty() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		arc1.add("f");
		arc1.add("g");
		arc1.add("h");
		arc1.add("i");
		arc1.add("j");
		
		assertFalse(arc1.isEmpty());
		assertTrue(arc2.isEmpty());
	}
	
	@Test
	void testRetainAll() {
		ArrayCollection<String> arc1 = new ArrayCollection<String>();
		ArrayCollection<String> arc2 = new ArrayCollection<String>();
		ArrayCollection<String> arc3 = new ArrayCollection<String>();
		ArrayCollection<String> arc4 = new ArrayCollection<String>();
		
		arc1.add("a");
		arc1.add("b");
		arc1.add("c");
		arc1.add("d");
		arc1.add("e");
		arc1.add("f");
		arc1.add("g");
		arc1.add("h");
		arc1.add("i");
		
		arc2.add("a");
		arc2.add("b");
		arc2.add("k");
		arc2.add("l");
		
		arc3.add("l");
		
		assertFalse(arc1.retainAll(arc4));
		assertFalse(arc1.retainAll(arc3));
		assertTrue(arc1.retainAll(arc2));
		assertFalse(arc3.retainAll(arc4));
		assertTrue(arc3.retainAll(arc2));
		
		assertEquals("a", arc1.get(0));
		assertEquals("b", arc1.get(1));
		
		assertNull(arc1.get(2));
	}
	
	@Test
	void testToSortedList() {
		ArrayCollection<Integer> arc1 = new ArrayCollection<Integer>();
		ArrayCollection<Integer> arc2 = new ArrayCollection<Integer>();
		ArrayCollection<Integer> arc3 = new ArrayCollection<Integer>();
		ArrayList<Integer> arl4 = new ArrayList<Integer>();
		ArrayList<Integer> arl5 = new ArrayList<Integer>();
		
		arc1.add(1);
		arc1.add(2);
		arc1.add(3);
		arc1.add(4);
		arc1.add(5);
		arc1.add(6);
		arc1.add(7);
		arc1.add(8);
		
		arc2.add(7);
		arc2.add(4);
		arc2.add(1);
		arc2.add(3);
		arc2.add(2);
		arc2.add(5);
		arc2.add(8);
		arc2.add(6);
		
		arc3.add(1);
		arc3.add(5);
		arc3.add(2);
		
		
		IntegerComparator intcmp = new IntegerComparator();
		arl4 = arc2.toSortedList(intcmp);
		arl5 = arc3.toSortedList(intcmp);
		
		assertEquals(arc1.get(0), arl4.get(0));
		assertEquals(arc1.get(1), arl4.get(1));
		assertEquals(arc1.get(2), arl4.get(2));
		assertEquals(arc1.get(3), arl4.get(3));
		assertEquals(arc1.get(4), arl4.get(4));
		assertEquals(arc1.get(5), arl4.get(5));
		assertEquals(arc1.get(6), arl4.get(6));
		assertEquals(arc1.get(7), arl4.get(7));
		
		
		
	}
	
	@Test
	void TestBinarySearch() {
		ArrayCollection<Integer> arc1 = new ArrayCollection<Integer>();
		ArrayList<Integer> arc2 = new ArrayList<Integer>();
		IntegerComparator intcmp = new IntegerComparator();
		
		arc1.add(1);
		arc1.add(7);
		arc1.add(3);
		arc1.add(8);
		arc1.add(5);
		arc1.add(6);
		
		arc2 = arc1.toSortedList(intcmp);
		
		assertTrue(SearchUtil.binarySearch(arc2, 1, intcmp));
		assertTrue(SearchUtil.binarySearch(arc2, 8, intcmp));
		assertFalse(SearchUtil.binarySearch(arc2, 4, intcmp));
		assertFalse(SearchUtil.binarySearch(arc2, 2, intcmp));
	}
}
