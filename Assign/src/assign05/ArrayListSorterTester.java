package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import assign05.ArrayListSorter;

class ArrayListSorterTester {

	@Test
	public void mergeSortSmall() {
		
		ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(10);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(10);
		
		ArrayListSorter.mergesort(unsorted);
		
		assertEquals(sorted, unsorted);
	}
	
	@Test
	public void mergeSortLarge() {
		ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(100);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(100);
		
		ArrayListSorter.mergesort(unsorted);
		
		assertEquals(sorted, unsorted);
	}
	
	@Test
	public void mergeSortLargeFail() {
		ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(100);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(99);
		
		ArrayListSorter.mergesort(unsorted);
		
		assertNotEquals(sorted, unsorted);
	}
	
	@Test
	public void mergeSortDescending() {
		ArrayList<Integer> unsorted = ArrayListSorter.generateDescending(100);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(100);
		
		ArrayListSorter.mergesort(unsorted);
		
		assertEquals(sorted, unsorted);
	}
	
	@Test
	public void quickSortSmall() {
		ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(10);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(10);
		
		ArrayListSorter.quicksort(unsorted);
		
		assertEquals(sorted, unsorted);
	}
	
	@Test
	public void quickSortLarge() {
		ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(100);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(100);
		
		ArrayListSorter.quicksort(unsorted);
		
		assertEquals(sorted, unsorted);
	}
	
	@Test
	public void quickSortDescending() {
		ArrayList<Integer> unsorted = ArrayListSorter.generateDescending(100);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(100);
		
		ArrayListSorter.quicksort(unsorted);
		
		assertEquals(sorted, unsorted);
	}
	
	@Test
	public void quickSortLargeFail() {
		ArrayList<Integer> unsorted = ArrayListSorter.generatePermuted(100);
		ArrayList<Integer> sorted = ArrayListSorter.generateAscending(99);
		
		ArrayListSorter.quicksort(unsorted);
		
		assertNotEquals(sorted, unsorted);
	}
	
}
