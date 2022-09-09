package assign02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * This class contains tests for LibraryGeneric.
 * 
 * @author Erin Parker, Andy Huo and Emmanuel Luna
 * @version September 2, 20200
 */
public class LibraryGenericTester {
	
	private LibraryGeneric<String> nameLib;  // library that uses names to identify patrons (holders)
	private LibraryGeneric<PhoneNumber> phoneLib;  // library that uses phone numbers to identify patrons
	
	@BeforeEach
	void setUp() throws Exception {
		nameLib = new LibraryGeneric<String>();
		nameLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		nameLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		nameLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		phoneLib = new LibraryGeneric<PhoneNumber>();
		phoneLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		phoneLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		phoneLib.add(9780446580342L, "David Baldacci", "Simple Genius");	
	}
	
	@Test
	public void testNameLibCheckout() {
		String patron = "Jane Doe";
		assertTrue(nameLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(nameLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	@Test
	public void testNameLibLookup() {
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = nameLib.lookup(patron);
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}
	
	@Test
	public void testNameLibCheckin() {
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(nameLib.checkin(patron));
	}

	@Test
	public void testPhoneLibCheckout() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		assertTrue(phoneLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(phoneLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	@Test
	public void testPhoneLibLookup() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = phoneLib.lookup(patron);
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}

	@Test
	public void testPhoneLibCheckin() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(phoneLib.checkin(patron));
		System.out.println(phoneLib.lookup(patron));
	}
	
	@Test
	public void testnameLibOrder() {
	LibraryGeneric<String> nameLibOrder = new LibraryGeneric<String>();
	LibraryGeneric<String> nameLibOutOfOrder1 = new LibraryGeneric<String>();
	LibraryGeneric<String> nameLibOutOfOrder2 = new LibraryGeneric<String>();
	LibraryGeneric<String> nameLibOutOfOrder3 = new LibraryGeneric<String>();
	nameLibOrder.add(1L, "Wickett", "Songbook");
	nameLibOrder.add(2l, "Daisy", "Worchester Sauce");
	nameLibOrder.add(3L, "Akana", "Pizza Recipes");
	nameLibOrder.add(4L, "Creativity", "End of my rope");
	
	nameLibOutOfOrder1.add(1L, "Wickett", "Songbook");
	nameLibOutOfOrder1.add(2l, "Daisy", "Worchester Sauce");
	nameLibOutOfOrder1.add(4L, "Creativity", "End of my rope");
	nameLibOutOfOrder1.add(3L, "Akana", "Pizza Recipes");
	
	nameLibOutOfOrder2.add(2l, "Daisy", "Worchester Sauce");
	nameLibOutOfOrder2.add(1L, "Wickett", "Songbook");
	nameLibOutOfOrder2.add(4L, "Creativity", "End of my rope");
	nameLibOutOfOrder2.add(3L, "Akana", "Pizza Recipes");
	
	nameLibOutOfOrder3.add(4L, "Creativity", "End of my rope");
	nameLibOutOfOrder3.add(1L, "Wickett", "Songbook");
	nameLibOutOfOrder3.add(3L, "Akana", "Pizza Recipes");
	nameLibOutOfOrder3.add(2l, "Daisy", "Worchester Sauce");
	
	assertEquals(nameLibOrder.getInventoryList(), nameLibOutOfOrder1.getInventoryList());
	assertEquals(nameLibOrder.getInventoryList(), nameLibOutOfOrder2.getInventoryList());
	assertEquals(nameLibOrder.getInventoryList(), nameLibOutOfOrder3.getInventoryList());
	}
	
	@Test
	public void testOverDueList() {
		LibraryGeneric<String> nameLib1 = new LibraryGeneric<String>();
		LibraryGeneric<String> nameLib2 = new LibraryGeneric<String>();
		LibraryGeneric<String> nameLib3 = new LibraryGeneric<String>();
		LibraryGeneric<String> nameLib4 = new LibraryGeneric<String>();
		
		nameLib1.add(1L, "Wickett", "Songbook");
		nameLib1.add(2l, "Daisy", "Worchester Sauce");
		nameLib1.add(3L, "Akana", "Pizza Recipes");
		nameLib1.add(4L, "Creativity", "End of my rope");
		
		nameLib2.add(1L, "Wickett", "Songbook");
		nameLib2.add(2l, "Daisy", "Worchester Sauce");
		nameLib2.add(4L, "Creativity", "End of my rope");
		nameLib2.add(3L, "Akana", "Pizza Recipes");
		
		nameLib3.add(2l, "Daisy", "Worchester Sauce");
		nameLib3.add(1L, "Wickett", "Songbook");
		nameLib3.add(4L, "Creativity", "End of my rope");
		nameLib3.add(3L, "Akana", "Pizza Recipes");
		
		nameLib4.add(4L, "Creativity", "End of my rope");
		nameLib4.add(1L, "Wickett", "Songbook");
		nameLib4.add(3L, "Akana", "Pizza Recipes");
		nameLib4.add(2l, "Daisy", "Worchester Sauce");
		
		
//		A scenario where all of the books are overdue and checked out on the same day
		nameLib1.checkout(1L, "Moon", 9, 13, 2022);
		nameLib1.checkout(2L, "Moon", 9, 13, 2022);
		nameLib1.checkout(3L, "Moon", 9, 13, 2022);
		nameLib1.checkout(4L, "Moon", 9, 13, 2022);
		
//		A scenario where all of the books are overdue and checked out on different days
		nameLib2.checkout(1L, "Moon", 9, 12, 2022);
		nameLib2.checkout(2L, "Moon", 12, 10, 2021);
		nameLib2.checkout(3L, "Moon", 4, 20, 2022);
		nameLib2.checkout(4L, "Moon", 10, 10, 2021);
		
//		A scenario where one of the books is overdue
		nameLib3.checkout(1L, "Moon", 9, 13, 2022);
		nameLib3.checkout(2L, "Moon", 6, 10, 2023);
		nameLib3.checkout(3L, "Moon", 9, 10, 2023);
		nameLib3.checkout(4L, "Moon", 10, 10, 2022);

//		A scenario where none of the books are overdue
		nameLib4.checkout(1L, "Moon", 9, 18, 2022);
		nameLib4.checkout(2L, "Moon", 9, 20, 2022);
		nameLib4.checkout(3L, "Moon", 10, 10, 2022);
		nameLib4.checkout(4L, "Moon", 10, 10, 2022);
		
		assertTrue(nameLib1.getOverdueList(9, 14, 2022).contains(new Book(1L,"Wickett", "Songbook")));
		assertTrue(nameLib1.getOverdueList(9, 14, 2022).contains(new Book(2L, "Daisy", "Worchester Sauce")));
		assertTrue(nameLib1.getOverdueList(9, 14, 2022).contains(new Book(3L, "Akana", "Pizza Recipes")));
		assertTrue(nameLib1.getOverdueList(9, 14, 2022).contains(new Book(4L, "Creativity", "End of my rope")));
		
		assertTrue(nameLib2.getOverdueList(9, 14, 2022).contains(new Book(1L,"Wickett", "Songbook")));
		assertTrue(nameLib2.getOverdueList(9, 14, 2022).contains(new Book(2L, "Daisy", "Worchester Sauce")));
		assertTrue(nameLib2.getOverdueList(9, 14, 2022).contains(new Book(3L, "Akana", "Pizza Recipes")));
		assertTrue(nameLib2.getOverdueList(9, 14, 2022).contains(new Book(4L, "Creativity", "End of my rope")));
		
		assertTrue(nameLib3.getOverdueList(9, 14, 2022).contains(new Book(1L,"Wickett", "Songbook")));
		assertFalse(nameLib3.getOverdueList(9, 14, 2022).contains(new Book(2L, "Daisy", "Worchester Sauce")));
		assertFalse(nameLib3.getOverdueList(9, 14, 2022).contains(new Book(3L, "Akana", "Pizza Recipes")));
		assertFalse(nameLib3.getOverdueList(9, 14, 2022).contains(new Book(4L, "Creativity", "End of my rope")));
		
		assertFalse(nameLib4.getOverdueList(9, 14, 2022).contains(new Book(1L,"Wickett", "Songbook")));
		assertFalse(nameLib4.getOverdueList(9, 14, 2022).contains(new Book(2L, "Daisy", "Worchester Sauce")));
		assertFalse(nameLib4.getOverdueList(9, 14, 2022).contains(new Book(3L, "Akana", "Pizza Recipes")));
		assertFalse(nameLib4.getOverdueList(9, 14, 2022).contains(new Book(4L, "Creativity", "End of my rope")));
	}
	
	@Test
	public void testGetOrderedByTitle() {
		LibraryGeneric<String> nameLibOrder = new LibraryGeneric<String>();
		LibraryGeneric<String> nameLibOutOfOrder1 = new LibraryGeneric<String>();
		LibraryGeneric<String> nameLibOutOfOrder2 = new LibraryGeneric<String>();
		LibraryGeneric<String> nameLibOutOfOrder3 = new LibraryGeneric<String>();
		
		nameLibOrder.add(4L, "Creativity", "End of my rope");
		nameLibOrder.add(3L, "Akana", "Pizza Recipes");	
		nameLibOrder.add(1L, "Wickett", "Songbook");
		nameLibOrder.add(2L, "Daisy", "Worchester Sauce");
		
		nameLibOutOfOrder1.add(1L, "Wickett", "Songbook");
		nameLibOutOfOrder1.add(2l, "Daisy", "Worchester Sauce");
		nameLibOutOfOrder1.add(4L, "Creativity", "End of my rope");
		nameLibOutOfOrder1.add(3L, "Akana", "Pizza Recipes");
		
		nameLibOutOfOrder2.add(2l, "Daisy", "Worchester Sauce");
		nameLibOutOfOrder2.add(1L, "Wickett", "Songbook");
		nameLibOutOfOrder2.add(4L, "Creativity", "End of my rope");
		nameLibOutOfOrder2.add(3L, "Akana", "Pizza Recipes");
		
		nameLibOutOfOrder3.add(4L, "Creativity", "End of my rope");
		nameLibOutOfOrder3.add(1L, "Wickett", "Songbook");
		nameLibOutOfOrder3.add(3L, "Akana", "Pizza Recipes");
		nameLibOutOfOrder3.add(2l, "Daisy", "Worchester Sauce");
		
		assertEquals(nameLibOrder.getOrderedByTitle(), nameLibOutOfOrder1.getOrderedByTitle());
		assertEquals(nameLibOrder.getOrderedByTitle(), nameLibOutOfOrder2.getOrderedByTitle());
		assertEquals(nameLibOrder.getOrderedByTitle(), nameLibOutOfOrder3.getOrderedByTitle());
	}
}
