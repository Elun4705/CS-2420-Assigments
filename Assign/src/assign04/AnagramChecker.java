package assign04;

import java.util.Comparator;

public class AnagramChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//This method returns the lexicographically-sorted version of the input string.
	//The sorting must be accomplished using an insertion sort.
	public static String sort(String word) {
		
		return null;
		
	}
	
	//This generic method sorts the input array using an insertion sort and the input Comparator object.
	public static <T> void insertionSort(T[] list, Comparator<? super T> cmp) {
		
		
		
	}
	
	//This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	//This method must call your sort(String) method.
	public static boolean areAnagrams(String word1, String word2) {
		
		return false;
		
	}
	
	//This method returns the largest group of anagrams in the input array of words, in no particular order.
	//It returns an empty array if there are no anagrams in the input array.
	//This method must call your areAnagrams(String, String) method and your insertionSort(T[], Comparator)
	//method with a new Comparator class or lambda expression that you design.
	public static String[] getLargestAnagramGroup(String[] stringArray) {
		
		return stringArray;
		
	}
	
	//This method behaves the same as the previous method, but reads the list of words from the input filename.
	//It is assumed that the file contains one word per line.  If the file does not exist or is empty, 
	//the method returns an empty array because there are no anagrams. 
	// This method must call your getLargestAnagramGroup(String[]) method.
	public static String[] getLargestAnagramGroup(String filename) {
		
		String[] obsolete = new String[] {"START", "THIS", "ASAP"};
		
		return obsolete;
		
	}

}
