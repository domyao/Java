package assignment3.question3.locksmith;
import java.util.Scanner;

/**
 *This is the driver to test the CombinationLock class 
 */
public class CombinationLockMain {

	public static void main(String[] args) {
		System.out.println("|-----------------------------|");
		System.out.println("|      LockSmith Program      |");
		System.out.println("|-----------------------------|\n");
        
		//Declare 2 CombinationLock objects
		CombinationLock lock1 = new CombinationLock();
		CombinationLock lock2 = new CombinationLock(3, 5, 7);		
		System.out.println("Combination for lock 1 is: " + lock1);
		System.out.println("Combination for lock 1 is: " + lock2);
		
		//Open one of the locks, lock 1
		System.out.println("\n==> Attempting to open lock1");	
		if(!lock1.openLock(2, 3, 4)){
			System.out.println("Sorry the combination you supplied for lock 1 is incorrect");
		}	
		if(lock1.openLock(0, 0, 0)){
			System.out.println("Congratulations you opened lock 1");
		}
			
		
		//Change the combination of one of the locks, lock 1
		System.out.println("\n==> Attempting to change the combination of lock 1");
		if(lock1.isLockOpen()){
			System.out.println("You can't change the combination if the lock is open. Close the lock and try again");
		}
		lock1.closeClock();
		if(!lock1.isLockOpen()){
			lock1.setCombination(5, 11, 9);
			System.out.println("Congratulations you successfully changed the combination of lock 1 to " + lock1);			
		}
		
		
		//Open the other lock
		System.out.println("\n===>  Attempting to open lock 2");
		System.out.printf("%d of the numbers are correct. Try again.\n", lock2.HowManyCorrect(3, 6, 11));
		lock2.openLock(3, 5, 7);
		if(lock2.isLockOpen()){
			System.out.println("Congratulations you opened lock 2.");
		}
		
		//Check 2 locks for equality
		System.out.println("\n===> Testing the two locks for equality");
		System.out.println("Lock1 combination is: " + lock1);
		System.out.println("Lock2 combination is: " + lock2);
		if(!lock1.equals(lock2)){
			System.out.println("Combination of both locks is the NOT same");		
		}
		if(!lock1.isLockOpen()){
			System.out.println("Lock1 is not open");
		}
		if(lock2.isLockOpen()){
			System.out.println("lock2 is open\n");
		}
		
		lock1.setCombination(3, 5, 7);
		System.out.println("Lock1 combination is: " + lock1);
		System.out.println("Lock2 combination is: " + lock2);
		if(lock1.equals(lock2)){
			System.out.println("Combination of both locks is the same");		
		}
		if(!lock1.isLockOpen()){
			System.out.println("Lock1 is not open");
		}
		if(lock2.isLockOpen()){
			System.out.println("lock2 is open\n");
		}
		
		
		System.out.println("Testing for the CombinationLock class is finished, y'all good!");
	}

}
