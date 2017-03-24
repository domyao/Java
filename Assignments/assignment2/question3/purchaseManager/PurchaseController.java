package assignment2.question3.purchaseManager;

/**
 *This is purchaseManager class, the "controller" of the whole program.
 *
 */

public class PurchaseController {
	
	private View views = new View();
	private Customer mrToto = new Customer();
	
	
	public void startProgram(){
		
		views.printWelcome();
		mrToto.setAssets(views.promptForAssets());
		
		// check ahead if Mr. Toto has sufficient assets, if not, ask him to come back later.		
		if(!mrToto.assetsSuficient()){
			views.comebackLater();		
		}
		
		// first ask if Mr. Toto wants to make a  purchase. if not, print "lack of desire" message
		else if(! views.askIfPurchase().equalsIgnoreCase("y")){ 
			views.lackOfDesire();				
		}
		
		// if he does want AND the initial purchase succeed, process to the scenario of future purchases
		// if the initial purchase failed, the "makeSinglePurchase" will be evaluated anyway.
		else if(makeSinglePurchase()){  
		    makePurchases();		
		}
					
		views.printRecords(mrToto.getItems(), mrToto.getAssets(), mrToto.getSpending());
		views.printGoodbye();
	}

	
	
	
	/**
	 * prompt user for the price of the item, and process a single purchase 
	 * @return 
	 * a boolean value to indicate the purchase results
	 * return true if the single purchase succeeds, false if not sufficient funds. 
	 */
	public boolean makeSinglePurchase(){
		
		double price = views.promptForPrice();
		
		if( mrToto.makePurchase(price)){
			views.purchaseAccepted();
			return true;
			
		}else{
			views.insufficientAssets();
			return false;
		}		
		
	}
	
	
	
   /**
    * Process the purchases
    */
	public void makePurchases(){
							
		String response = views.askIfContinue();				
		while (response.equalsIgnoreCase("y")){							
			
			// check ahead if Mr.Toto reached the maximum number of purchases
			// if yes, end purchases
			if(mrToto.maxPurchasesReached()){
				views.reachedMaxPurchases();
				return;
			}
			
			//make a single purchase and check if it succeeds at the same time when calling the makeSinglePurchases() method. 
			// if not, ends purchase, if yes, go back to the top of the loop.
			if(!makeSinglePurchase()){
				return;
			}
			
			response = views.askIfContinue();
		}
		views.lackOfDesire();
		return;				
		

	}
	
	
	
	
	
}
		
			
			

