package assign07;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SpellCheckerTest {

	@Test
	void testAddToDic() {
		SpellChecker test = new SpellChecker();
		ArrayList<String> misspelledWords = new ArrayList<String>();
		ArrayList<String> emptyList = new ArrayList<String>();
		File doc = new File("src/assign07/Test.txt");
		
		test.addToDictionary("word");
		test.addToDictionary("weep");
		test.addToDictionary("cough");
		
		misspelledWords = (ArrayList<String>) test.spellCheck(doc);
		
		assertEquals(emptyList, misspelledWords);
	}
	
	@Test
	void testRemoveFromDic() {
		SpellChecker test = new SpellChecker();
		ArrayList<String> misspelledWords = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		File doc = new File("src/assign07/Test.txt");
		
		list.add("cough");
		
		test.addToDictionary("word");
		test.addToDictionary("weep");
		test.addToDictionary("cough");
		test.removeFromDictionary("cough");
		
		misspelledWords = (ArrayList<String>) test.spellCheck(doc);
		
		assertEquals(list, misspelledWords);
	}
	
	@Test
	void testSpellCheck() {
		SpellChecker mySC = new SpellChecker(new File("src/assign07/TestOne.txt"));
		ArrayList<String> misspelledWords1 = new ArrayList<String>();
		ArrayList<String> expectedMissing1 = new ArrayList<String>();

		
		File doc1 = new File("src/assign07/TxT.txt");
		misspelledWords1 = (ArrayList<String>) mySC.spellCheck(doc1);

		expectedMissing1.add("hoping");
		expectedMissing1.add("that");
		expectedMissing1.add("at");
		expectedMissing1.add("least");
		expectedMissing1.add("of");
		expectedMissing1.add("these");
		expectedMissing1.add("words");
		expectedMissing1.add("included");
	
		assertEquals(expectedMissing1, misspelledWords1);
		
		ArrayList<String> misspelledWords2 = new ArrayList<String>();
		ArrayList<String> expectedMissing2 = new ArrayList<String>();

		
		File doc2 = new File("src/assign07/OtherFile.txt");
		misspelledWords2 = (ArrayList<String>) mySC.spellCheck(doc2);
		
		expectedMissing2.add("words");
		expectedMissing2.add("an");
		expectedMissing2.add("apostrophe");
		expectedMissing2.add("have");
		expectedMissing2.add("break");
		expectedMissing2.add("this");
		expectedMissing2.add("program");
		expectedMissing2.add("i");
		expectedMissing2.add("noticed");
		
		assertEquals(expectedMissing2, misspelledWords2);
	}
}
