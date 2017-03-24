import java.util.*;

/**
 * This is the HtmlValidator class
 * HtmlValidator examines HTML files and determine if it represents a valid sequence of tags.
 * 
 * @author DominicYao(Chenyu Yao) #38186145
 *
 */
public class HtmlValidator {

	private final Queue<HtmlTag> HtmlTags;
	private int indent = 0;
	
    /**
     * Construct the HtmlValidator with an empty queue of HTML tags. 
     */
	
	public HtmlValidator(){
		HtmlTags = new LinkedList<HtmlTag>();
	}
	
	
	
	/**
	 * Construct the HtmlValidator with an entirely separate copy of the queue that was passed in without modifying it .
	 * 
	 * @param tags -- a queue contains a series of HtmlTags
	 * @throws IllegalArgumentException If queue passed is null
	 * 
	 */
	
	public HtmlValidator(Queue<HtmlTag> tags){
		
		if(tags == null){
			throw new IllegalArgumentException();
		}
		
		HtmlTags = new LinkedList<HtmlTag>();
		Queue<HtmlTag> TagsHolder = new LinkedList<>();
		
		while(!tags.isEmpty()){
			TagsHolder.add(tags.remove());
		}
		
		while(!TagsHolder.isEmpty()){
			HtmlTag removedTag = TagsHolder.remove();
			HtmlTags.add(removedTag);
			tags.add(removedTag);			
			
		}
		
	}
	
	/**
	 * Add the given tag to the end of the validator's queue. 
	 * 
	 * @param tag
	 * @throws IllegalArgumentException If the tag passed is null
	 */
	public void addTag(HtmlTag tag){
		if( tag == null){
			throw new IllegalArgumentException();
		}
		
		HtmlTags.add(tag);
		
		
	}
	
	
	/**
	 * @return HtmlTags -- the validator's queue of HTML tags
	 */
	
	public Queue<HtmlTag> getTags(){
		return HtmlTags;
		
	}
	
	
	/**
	 * This method <b>removes</b> from the validator's queue any tags that match the given element. 
	 * If the element passed does not exactly match any tags (such as an empty string), the queue should not be modified. 
	 * 
	 *  
	 * @param element
	 * @throws IllegalArgumentException If the element passed is null
	 * 
	 */
	public void removeAll(String element){
		
		if(element == null){
			throw new IllegalArgumentException();
		}
		
		int initial_size = HtmlTags.size();
		
		for( int i = 0; i < initial_size; i++){
			
			HtmlTag recycleTag = HtmlTags.remove();
			if (!recycleTag.getElement().equals(element)){
				HtmlTags.add(recycleTag);
			}
			
		}		
				
	}
	
	/**
	 *  Print an indented text representation of the HTML tags in the queue. 
	 *  <p>Print error messages if either of the following conditions in the HTML is encountered: 
	 *  <i>A closing tag that does not match the most recently opened tag (or if there are no open tags at that point); 
	 *  Reaching the end of the HTML input with any tags still open that were not properly closed.</i>
	 *  
	 *  
	 */
	public void validate(){
		MyStack openTags = new MyStack(); 
		HtmlTag matchtag = null;
		
		while(!HtmlTags.isEmpty()){
			
			HtmlTag theTag = HtmlTags.remove();
			
		    //If the tag is self-closing, then just print it out without increase the indent for printing next line of tag
			if(theTag.isSelfClosing()){
				System.out.println(new String(new char[indent]).replace("\0", " ") + theTag);
				
			} 
			
			//If the tag is open tag, store it to a stack of openTags to match any further corresponding close tag.
			//and increase the indent for next line.
			else if(theTag.isOpenTag()){
				System.out.println(new String(new char[indent]).replace("\0", " ") + theTag);
				indent += 4;
				openTags.push(theTag);
			} 
			
			else {
               
				try{
					matchtag= openTags.peek();
				}catch (EmptyStackException e){
					System.out.println("The openTags stack has become empty, cannot peek from an empty stack");
				}
				
				//If the close tag match the last open tag, then decrease the indent at its own line, 
				//and remove the open tags in the stack it matches
				//If it is a closed tag and doesn't much the last open tag, then it is an unexpected tag. ERROR
				if(theTag.matches(matchtag)){
					indent -= 4;
					System.out.println(new String(new char[indent]).replace("\0", " ") + theTag);
					openTags.pop();					
				} else{
					System.out.println("ERROR unexpected tag: " + theTag);
				}
			}
			
		}
		
		// If all the HtmlTags has been looped over yet the open tags is not empty, 
		// which means there are still open tags haven't been matched, then these remains open tags are unclosed tags, ERROR
		while(!openTags.isEmpty()){
			System.out.println("ERROR unclosed tag: " + openTags.pop());
		}
				
	}	
	
	/**
	 * get the indent in front of the printed tags, this is for testing purpose only
	 * @return indent
	 */
	public int getIndent(){
		return indent;
	}
}
