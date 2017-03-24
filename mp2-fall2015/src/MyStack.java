

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Implementation of a simple stack for HtmlTags.
 * @author DominicYao (Chenyu yao) #38186145
 *
 */

public class MyStack {

	private ArrayList<HtmlTag> stack_internal;
	
	
	/**
	 * Construct an empty stack.
	 */
	public MyStack() { 
		this.stack_internal = new ArrayList<HtmlTag>( );
	}
	
	
	
	/** 
	 * <b>Push</b> a tag onto the top of the stack.
	 * @param tag -- a HtmlTag
	 */
	public void push( HtmlTag tag ) {
		stack_internal.add(tag);
		
	}
	
	
	
	/**
	 * <b>Removes</b> the tag at the top of the stack.
	 * 
	 * @return the removed tag
	 * @throws EmptyStackException If the stack is empty
	 */
	public HtmlTag pop() {
		
		
		if( stack_internal.isEmpty()){
			throw new EmptyStackException();
		}
		
		HtmlTag tagHolder = stack_internal.get(stack_internal.size()-1);
		stack_internal.remove(stack_internal.size()-1);
		return tagHolder;
	
				
		
	}
	
	
	
	/**
	 * Looks at the object at the top of the stack but does not actually remove the object.
	 * 
	 * @return the object at the top of the stack
	 * @throw EmptyStackException if the stack is empty.
	 */
	public HtmlTag peek() throws EmptyStackException{
//		
//		if(stack_internal.isEmpty()){
//			throw new EmptyStackException();
//		}
		
		return stack_internal.get(stack_internal.size() - 1);
		
	}
	
	
	/**
	 * Tests if the stack is empty.
	 * @return true if the stack is empty; false otherwise.
	 */
	
	public boolean isEmpty() {
		return(stack_internal.isEmpty());
		
	}
}
