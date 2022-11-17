package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void testPut() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		assertNull(test.put(1, "worth"));
		assertEquals(1, test.size());
		assertNull(test.put(2, "word"));
		assertEquals(2, test.size());
		assertNull(test.put(3, "banana"));
		assertEquals(3, test.size());
		assertNull(test.put(4, "sleep"));
		assertEquals(4, test.size());
		assertNull(test.put(5, "asian"));
		assertEquals(5, test.size());
		assertNull(test.put(6, "hispanic"));
		assertEquals(6, test.size());
		assertNull(test.put(7, "blossom"));
		assertEquals(7, test.size());
		assertNull(test.put(8, "vega"));
		assertEquals(8, test.size());
		assertNull(test.put(9, "betelgeuse"));
		assertEquals(9, test.size());

		assertEquals("worth", test.put(1, "night"));
		assertEquals("night", test.put(1, "walk"));
		assertEquals("vega", test.put(8, "nyx"));

		assertNull(test.put(10, "october"));

	}

	@Test
	void testPutRehash() {
		HashTable<Integer, String> test = new HashTable<Integer, String>();

		assertNull(test.put(1, "worth"));
		assertNull(test.put(2, "word"));
		assertNull(test.put(3, "banana"));
		assertNull(test.put(4, "sleep"));
		assertNull(test.put(5, "asian"));
		assertNull(test.put(6, "hispanic"));
		assertNull(test.put(7, "blossom"));
		assertNull(test.put(8, "vega"));
		assertNull(test.put(9, "betelgeuse"));
		assertNull(test.put(10, "october"));

		assertEquals(10, test.size());
		assertEquals(1, test.getCapacity());

		assertNull(test.put(11, "water"));

		assertEquals(11, test.size());
		assertEquals(2, test.getCapacity());

	}

	@Test
	void testList() {
		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		List<MapEntry<Integer, String>> testEntries = test.entries();

		List<MapEntry<Integer, String>> compare = new ArrayList<MapEntry<Integer, String>>();

		compare.add(new MapEntry<Integer, String>(1, "worth"));
		compare.add(new MapEntry<Integer, String>(2, "word"));
		compare.add(new MapEntry<Integer, String>(3, "banana"));
		compare.add(new MapEntry<Integer, String>(4, "sleep"));
		compare.add(new MapEntry<Integer, String>(5, "asian"));
		compare.add(new MapEntry<Integer, String>(6, "hispanic"));
		compare.add(new MapEntry<Integer, String>(7, "blossom"));
		compare.add(new MapEntry<Integer, String>(8, "vega"));
		compare.add(new MapEntry<Integer, String>(9, "betelgeuse"));
		compare.add(new MapEntry<Integer, String>(10, "october"));

		assertEquals(compare, testEntries);

	}

	@Test
	void testClear() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		assertEquals("worth", test.put(1, "test"));

		assertEquals(10, test.size());

		test.clear();

		assertEquals(0, test.size());

		assertNull(test.put(1, "worth"));
		assertEquals(1, test.size());

	}

	@Test
	void testContainsKey() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		assertTrue(test.containsKey(1));
		assertTrue(test.containsKey(2));
		assertTrue(test.containsKey(10));
		assertFalse(test.containsKey(11));

		test.put(11, "wanderlust");
		assertTrue(test.containsKey(11));
	}

	@Test
	void testContainsValue() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		assertTrue(test.containsValue("worth"));
		assertTrue(test.containsValue("word"));
		assertTrue(test.containsValue("vega"));

		assertFalse(test.containsValue("whisper"));

		test.put(10, "whisper");

		assertFalse(test.containsValue("october"));
		assertTrue(test.containsValue("whisper"));

	}

	@Test
	void testGet() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		assertEquals("worth", test.get(1));
		assertEquals("banana", test.get(3));

		test.put(1, "bark");
		assertEquals("bark", test.get(1));

	}

	@Test
	void testIsEmpty() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		assertTrue(test.isEmpty());

		test.put(1, "worth");

		assertFalse(test.isEmpty());

		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		test.put(11, "focus");

		test.clear();

		assertTrue(test.isEmpty());
	}

	@Test
	void testRemove() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		assertNull(test.remove(11));
		assertEquals("worth", test.remove(1));
		assertNull(test.remove(1));

	}

	@Test
	void testSize() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		assertNull(test.put(1, "worth"));
		assertEquals(1, test.size());
		assertNull(test.put(2, "word"));
		assertEquals(2, test.size());
		assertNull(test.put(3, "banana"));
		assertEquals(3, test.size());
		assertNull(test.put(4, "sleep"));
		assertEquals(4, test.size());
		assertNull(test.put(5, "asian"));
		assertEquals(5, test.size());
		assertNull(test.put(6, "hispanic"));
		assertEquals(6, test.size());
		assertNull(test.put(7, "blossom"));
		assertEquals(7, test.size());
		assertNull(test.put(8, "vega"));
		assertEquals(8, test.size());
		assertNull(test.put(9, "betelgeuse"));
		assertEquals(9, test.size());
	}

	@Test
	void getCapacity() {

		HashTable<Integer, String> test = new HashTable<Integer, String>();

		test.put(1, "worth");
		test.put(2, "word");
		test.put(3, "banana");
		test.put(4, "sleep");
		test.put(5, "asian");
		test.put(6, "hispanic");
		test.put(7, "blossom");
		test.put(8, "vega");
		test.put(9, "betelgeuse");
		test.put(10, "october");

		assertEquals(1, test.getCapacity());

		test.put(11, "walk");

		assertEquals(2, test.getCapacity());
	}
}
