package assignment2.question3.purchaseManager;

/**
 * 
 * Assignment 2 Question 3
 * 
 * @author DominicYao
 * @student_ID 40036290
 * @section WA winter 2017
 * @date Feb 5th 2017
 * 
 * @purpose:
 * this program manages a customer, as a example, Mr. Toto's purchases by considering these following points:
 * 
	a) Mr. Toto is invited to go to his favorite store only if he has more than $100,
	otherwise it will be suggested to him to save money and come back later!
	
	b) Mr. Toto must not leave the store with less or equal than $ 10 in his pocket. (Think to the
	taxi he must take to go home).
	
	c) Mr. Toto should not buy more than 10 items. But he can buy less or not at all,
	according to his mood of the day ... We will check if he wants to buy. It will be up
	to Mr. Toto to specify, each time, the price of the item he covets. And a purchase
	is accepted only if it is within the means of Mr. Toto. (No credit, no ease of
	payment). Moreover, Mr. Toto will not try to make a purchase that has already
	been refused!
	
	d) In the event that Mr. Toto has gone into the store, the program displays - at
	the end of the shopping - the following messages those that apply:
	
		 "Insufficient assets",
		 "lack of desire of Mr. Toto",
		 "Maximum number of purchases is reached".
		
	e) At the end of the program, Mr. Toto will be advised to go home, by indicating to
	him the summary of his purchases, as follows:
	
		 the number of items he has purchased,
		 the amount spent, and
		 the amount he will still have in his pocket.
	
		
 * This program applied MVC (Model-view-controller) design concept, separated the program into three classes.
 * The model is Customer class, view is the View class, controller is the purchaseManager class.
 * the purchaseManager class connect the MrToto class and View class together to make the complete program. 
 * 
 */
public class Main {

	public static void main(String[] args) {
		PurchaseController purchaseManager = new PurchaseController();
		purchaseManager.startProgram();

	}

}
