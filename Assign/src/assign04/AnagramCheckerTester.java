package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assign04.AnagramChecker.StringComparator;

public class AnagramCheckerTester {

	@Test
	public void testSmallSort() {
		assertEquals("an", AnagramChecker.sort("an"));
		assertEquals("an", AnagramChecker.sort("na"));
	}
	
	@Test
	public void testModerateSort() {
		assertEquals("abcdefg", AnagramChecker.sort("abcdefg"));
		assertEquals("abcdefg", AnagramChecker.sort("bcadgfe"));
	}
	
	@Test
	public void testLargeSort() {
		assertEquals("aabbcdeffghkkmnppxxz", AnagramChecker.sort("aabbcdeffghkkmnppxxz"));
		assertEquals("aabbcdeffghkkmnppxxz", AnagramChecker.sort("bacghkmnkpxzpxafbdef"));
	}
	
	@Test
	public void testCapitals() {
		assertEquals("abcdefgh",AnagramChecker.sort("ABCDEFGH"));
		assertEquals("abcdefgh",AnagramChecker.sort("CbDEHgfA"));
	}
	
	@Test
	public void testInsertionSort() {
		String[] stringArray = new String[] {"word", "luna", "luna", "december", "implementgram", "implementgram"};
		String[] sortedArray = new String[] {"december", "implementgram", "implementgram", "luna", "luna", "word"};
		
		StringComparator stringcmp = new StringComparator();
		
		AnagramChecker.insertionSort(stringArray, stringcmp);
		
		assertEquals(Arrays.toString(sortedArray), Arrays.toString(stringArray));
	}
	
}
