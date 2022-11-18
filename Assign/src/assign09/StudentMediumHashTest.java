package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMediumHashTest {


	@Test
	void testMediumHash() {
		HashTable<StudentMediumHash, String> test = new HashTable<StudentMediumHash, String>();

		StudentMediumHash a1 = new StudentMediumHash(10020,"alan","turing");
		StudentMediumHash a2 = new StudentMediumHash(10240,"victor","durant");
		
		assertEquals(10, a1.hashCode());
		assertEquals(12, a2.hashCode());
		
		assertNull(test.put(a1, "test"));
		assertNull(test.put(a2, "who"));

		assertEquals("test", test.put(a1, "walk"));
		assertEquals("who", test.put(a2, "palker"));
		
	}

}
