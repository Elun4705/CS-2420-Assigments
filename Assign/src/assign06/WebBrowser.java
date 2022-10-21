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
	
	public static void main(String[] args) throws MalformedURLException {
		WebBrowser test = new WebBrowser();
		URL url1 = new URL("http://example.com");
		URL url2 = new URL("http://example1.com");
		URL url3 = new URL("http://example2.com");
		
		
//		SinglyLinkedList<URL> forBrowser = new SinglyLinkedList<URL>();
//		
//		forBrowser.add(url1);
//		forBrowser.add(url2);
//		forBrowser.add(url3);
//		
		WebBrowser testBrowser = new WebBrowser();
		
		testBrowser.visit(url1);
		testBrowser.visit(url2);
		testBrowser.visit(url3);
//		
//		System.out.println(testBrowser.back());
//		System.out.println(testBrowser.back());
//		System.out.println(testBrowser.back());
		System.out.println(Arrays.toString(testBrowser.history().toArray()));
		
	}
	
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
