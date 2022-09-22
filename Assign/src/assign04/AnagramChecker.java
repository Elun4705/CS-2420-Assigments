package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

// Written by Andy Huo and Emmanuel Luna

public class AnagramChecker {	

	/**
	 * Returns the input word in lowercase lexicographical order
	 * 
	 * @param input The word being sorted
	 * @return A lowercase lexicographically sorted version of the input word
	 */
	public static String sort(String input) {
		
		// Creates a new word of the input to return-- this way, there is no
		// risk of affecting the input word itself.
		String word = input;
		
		// Turns the copied input word into an array of characters
		char[] list = word.toCharArray();
		
		// A basic for-while function designed to sort a given character array into lexicographical
		// order
        for (int i = 1; i < list.length; ++i) {
            char item = list[i];
            int j = i - 1;
            while (j >= 0 && Character.compare(list[j], item) > 0) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = item;
        }
        
        // Turns the newly-sorted character list back into a string, then returns it
        String sortedWord = String.valueOf(list);
        return sortedWord;
		
	}
	
	
	/**
	 * A generic insertion sort method which uses a comparator to help it sort an input list
	 * 
	 * @param <T> Represents Generic
	 * @param list The input list of objects
	 * @param cmp A custom-made input comparator
	 */
	public static <T> void insertionSort(T[] list, Comparator<? super T> cmp) {
		
		// A basic for/while loop setup which works with the comparator to sort the input list
		for (int i = 1; i < list.length; ++i) {
			T item = list[i];
			int j = i - 1;
			while (j >= 0 && (cmp.compare(list[j], item) > 0)) {
				list[j + 1] = list[j];
				j = j - 1;
			}
			list[j + 1] = item;
		}
		
	}
	

	/**
	 * Checks to see if a pair of input words are Anagrams or not
	 * 
	 * @param word1 the first input word
	 * @param word2 the second input word
	 * @return True if the two words are anagrams, false otherwise
	 */
	public static boolean areAnagrams(String word1, String word2) {
		
		// An initial test to see if two words are of different length.  Two words of different
		// length, by definition, cannot be anagrams.  This is likely unnecessary, but we hope that it
		// may save some time
		if (word1.length() != word2.length())
			return false;
		
		// Creates new strings which are lowercase versions of the inputs for comparison purposes.
		// This way, there's no risk of accidentally affecting the input word itself.
		String sortedWord1 = sort(word1.toLowerCase());
		String sortedWord2 = sort(word2.toLowerCase());
		
		// Returns true if the sorted words are equal, otherwise, returns false.
		if(sortedWord1.compareTo(sortedWord2) == 0) {
			return true;
		}
		return false;		
	}
	
	/**
	 * A method which takes an array of Strings and returns an array of the largest
	 * anagram group
	 * 
	 * @param stringArray An input array full of words to sort
	 * @return An array containing the largest group of anagrams
	 */
	public static String[] getLargestAnagramGroup(String[] stringArray) {
		
		// Create a new string comparator object and string array of the same length as the input
		// for use in the method
		StringComparator stringcmp = new StringComparator();
		String[] sortedArray = new String[stringArray.length];
		
		// Sorts all of the words in the input array into lexicographical order and adds them
		// to the new array
		for (int i = 0; i < stringArray.length; i++) {
			String toSort = stringArray[i];
			sortedArray[i] = sort(toSort);
		}
		
		// Sorts the newly sorted words into lexicographical order
		insertionSort(sortedArray, stringcmp);
		
		// Initializes a few values to keep track of anagram group sizes
		int highestCount = 0;
		int currentCount = 0;
		String anaHigh = null;
		
		// Compare each word with every word in the array (including itself) and record
		// whether or not it has any anagrams.  Add one to the current count for each anagram
		// found in the array.  Once each word has been compared to every other word, if its			
		// anagram count is higher than the current highest count, the highestCOunt and anaHigh 
		// values are adjusted as neccessary.  Current count resets after each word is compared 
		for (int j = 0; j < sortedArray.length; j++) {
			String compareWord = sortedArray[j];
			for(int k = 0; k < sortedArray.length; k++) {
				if(areAnagrams(compareWord, sortedArray[k]))
					 currentCount++;
			}
			if (currentCount > highestCount) {
				highestCount = currentCount;
				anaHigh = sortedArray[j];
			}
			
			currentCount = 0;
		}
		
		// Create a new empty array with length zero
		String[] emptyArray = new String[0];
		
		// A failsafe which activates if there are no anagram pairs in the input array,
		// returning an empty list.
		if (highestCount == 1) {
			return emptyArray;
		}
		
		// Creates a new Array in order to contain all of the largest group anagrams, and creates
		// a virtual index size to help keep track of where it is.
		String[] highestCountArray = new String[highestCount];
		int highestCountArrayIndex = 0;
		
		
		// Adds all of the words from the initial input list which are anagrams to the
		// value anaHigh to the new return list
		for (int l = 0; l < stringArray.length; l++) {
			if(areAnagrams(anaHigh, stringArray[l])) {
				highestCountArray[highestCountArrayIndex] = stringArray[l];
				highestCountArrayIndex++;
			}
		}
		
		// Returns an array of the largest group of anagrams
		return highestCountArray;

	}
	
	/**
	 * Scans the words in a file, searches for any anagram pairs, then returns an array list
	 * consisting of the largest group of anagrams available.
	 * 
	 * @param filename The name of the file containing the words
	 * @return A string array of the largest group of anagrams contained within the file q 
	 */
	@SuppressWarnings("resource")
	public static String[] getLargestAnagramGroup(String filename) {
		
		// Create new file and scanners to read text file and translate into arrays
		File file = new File(filename);
		Scanner lengthScanner;
		Scanner fileScanner;
		
		// Create a new empty array with length zero
		String[] emptyArray = new String[0];
		
		
		// Try to create new scanners of the given file.  If the file can't be found or doesn't exist, then returns
		// an empty array.
		try {
			lengthScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			return emptyArray;
		}

		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			return emptyArray;
		}
		
		
		// Create virtual array length
		int arrayLength = 0;
		
		// Go through the file and count how many words there are, then create a new String Array of that length
		while(lengthScanner.hasNextLine()) {
			arrayLength++;
			lengthScanner.nextLine();
		}
		String[] stringArray = new String[arrayLength];
		
		// Add all the words in the file to the newly created array
		for(int p = 0; p < arrayLength; p++) {
			stringArray[p] = fileScanner.next();
		}
		
		// Create a new comparator object as well as a new array to hold the sorted words with
		StringComparator stringcmp = new StringComparator();
		String[] sortedArray = new String[stringArray.length];
		
		// Sort all the words into lexicographical order and add to the new array
		for (int i = 0; i < stringArray.length; i++) {
			String toSort = stringArray[i];
			sortedArray[i] = sort(toSort);
		}
		
		// Sort the sorted array into alphabetical order
		insertionSort(sortedArray, stringcmp);
		
		// Initialize new values to help keep track of neccessary values in the list
		int highestCount = 0;
		int currentCount = 0;
		String anaHigh = null;
		
		// Compare each word with every word in the array (including itself) and record
		// whether or not it has any anagrams.  Add one to the current count for each anagram
		// found in the array.  Once each word has been compared to every other word, if its
		// anagram count is higher than the current highest count, the highestCOunt and anaHigh 
		// values are adjusted as neccessary.  Current count resets after each word is compared
		for (int j = 0; j < sortedArray.length; j++) {
			String compareWord = sortedArray[j];
			for(int k = 0; k < sortedArray.length; k++) {
				if(areAnagrams(compareWord, sortedArray[k]))
					 currentCount++;
			}
			if (currentCount > highestCount) {
				highestCount = currentCount;
				anaHigh = sortedArray[j];
			}
			
			currentCount = 0;
		}
		
		// A failsafe-- if the highestcount value is zero, this means that there are no
		// anagram pairs within the list.  As such, an empty array is returned.
		if (highestCount == 1) {
			return emptyArray;
		}
		
		// Create a new array to contain the largest list of anagrams, of a proper size,
		// and set its current index to zero.
		String[] highestCountArray = new String[highestCount];
		int highestCountArrayIndex = 0;
		
		// For every word in the original given array, check to see if it is an anagram to the
		// stored anaHigh String value.  If it is, add the word to highestCountArray and add one
		// to its virtual index
		for (int l = 0; l < stringArray.length; l++) {
			if(areAnagrams(anaHigh, stringArray[l])) {
				highestCountArray[highestCountArrayIndex] = stringArray[l];
				highestCountArrayIndex++;
			}
		}
		
		// Return the newly created array
		return highestCountArray;
		
	}
	
	/**
	 * A comparator which compares the lexicographical order of two input strings
	 */
	public static class StringComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}

}
