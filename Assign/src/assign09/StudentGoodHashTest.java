package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentGoodHashTest {

	@Test
	void testGoodHash() {
		HashTable<StudentGoodHash, String> test = new HashTable<StudentGoodHash, String>();

		StudentGoodHash a1 = new StudentGoodHash(10020,"alan","turing");
		StudentGoodHash a2 = new StudentGoodHash(10240,"victor","durant");
		
		assertEquals(-767245162, a1.hashCode());
		assertEquals(166554958, a2.hashCode());
		
		assertNull(test.put(a1, "test"));
		assertNull(test.put(a2, "who"));

		assertEquals("test", test.put(a1, "walk"));
		assertEquals("who", test.put(a2, "palker"));
		
	}

}
