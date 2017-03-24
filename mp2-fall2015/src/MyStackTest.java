import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class MyStackTest {
	
		
	//Test push method
	@Test
	public void testPush() {
		MyStack TestTags = new MyStack();
		TestTags.push(new HtmlTag("p"));	
	    assertEquals(TestTags.peek().toString(), "<p>" );
	}
	

	
	//test pop method and the exception it throws
	@Test
	public void testPop() {
		MyStack TestTags = new MyStack();
		TestTags.push(new HtmlTag("p"));
		assertEquals(TestTags.pop().toString(), "<p>" );

	    
	}
	
	@Test(expected=EmptyStackException.class)
	public void testPop_throwException() {
		MyStack TestTags = new MyStack();
	    TestTags.pop();
        
	}

	
	
	//test peek method and the exception it throws
	@Test
	public void testPeek() {
		MyStack TestTags = new MyStack();
		TestTags.push(new HtmlTag("p"));
		assertEquals(TestTags.peek().toString(), "<p>" );
	}
	

	@Test(expected=EmptyStackException.class)
	public void testPeek_throwException() {
		MyStack TestTags = new MyStack();
		TestTags.peek();
	}
	
	

	//test two paths in isEmpty method, true and false
	@Test
	public void testIsEmpty_true() {
		MyStack TestTags = new MyStack();
		assertTrue(TestTags.isEmpty());
	}
	
	@Test
	public void testIsEmpty_false() {
		MyStack TestTags = new MyStack();
		TestTags.push(new HtmlTag("p"));
		assertFalse(TestTags.isEmpty());
	}

}
