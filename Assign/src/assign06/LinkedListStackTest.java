package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {

	@Test
	void testPush() {
		LinkedListStack test = new LinkedListStack();
		test.push("word");
		test.push("pizza");
		test.push("panic");
		
		String[] testArr = new String[] { "panic", "pizza","word"};
		Object[] testToArr = new String[3];
		
		testToArr[0] = test.pop();
		testToArr[1] = test.pop();
		testToArr[2] = test.pop();
		
		assertEquals(Arrays.toString(testToArr), Arrays.toString(testArr));
	}

	@Test
	void testPushMany() {
		LinkedListStack test = new LinkedListStack();
		test.push("word");
		test.push("pizza");
		test.push("panic");
		test.push("disaster");
		test.push("emotion");
		test.push("chaos");
		
		String[] testArr = new String[] { "chaos", "emotion","disaster", "panic", "pizza", "word"};
		Object[] testToArr = new String[6];
		
		testToArr[0] = test.pop();
		testToArr[1] = test.pop();
		testToArr[2] = test.pop();
		testToArr[3] = test.pop();
		testToArr[4] = test.pop();
		testToArr[5] = test.pop();
		
		assertEquals(Arrays.toString(testToArr), Arrays.toString(testArr));	
		
	}
	
	
	@Test
	void testPeek() {
		
		LinkedListStack test = new LinkedListStack();
		test.push("word");
		assertEquals("word", test.peek());
		
		test.push("pizza");
		assertEquals("pizza", test.peek());

		test.push("panic");
		assertEquals("panic", test.peek());

		test.push("disaster");
		assertEquals("disaster", test.peek());

		test.push("emotion");
		assertEquals("emotion", test.peek());

		test.push("chaos");
		assertEquals("chaos", test.peek());
		
	}
	
	@Test
	void testPeekNone() {
		
		LinkedListStack test = new LinkedListStack();
		
		assertThrows(NoSuchElementException.class, () -> test.peek());

	}
	
	@Test
	void testPopNone() {
		
		LinkedListStack test = new LinkedListStack();
		
		assertThrows(NoSuchElementException.class, () -> test.pop());

	}
	
	@Test
	void testPop() {
		
		LinkedListStack test = new LinkedListStack();
		test.push("word");
		test.push("pizza");
		test.push("panic");
		test.push("disaster");
		test.push("emotion");
		test.push("chaos");
		
		assertEquals("chaos", test.pop());
		assertEquals("emotion", test.pop());
		assertEquals("disaster", test.pop());
		assertEquals("panic", test.pop());
		assertEquals("pizza", test.pop());
		assertEquals("word", test.pop());
		
		assertThrows(NoSuchElementException.class, () -> test.pop());
		
	}
	
	@Test
	void testIsEmpty() {
		LinkedListStack test = new LinkedListStack();
		
		assertEquals(0, test.size());
		
		assertTrue(test.isEmpty());
		
		test.push("stiff");
		
		assertFalse(test.isEmpty());
	}
	
	@Test
	void testSize() {
		LinkedListStack test = new LinkedListStack();
		
		assertEquals(0, test.size());
		
		test.push("word");
		test.push("pizza");
		test.push("panic");
		test.push("disaster");
		test.push("emotion");
		test.push("chaos");
		assertEquals(6, test.size());
		
		test.push("distress");	
		assertEquals(7, test.size());
		
		test.pop();
		assertEquals(6, test.size());
		
		test.clear();
		assertEquals(0, test.size());
	}

	
	@Test
	void testClear() {
		LinkedListStack test = new LinkedListStack();
		
		assertEquals(0, test.size());
		
		test.push("word");
		test.push("pizza");
		test.push("panic");
		test.push("disaster");
		test.push("emotion");
		test.push("chaos");
		
		assertEquals(6, test.size());
		
		test.clear();
		
		assertTrue(test.isEmpty());
	}


}
