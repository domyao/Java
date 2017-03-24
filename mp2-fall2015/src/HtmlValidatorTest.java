import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class HtmlValidatorTest {
   
    private Queue<HtmlTag> testTags;

    // Set up a Queue of preset test tags
	@Before
    public void setUp() throws Exception{
    	testTags = new LinkedList<>();
    	testTags.add(new HtmlTag("p", false));
		testTags.add(new HtmlTag("title"));
		testTags.add(new HtmlTag("br"));
		testTags.add(new HtmlTag("p"));
		
	
    	
    }

	// test the empty constructor 
	@Test
	public void testHtmlValidator() {
		HtmlValidator testValidator = new HtmlValidator();
		assertTrue(testValidator.getTags().isEmpty());
	}

	
	//test the constructor copying a queue of HtmlTags
	//and test the exception it throws
	@Test
	public void testHtmlValidator_copyQueue() {
		//make a clone of testTags as testtags_copy
		Queue<HtmlTag> testTags_copy = new LinkedList<>();
		testTags_copy.add(new HtmlTag("p", false));
		testTags_copy.add(new HtmlTag("title"));
		testTags_copy.add(new HtmlTag("br"));
		testTags_copy.add(new HtmlTag("p"));
			
		HtmlValidator testValidator = new HtmlValidator(testTags_copy);
		assertEquals(testTags_copy, testTags);               //test the queue passed into it isn't modified
		assertEquals(testValidator.getTags(), testTags);     //test the queue passed i
	}
	
	
    
	@Test(expected=IllegalArgumentException.class)
	public void testHtmlValidator_copyQueue_throwsException() {
		Queue<HtmlTag> nullTags = null;		
		HtmlValidator testValidator = new HtmlValidator(nullTags);

	}

	
	//test addTag
    //and test the exception it throws
	@Test
	public void testAddTag() {
		
		HtmlValidator testValidator = new HtmlValidator();
		
		HtmlTag testTag = new HtmlTag("b", false);
		testValidator.addTag(testTag);
		assertEquals(testValidator.getTags().peek(), testTag);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAddTag_throwsException() {
		HtmlValidator testValidator = new HtmlValidator();
		
		HtmlTag testTag = null;
		testValidator.addTag(testTag);
		
	}
	
	//test getTags

	@Test
	public void testGetTags() {
		HtmlValidator testValidator = new HtmlValidator(testTags);
		assertEquals(testValidator.getTags(), testTags);
	}
	
	
	
	
	
	//test removeAll
    //and test the exception it throws
	@Test
	public void testRemoveAll() {
		HtmlValidator testValidator = new HtmlValidator(testTags);
		testValidator.removeAll("p");
		
		Queue<HtmlTag> leftTags = new LinkedList<>();
		leftTags.add(new HtmlTag("title"));
		leftTags.add(new HtmlTag("br"));
		
		assertEquals(testValidator.getTags(),leftTags);
		

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveAll_throwException() {
		HtmlValidator testValidator = new HtmlValidator(testTags);
		testValidator.removeAll(null);
	}
		

	
    //test four different paths in methods validate
	
	@Test
	public void testValidate_Path_isSelfClosing() {
		Queue<HtmlTag> Tags1= new LinkedList<>();
    	Tags1.add(new HtmlTag("!doctype"));
    	HtmlValidator testValidator = new HtmlValidator(Tags1);
    	testValidator.validate();
        assertEquals(testValidator.getIndent(),0 ); // if it is self closing, the indent will not increase, will stay at initial value 0.
	}
	
	@Test
	public void testValidate_Path_isOpenTag() {
		Queue<HtmlTag> Tags2= new LinkedList<>();
    	Tags2.add(new HtmlTag("title"));
    	HtmlValidator testValidator = new HtmlValidator(Tags2);
    	testValidator.validate();
        assertEquals(testValidator.getIndent(),4 ); // it is open tag, the indent will increase by 4, resulting in the indent of value 4 (0+4=4)
	}
	
	
	
	@Test
	public void testValidate_Path_mismatch() {
		Queue<HtmlTag> Tags3= new LinkedList<>();
    	Tags3.add(new HtmlTag("title"));
    	Tags3.add(new HtmlTag("head",false));
    	HtmlValidator testValidator = new HtmlValidator(Tags3);
    	testValidator.validate();
        assertEquals(testValidator.getIndent(),4 ); //the close tag <head> dosn't match the last open tags, the indent will stay at 4 
                                                    //which was increased from the last open tag <title>
	}
	
	@Test
	public void testValidate_Path_match() {
		Queue<HtmlTag> Tags4= new LinkedList<>();
		Tags4.add(new HtmlTag("head"));
    	Tags4.add(new HtmlTag("title"));
        Tags4.add(new HtmlTag("title",false));
    	HtmlValidator testValidator = new HtmlValidator(Tags4);
    	testValidator.validate();
        assertEquals(testValidator.getIndent(),4); // In this case, the close tag match the last open tag, 
                                                    // the indent will be increase by 4 twice because of the two open tags, 
                                                    // then decrease by 4 because of the last matched close tag, resulting in indent of value 4 (4+4-4 = 4)
        }
	
	


}
