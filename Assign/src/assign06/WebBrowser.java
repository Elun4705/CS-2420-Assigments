package assign06;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

import javax.swing.text.html.HTMLDocument.Iterator;

public class WebBrowser {

	
	private ArrayStack<URL> back = new ArrayStack<URL>();
	private ArrayStack<URL> forward = new ArrayStack<URL>();
	private SinglyLinkedList<URL> browserHistory = new SinglyLinkedList<URL>();
	URL current;
	
	public static void main(String[] args) throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		URL url1 = new URL("http://example.com");
		URL url2 = new URL("http://example1.com");
		URL url3 = new URL("http://example2.com");
		test.visit(url1);
		test.visit(url2);
		
		test.visit(url3);
		
		
		
		System.out.println(Arrays.toString(test.browserHistory.toArray()));
		
	}
	
	public WebBrowser() {
		
	}
	
	public WebBrowser(SinglyLinkedList<URL> history) {
		
		browserHistory = history;
		WebBrowser browser = new WebBrowser();
	}
	
	public void visit(URL webpage) {
		
		browserHistory.insertFirst(webpage);
		back.push(current);
		
		current = webpage;
		forward.clear();
	}
	
	public URL back() throws NoSuchElementException{
		
		if (back.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		forward.push(current);
		
		browserHistory.deleteFirst();
		current = back.pop();
		return current;
		
	}
	
	public URL forward() throws NoSuchElementException {
		
		if (back.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		back.push(current);
		browserHistory.insertFirst(current);
		
		current = forward.pop();
		return current;
	}
	
	public SinglyLinkedList<URL> history() {
		
		browserHistory.insertFirst(current);
		
		return browserHistory;
		
	}

	
}
