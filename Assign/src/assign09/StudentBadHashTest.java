package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentBadHashTest {

	@Test
	void testBadHash() {
		HashTable<StudentBadHash, String> test = new HashTable<StudentBadHash, String>();

		StudentBadHash a1 = new StudentBadHash(10020,"alan","turing");
		StudentBadHash a2 = new StudentBadHash(10240,"victor","durant");
		
		assertEquals(1, a1.hashCode());
		assertEquals(1, a2.hashCode());
		
		assertNull(test.put(a1, "test"));
		assertNull(test.put(a2, "who"));

		assertEquals("test", test.put(a1, "walk"));
		assertEquals("who", test.put(a2, "palker"));
		
	}
	
	

}
