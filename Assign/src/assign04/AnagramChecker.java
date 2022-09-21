package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import assign03.IntegerComparator;

public class AnagramChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] intArray = new Integer[]{ 4,14,3,5,8,9001,3,2,3,0 };
		
		IntegerComparator intcmp = new IntegerComparator();
		
		String[] stringArray = new String[] {"word", "luna", "luna", "december", "implementgram", "implementgram"};
		
		StringComparator stringcmp = new StringComparator();
		
		insertionSort(intArray, intcmp);
		
		
		try {
			System.out.println(Arrays.toString(getLargestAnagramGroup("sample_word_list.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sort("abscsdfasdfasdfa"));
		
		System.out.println(areAnagrams("lkjhgfdsa", "asdfghjkl"));


	}
	
	//This method returns the lexicographically-sorted version of the input string.
	//The sorting must be accomplished using an insertion sort.
	public static String sort(String word) {
		
		char[] list = word.toCharArray();
		
        for (int i = 1; i < list.length; ++i) {
            char item = list[i];
            int j = i - 1;
  
            while (j >= 0 && Character.compare(list[j], item) > 0) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = item;
        }
        
        String sortedWord = String.valueOf(list);
        return sortedWord;
		
	}
	
	//This generic method sorts the input array using an insertion sort and the input Comparator object.
	public static <T> void insertionSort(T[] list, Comparator<? super T> cmp) {
		
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
	
	//This method returns true if the two input strings are anagrams of each other, otherwise returns false.
	//This method must call your sort(String) method.
	public static boolean areAnagrams(String word1, String word2) {
		
		if (word1.length() != word2.length())
			return false;
		
		String sortedWord1 = sort(word1.toLowerCase());
		String sortedWord2 = sort(word2.toLowerCase());
		
		if(sortedWord1.compareTo(sortedWord2) == 0) {
			return true;
		}
		
		return false;		
	}
	
	
	//This method returns the largest group of anagrams in the input array of words, in no particular order.
	//It returns an empty array if there are no anagrams in the input array.
	//This method must call your areAnagrams(String, String) method and your insertionSort(T[], Comparator)
	//method with a new Comparator class or lambda expression that you design.
	public static String[] getLargestAnagramGroup(String[] stringArray) {
		
		StringComparator stringcmp = new StringComparator();
		String[] sortedArray = new String[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++) {
			String toSort = stringArray[i];
			sortedArray[i] = sort(toSort);
		}
		
		insertionSort(sortedArray, stringcmp);
		
		int highestCount = 0;
		int currentCount = 0;
		String anaHigh = null;
		
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
		
		String[] emptyArray = new String[0];
		
		if (highestCount == 1) {
			return emptyArray;
		}
		
		String[] highestCountArray = new String[highestCount];
		int highestCountArrayIndex = 0;
		
		for (int l = 0; l < stringArray.length; l++) {
			if(areAnagrams(anaHigh, stringArray[l])) {
				highestCountArray[highestCountArrayIndex] = stringArray[l];
				highestCountArrayIndex++;
			}
		}
		
		return highestCountArray;

	}
	
	//This method behaves the same as the previous method, but reads the list of words from the input filename.
	//It is assumed that the file contains one word per line.  If the file does not exist or is empty, 
	//the method returns an empty array because there are no anagrams. 
	// This method must call your getLargestAnagramGroup(String[]) method.
	public static String[] getLargestAnagramGroup(String filename) throws FileNotFoundException {
		
		File file = new File(filename);
		
		Scanner lengthScanner = new Scanner(file);
		Scanner fileScanner = new Scanner(file);
		int arrayLength = 0;
		
		while(lengthScanner.hasNextLine()) {
			arrayLength++;
			lengthScanner.nextLine();
		}
		
		String[] stringArray = new String[arrayLength];
		
		for(int p = 0; p < arrayLength; p++) {
			stringArray[p] = fileScanner.next();
		}
		
		StringComparator stringcmp = new StringComparator();
		String[] sortedArray = new String[stringArray.length];
		
		for (int i = 0; i < stringArray.length; i++) {
			String toSort = stringArray[i];
			sortedArray[i] = sort(toSort);
		}
		
		insertionSort(sortedArray, stringcmp);
		
		int highestCount = 0;
		int currentCount = 0;
		String anaHigh = null;
		
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
		
		String[] emptyArray = new String[0];
		
		if (highestCount == 1) {
			return emptyArray;
		}
		
		String[] highestCountArray = new String[highestCount];
		int highestCountArrayIndex = 0;
		
		for (int l = 0; l < stringArray.length; l++) {
			if(areAnagrams(anaHigh, stringArray[l])) {
				highestCountArray[highestCountArrayIndex] = stringArray[l];
				highestCountArrayIndex++;
			}
		}
		
		return highestCountArray;
		
	}
	
	public static class StringComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}

}
