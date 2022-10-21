package assign06;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * Creates a new WebBrowser class meant to simulate all of the functions of a
 * real web browser, complete with a forward stack and back stack
 * 
 * @author Emmanuel Luna and Andy Huo
 *
 */
public class WebBrowser {

	private ArrayStack<URL> back = new ArrayStack<URL>();
	private ArrayStack<URL> forward = new ArrayStack<URL>();
	private URL current;

	/**
	 * An empty constructor
	 */
	public WebBrowser() {

	}

	/**
	 * A constructor for a WebBrowser with its own history
	 * 
	 * @param history the custom-added history
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {

		WebBrowser browser = new WebBrowser();
		current = history.deleteFirst();
		while (history.isEmpty() == false) {
			back.push(history.deleteFirst());
		}

	}

	/**
	 * Simulates visiting a new webpage, changing the current method and clearing
	 * the forward stack
	 * 
	 * @param webpage the webpage being visited
	 */
	public void visit(URL webpage) {

		back.push(current);

		current = webpage;
		forward.clear();
	}

	/**
	 * Simulates hitting the back arrow on a webpage, returning to the previously
	 * visited page
	 * 
	 * @return The webpage being returned to
	 * @throws NoSuchElementException
	 */
	public URL back() throws NoSuchElementException {

		if (back.isEmpty() || back.peek() == null) {
			throw new NoSuchElementException();
		}

		forward.push(current);

		current = back.pop();
		return current;

	}

	/**
	 * Simulates hitting the forward arrow on a webpage, returning to the previously
	 * left page
	 * 
	 * @return The webpage being returned to
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException {

		if (back.isEmpty()) {
			throw new NoSuchElementException();
		}

		back.push(current);

		current = forward.pop();
		return current;
	}

	/**
	 * Returns the history of the Browser in the form of a singly linked list
	 * 
	 * @return a singly linked list containing all previously visited pages
	 */
	public SinglyLinkedList<URL> history() {

		ArrayStack<URL> temp = new ArrayStack<URL>();
		SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();

		while (back.isEmpty() == false) {
			temp.push(back.pop());
		}

		while (temp.isEmpty() == false) {
			if (temp.peek() == null) {
				temp.pop();
			} else {
				history.insertFirst(temp.peek());
				back.push(temp.pop());
			}
		}

		history.insertFirst(current);
		return history;

	}

}
