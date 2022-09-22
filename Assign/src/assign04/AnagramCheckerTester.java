package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
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
	
	@Test
	public void testAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("Asdfer", "sdAFer"));
		assertFalse(AnagramChecker.areAnagrams("Not", "Ana"));
		assertTrue(AnagramChecker.areAnagrams("b", "b"));
	}
	
	@Test
	public void testLargeAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("basiparachromatin", "marsipobranchiata"));
		assertTrue(AnagramChecker.areAnagrams("HydRoxyDesoXycorticosterone", "hydroxydEoxycortIcoSteRones"));
	}
	
	@Test
	public void testGetLargestAnagramGroupSort() {
		String[] stringArray = new String[] {"Drow", "dRagon", "moon", "darNgo", "Dragno", "dragon", "Andrgo", "gradno", 
				"gradon", "ragnod" ,"luna", "nula", "December", "implementGram", "unal", "impgramementl", "emberdec", 
				"impgramlement", "gramimplement", "luna", "moon", "woRd"};
		String[] dragonArray = new String[] {"dRagon", "darNgo", "Dragno", "dragon", "Andrgo", "gradno", "gradon", "ragnod"};
		
		assertEquals(Arrays.toString(dragonArray), Arrays.toString(AnagramChecker.getLargestAnagramGroup(stringArray)));
	}
	
	@Test
	public void testGetLargestAnagramGroupSortText() {
		String[] stringArray = new String[] {"carets", "Caters", "caster", "crates", "Reacts", "recast", "traces"};
		
		try {
			assertEquals(Arrays.toString(stringArray), Arrays.toString(AnagramChecker.getLargestAnagramGroup("sample_word_list.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
