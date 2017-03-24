package assignment3.question3.locksmith;


/**
 * Assignment 3 Question3
 * 
 * @author DominicYao
 * @student_ID 40036290
 * @section WA winter 2017
 * @date March 16th 2017
 * 
 * this is the CombinationLock class. It simulates a combination locks with methods resembling its functionalities. 
 */
public class CombinationLock {
	
	
	private int num1, num2, num3;
	private boolean status;
	
	
	/**
	 * sets the 3 combination numbers to zero and marks the lock as closed.
	 */
	public CombinationLock(){
		this.num1 = 0;
		this.num2 = 0;
		this.num3 = 0;
		this.status = false;
	}
    
	
	/**
	 * sets the 3 combination numbers to the three passed integers and marks the lock as open.
	 * @param code1
	 * @param code2
	 * @param code3
	 */
	public CombinationLock(int num1, int num2, int num3){
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.status = true;
	}
	
	
	/**
	 * @return a string representation of the combination of the lock in the following format: 
	 *         Clockwise num1 – Counter-Clockwise num2 – Clockwise num3
	 */
	public String toString(){
		return "clockwise " + this.num1 + 
	           " - Counter-Clockwise " + this.num2 + 
	           " - Clockwise " + this.num3 ;
	}
	
	
	/**
	 * test for equality of the combination of two objects of class CombinationLock regardless of the open status
	 * @return true is two are the same, false otherwise
	 */
	public boolean equals(CombinationLock otherLock){
		return (this.num1 == otherLock.num1 && this.num2 == otherLock.num2 && this.num3 == otherLock.num3);		
	}
	
	
	/**
	 * A Boolean mutator method that sets the 3 combination numbers to the 3 passed numbers. 
	 * It can only change the combination if the lock is closed. 
	 * @param code1
	 * @param code2
	 * @param code3
	 * @return false if the lock is already opened, true after it has reset the combination.
	 */
	public boolean setCombination(int num1, int num2, int num3){
		if(this.status){
			return false;
		}
		
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		return true;
	}
	
	
	/**
	 * set the status of the lock as closed
	 */
	public void closeClock(){
		this.status = false;
	}
	
	
	/**
	 * 
	 * @returns true if the lock is open and false if it is closed.
	 */
	public boolean isLockOpen(){
		return this.status;
	}
	
	
	/**
	 * checks if the supplied combination is the correct one
	 * @param num1
	 * @param num2
	 * @param num3
	 * @returns true if it is correct it sets the status to open and false if it is incorrect
	 */
	public boolean openLock(int num1, int num2, int num3){
		if(this.num1 == num1 && this.num2 == num2 && this.num3 == num3){
			this.status = true;
			return true;
		}
		return false;
	}
	
	
	/**
	 * count the correct numbers in the supplied combination
	 * @param num1
	 * @param num2
	 * @param num3
	 * @returns the count
	 */
	public int HowManyCorrect(int num1, int num2, int num3){
		int count = 0;
		if(this.num1 == num1){
			count ++;
		}
		
		if(this.num2 == num2){
		    count ++;
		}
		
		if(this.num3 == num3){
			count ++;
		}
		return count;
		
	}
	
}
