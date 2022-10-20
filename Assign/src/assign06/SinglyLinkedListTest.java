package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

	@Test
	void testAdd() {
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		
		String[] testArr = new String[] { "word", "pizza","panic"};
		
		assertEquals(Arrays.toString(test.toArray()), Arrays.toString(testArr));
	}
	
	@Test
	void testAddMany() {
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		String[] testArr = new String[] { "word", "pizza","panic", "disaster", "emotion", "chaos"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
	}
	
	@Test
	void testInsert() {
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		
		test.insert(1, "mousetrap");
		
		String[] testArr = new String[] {"word", "mousetrap", "pizza", "panic"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
	}
	
	@Test
	void testInsertBeginning() {
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		
		test.insert(0, "mousetrap");
		
		String[] testArr = new String[] {"mousetrap", "word", "pizza", "panic"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
	}
	
	@Test
	void testInsertEnd() {
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		
		test.insert(3, "mousetrap");
		
		String[] testArr = new String[] {"word", "pizza", "panic", "mousetrap"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
	}
	
	@Test
	void testInsertFail() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		
		assertThrows(IndexOutOfBoundsException.class, () -> test.insert(4, "Word"));
		assertThrows(IndexOutOfBoundsException.class, () -> test.insert(-1, "Word"));
		
	}
	
	@Test
	void testInsertFirst() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		
		test.insertFirst("mousetrap");
		
		String[] testArr = new String[] {"mousetrap", "word", "pizza", "panic"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
		
	}
	
	@Test
	void testGet() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertEquals("word", test.get(0));
		assertEquals("pizza", test.get(1));
		assertEquals("panic", test.get(2));
		assertEquals("disaster", test.get(3));
		assertEquals("emotion", test.get(4));
		assertEquals("chaos", test.get(5));
		
	}
	
	@Test
	void testGetOutOfBounds() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertThrows(IndexOutOfBoundsException.class, () -> test.get(6));
		
	}
	

	@Test
	void testGetFirst() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertEquals("word", test.getFirst());
		
	}
	
	@Test
	void testGetFirstNone() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		
		assertThrows(NoSuchElementException.class, () -> test.getFirst());

	}
	
	@Test
	void testDeleteFirst() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertEquals("word", test.getFirst());
		
		assertEquals("word", test.deleteFirst());
		
		assertEquals("pizza", test.getFirst());
		
	}
	
	@Test
	void testDeleteFirstNone() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		
		assertThrows(NoSuchElementException.class, () -> test.deleteFirst());

	}
	
	@Test
	void testDelete() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertEquals("disaster", test.delete(3));
		
		String[] testArr = new String[] { "word", "pizza", "panic", "emotion", "chaos"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
		
	}
	
	@Test
	void testDeleteBeginning() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		
		assertEquals("word", test.delete(0));
		
		String[] testArr = new String[] {"pizza", "panic", "disaster", "emotion", "chaos"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
		
	}
	
	@Test
	void testDeleteEnd() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		
		assertEquals("chaos", test.delete(5));
		
		String[] testArr = new String[] {"word", "pizza", "panic", "disaster", "emotion"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
		
	}
	
	@Test
	void testDeleteFail() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertThrows(IndexOutOfBoundsException.class, () -> test.delete(6));
		
	}
	
	@Test
	void testIndexOf() {
		
		SinglyLinkedList test = new SinglyLinkedList();
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		assertEquals(0, test.indexOf("word"));
		assertEquals(5, test.indexOf("chaos"));
		assertEquals(-1, test.indexOf("distressed"));
		
	}
	
	@Test
	void testClear() {
		SinglyLinkedList test = new SinglyLinkedList();
		
		assertEquals(0, test.size());
		
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		String[] testArr = new String[] {"word", "pizza", "panic", "disaster", "emotion", "chaos"};
		String[] emptyArr = new String[] {};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
		
		test.clear();
		
		assertEquals(Arrays.toString(emptyArr), Arrays.toString(test.toArray()));
	}
	
	@Test
	void testToArray() {
		SinglyLinkedList test = new SinglyLinkedList();
		
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		
		String[] testArr = new String[] {"word", "pizza", "panic", "disaster", "emotion", "chaos"};
		
		assertEquals(Arrays.toString(testArr), Arrays.toString(test.toArray()));
	}
	@Test
	void testSize() {
		SinglyLinkedList test = new SinglyLinkedList();
		
		assertEquals(0, test.size());
		
		test.add("word");
		test.add("pizza");
		test.add("panic");
		test.add("disaster");
		test.add("emotion");
		test.add("chaos");
		assertEquals(6, test.size());
		
		test.add("distress");	
		assertEquals(7, test.size());
		
		test.delete(0);
		assertEquals(6, test.size());
		
		test.deleteFirst();
		assertEquals(5, test.size());
		
		test.insert(0, "mother");
		assertEquals(6, test.size());
		
		test.insertFirst("worthy");
		assertEquals(7, test.size());
		
		test.clear();
		assertEquals(0, test.size());
	}
	
	
	

}
