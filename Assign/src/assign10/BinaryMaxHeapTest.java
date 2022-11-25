package assign10;

import static org.junit.jupiter.api.Assertions.*;

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

}
