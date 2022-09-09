package assign02;

import java.util.GregorianCalendar;

/**
 * This class represents a library book, which is an extension from the Book class
 * and thus holds all its properties.  It has an added holder and dueDate field which
 * can be changed with certain methods for certain situations.  It is much the same as a
 * LibraryBook, but is modified so that the holder value can be either a String or some other
 * identifier
 * 
 * @author u1050952
 *
 * @param <Type>
 */
/**
 * @author Andy Huo and Emmanuel Luna
 *
 * @param <Type>
 */
public class LibraryBookGeneric<Type> extends Book {
private Type holder;
	
	private GregorianCalendar dueDate;

	/**
	 * Creates a new LibraryBookGeneric with the given parameters
	 * 
	 * @param isbn
	 * @param author
	 * @param title
	 */
	public LibraryBookGeneric (long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	/**
	 * An Accessor method which returns the LibraryBookGeneric's holder
	 * 
	 * @return the holder
	 */
	public Type getHolder() {
		return holder;
	}
	
	/**
	 * An Accessor method which returns the LibraryBookGeneric's dueDate 
	 * 
	 * @return the dueDate
	 */
	public GregorianCalendar getDueDate() {
		return dueDate;
	}
	
	/**
	 * A method which sets the LibraryBookGeneric with the given isbn's 
	 * dueDate and holder to null, signifying that it has been returned to the library
	 * 
	 * @param isbn
	 */
	public void checkIn(long isbn) {
		this.setHolder(null);
		this.setDueDate(0, 0, 0);
	}
	
	/**
	 * A method which sets the LibraryBookGeneric with the given holder's dueDate and
	 * holder to null, signifying that it has been returned to the library
	 * 
	 * @param holder
	 */
	public void checkIn(Type holder) {
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
	public void checkOut(int year, int month, int day, Type holder) {
		this.setHolder(holder);
		this.setDueDate(year, month, day);
	}

	/**
	 * Sets the LibraryBook's holder value to the given holder
	 * 
	 * @param holder
	 */
	public void setHolder(Type holder) {
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
