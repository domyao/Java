package assignment2.question3.purchaseManager;
import java.util.Scanner;


/**
 * 
 * 
 * This is the View class, the "view"  of the program.
 * Class View is in charge of all the outputs to the screen and inputs from the keyboard.
 * The title of each methods is self-explained. 
 *
 */
public class View {
    
	private Scanner input = new Scanner(System.in);
	 
	
	public void printWelcome(){
		System.out.println("------------------------------------");
		System.out.println("    Welcome to the program    ");
		System.out.println("------------------------------------\n\n");
		
	}
	
	
	public double promptForAssets(){
		
		System.out.print("Enter the initial amount:");
		return input.nextDouble();
		
		
	}
	
	public void comebackLater(){
		System.out.println("\nPlease save money and comeback later");
	}


	
	public String askIfPurchase(){
		System.out.print("\nDo you want to make a Purchase?(press y for yes, anyother input for No)");
		return input.next();	
		
	}

	
	public double promptForPrice(){
		System.out.print("\nPlease enter the price of the item: ");
		return input.nextDouble();
	}

	
	public String askIfContinue(){
		System.out.print("\nDo you want to cotinue? (Y/N)");
		return input.next();
		
	}
	
	public void lackOfDesire(){
		System.out.println("Lack of desire of Mr. Toto!");
		
	}
	
	public void insufficientAssets(){
		System.out.println("Insufficient assets!");
	}
	
	public void reachedMaxPurchases(){
		System.out.println("Maximum numbr of purchases is reached!");
	}
	
	public void purchaseAccepted(){
		System.out.println("A purchase is accepted.");
	}
	
	
	public void printRecords(int items, double assets, double spending){
		System.out.println("\n------------------------------------");
		System.out.println("Here is the summary of Mr.Toto's purchases:");
		System.out.println("------------------------------------\n");
		System.out.println("Number of items     assets    spending");
		System.out.printf( "       %d           %.2f      %.2f", items, assets, spending);
	}
	
	public void printGoodbye(){
		System.out.println("\n\nThank you for visit and Goodbye");
		input.close();
	}
	
}
