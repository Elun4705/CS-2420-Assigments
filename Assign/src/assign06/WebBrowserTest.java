package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class WebBrowserTest {

	@Test
	void testVisit() throws MalformedURLException {
		WebBrowser test = new WebBrowser();

		URL url1 = new URL("https://this.com");
		URL url2 = new URL("https://that.com");
		URL url3 = new URL("https://something.com");
		URL url4 = new URL("https://random.com");

		test.visit(url1);
		assertEquals(new URL("https://this.com"), url1);

		test.visit(url2);
		assertEquals(new URL("https://that.com"), url2);

		test.visit(url3);
		assertEquals(new URL("https://something.com"), url3);

		test.visit(url4);
		assertEquals(new URL("https://random.com"), url4);

	}

	@Test
	void testBack() throws MalformedURLException {
		WebBrowser test = new WebBrowser();

		URL url1 = new URL("https://this.com");
		URL url2 = new URL("https://that.com");
		URL url3 = new URL("https://something.com");
		URL url4 = new URL("https://random.com");

		test.visit(url1);
		test.visit(url2);
		test.visit(url3);
		test.visit(url4);

		assertEquals(url3, test.back());
		assertEquals(url2, test.back());
		assertEquals(url1, test.back());

		assertThrows(NoSuchElementException.class, () -> test.back());
	}

	@Test
	void testForward() throws MalformedURLException {
		WebBrowser test = new WebBrowser();

		URL url1 = new URL("https://this.com");
		URL url2 = new URL("https://that.com");
		URL url3 = new URL("https://something.com");
		URL url4 = new URL("https://random.com");

		test.visit(url1);
		test.visit(url2);
		test.visit(url3);
		test.visit(url4);

		test.back();
		test.back();
		test.back();

		assertEquals(url2, test.forward());
		assertEquals(url3, test.forward());
		assertEquals(url4, test.forward());

		assertThrows(NoSuchElementException.class, () -> test.forward());

	}

	@Test
	void testHistory() throws MalformedURLException {

		SinglyLinkedList<URL> testHistory = new SinglyLinkedList<URL>();

		WebBrowser test = new WebBrowser();

		URL url1 = new URL("https://this.com");
		URL url2 = new URL("https://that.com");
		URL url3 = new URL("https://something.com");
		URL url4 = new URL("https://random.com");

		test.visit(url1);
		test.visit(url2);
		test.visit(url3);
		test.visit(url4);

		testHistory.add(url4);
		testHistory.add(url3);
		testHistory.add(url2);
		testHistory.add(url1);

		assertEquals(Arrays.toString(test.history().toArray()), Arrays.toString(testHistory.toArray()));

	}

}
