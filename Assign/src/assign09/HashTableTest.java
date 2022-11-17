package assign09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void testPut() {
		
		HashTable<Integer, String> test = new HashTable<Integer, String>();
		
		assertNull(test.put(1, "worth"));
		assertNull(test.put(2, "word"));
		assertNull(test.put(3,"banana"));
		assertNull(test.put(4,"sleep"));
		assertNull(test.put(5,"asian"));
		assertNull(test.put(6,"hispanic"));
		assertNull(test.put(7, "blossom"));
		assertNull(test.put(8, "vega"));
		assertNull(test.put(9,"betelgeuse"));
		
		assertEquals(9, test.size());
		
		assertEquals("worth", test.put(1, "night"));
		assertEquals("night", test.put(1, "walk"));
		assertEquals("vega", test.put(8, "nyx"));
		
		assertNull(test.put(10,"october"));
		
		assertEquals(10, test.size());
	}
	
	@Test
	void testPutRehash() {
		HashTable<Integer, String> test = new HashTable<Integer, String>();

		assertNull(test.put(1, "worth"));
		assertNull(test.put(2, "word"));
		assertNull(test.put(3,"banana"));
		assertNull(test.put(4,"sleep"));
		assertNull(test.put(5,"asian"));
		assertNull(test.put(6,"hispanic"));
		assertNull(test.put(7, "blossom"));
		assertNull(test.put(8, "vega"));
		assertNull(test.put(9,"betelgeuse"));
		assertNull(test.put(10,"october"));
		
		assertEquals(10, test.size());
		assertEquals(1, test.getCapacity());
		
		assertNull(test.put(11, "water"));
		
		assertEquals(11, test.size());
		assertEquals(2, test.getCapacity());

		
	}
}
