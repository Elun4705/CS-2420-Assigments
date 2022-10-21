package assign06;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

public class WebBrowser {

	
	private ArrayStack<URL> back = new ArrayStack<URL>();
	private ArrayStack<URL> forward = new ArrayStack<URL>();
	URL current;
	
	public WebBrowser() {
		
	}
	
	public WebBrowser(SinglyLinkedList<URL> history) {
		
		
		WebBrowser browser = new WebBrowser();
		current = history.deleteFirst();
		while(history.isEmpty() == false) {
			back.push(history.deleteFirst());
		}

	}
	
	public void visit(URL webpage) {
		
		back.push(current);
		
		current = webpage;
		forward.clear();
	}
	
	public URL back() throws NoSuchElementException{
		
		if (back.isEmpty() || back.peek() == null) {
			throw new NoSuchElementException();
		}
		
		forward.push(current);
		
		current = back.pop();
		return current;
		
	}
	
	public URL forward() throws NoSuchElementException {
		
		if (back.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		back.push(current);
		
		current = forward.pop();
		return current;
	}
	
	public SinglyLinkedList<URL> history() {
		
		ArrayStack<URL> temp = new ArrayStack<URL>();
		SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();
		
		while (back.isEmpty() == false) {
			temp.push(back.pop());
		}
		
		while (temp.isEmpty() == false) {
			if(temp.peek() == null) {
				temp.pop();
			}
			else {
			history.insertFirst(temp.peek());
			back.push(temp.pop());
			}
		}
		
		history.insertFirst(current);
		return history;
		
	}

	
}
