package assign02;

import java.util.GregorianCalendar;

/**
 * This class represents a library book, which is an extension from the Book class
 * and thus holds all its properties.  It has an added holder and dueDate field which
 * can be changed with certain methods for certain situations.
 * 
 * @author Andy Huo and Emmanuel Luna
 *
 */
public class LibraryBook extends Book{
	
	private String holder;
	
	private GregorianCalendar dueDate;

	/**
	 * Creates a new library book object with given isbn, author, and title.  
	 * Holder and DueDate are standardized as "null" unless changed otherwise.
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	/**
	 * Accessor method for the Holder field
	 * 
	 * @return the holder
	 */
	public String getHolder() {
		return holder;
	}
	
	/**
	 * Accessor method for the dueDate field
	 * 
	 * @return the dueDate
	 */
	public GregorianCalendar getDueDate() {
		return dueDate;
	}
	
	/**
	 * Sets the LibraryBook with the given isbn's holder and dueDate values back to null, 
	 * signifying that the book has been returned to the library
	 * 
	 * @param isbn
	 */
	public void checkIn(long isbn) {
		this.setHolder(null);
		this.setDueDate(0, 0, 0);
	}
	
	/**
	 * Sets the LibraryBook with the given holder's holder and dueDate values back to null,
	 * signifying that the book has been returned to the library
	 * 
	 * @param holder
	 */
	public void checkIn(String holder) {
		this.setHolder(null);
		this.setDueDate(0,0,0);
	}
	
	/**
	 * Sets the LibraryBook holder to the given holder, and sets the dueDate to a new
	 * GregorianCalendar object with the given parameters
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param holder
	 */
	public void checkOut(int year, int month, int day, String holder) {
		this.setHolder(holder);
		this.setDueDate(year, month, day);
	}

	/**
	 * Sets the LibraryBook's holder value to the given holder
	 * 
	 * @param holder
	 */
	public void setHolder(String holder) {
		this.holder = holder;
	}

	/**
	 * Creates a new GregorianCalendar object and sets the LibraryBook's dueDate value to it
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setDueDate(int year, int month, int day) {
		GregorianCalendar dueDate = new GregorianCalendar(year, month, day);
		this.dueDate = dueDate;
	}
	
	
	

}
