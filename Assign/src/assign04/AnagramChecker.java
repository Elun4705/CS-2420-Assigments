package assign04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


import assign03.IntegerComparator;

public class AnagramChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] intArray = new Integer[]{ 4,14,3,5,8,9001,3,2,3,0 };
		
		IntegerComparator intcmp = new IntegerComparator();
		
		Character[] stringArray = new Character[] {'v','g','d','b'};
		
		CharacterComparator chrcmp = new CharacterComparator();
		
		insertionSort(intArray, intcmp);
		
		insertionSort(stringArray, chrcmp);
		
		System.out.println(Arrays.toString(stringArray));
		
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
		
		HashMap<String, Integer> anagramSize = new HashMap<String, Integer>(stringArray.length);
		
		for (int i = 0; i < stringArray.length-1; i++) {
			
			char[] charArray = stringArray[i].toCharArray();
			Character[] CharacterArray = new Character[charArray.length];
			
			for(int j = 0; j < charArray.length-1; j++) {
				CharacterArray[j] = Character.valueOf(charArray[j]);
			}
			
			CharacterComparator chrcmp = new CharacterComparator();
			insertionSort(CharacterArray, chrcmp);
			
			char[] sortedCharArray = new char[CharacterArray.length];
			
			for(int k = 0; k < sortedCharArray.length-1; k++) {
				sortedCharArray[k] = (CharacterArray[k].charValue());
			}
			
			String lexiOrder = sortedCharArray.toString();
			
			if(anagramSize.containsKey(lexiOrder)) {
				anagramSize.put(lexiOrder, anagramSize.get(lexiOrder) + 1);
			} else {
				anagramSize.put(lexiOrder, 1);
			}
		}
		
		for(key )
		

	}
	
	//This method behaves the same as the previous method, but reads the list of words from the input filename.
	//It is assumed that the file contains one word per line.  If the file does not exist or is empty, 
	//the method returns an empty array because there are no anagrams. 
	// This method must call your getLargestAnagramGroup(String[]) method.
	public static String[] getLargestAnagramGroup(String filename) {
		
		String[] obsolete = new String[] {"START", "THIS", "ASAP"};
		
		return obsolete;
		
	}
	
	public static class CharacterComparator implements Comparator<Character> {
		public int compare(Character o1, Character o2) {
			return Character.compare(o1, o2);
		}
	}

}
