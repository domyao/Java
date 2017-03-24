package assignment3;
import java.util.Scanner;

/**
 * 
 * Assignment 3 Question1
 * 
 * @author DominicYao
 * @student_ID 40036290
 * @section WA winter 2017
 * @date March 15th 2017
 * 
 * @purpose: 
 * This program set 10 hockey teams, and simulate the dispensing of NHL miniature pucks 
 * until one of each 10 miniature team hockey pucks is dispensed.
 * Once at least one of each puck has been accumulated, display how many of each team puck have to be purchased, 
 * the total number of pucks purchased and the total cost in a personalized message
 */

public class PuckVendingMachine {
    
	public static final int TEAM_NUMBER = 10;
	public static final int COST_PER_TOONIE = 2;
	public static final String[] hockeyTeams = {"Montreal Canadians", "Boston Bruins", "Chicago BlackHawks",
									            "Detroit Red Wings", "New York Rangers", "Buffalo Sabres",
									            "Philadelphia Flyers", "Winnipeg Jets", "Vancouver Canucks",
									            "Ottawa Senators"}; 
	
	public static void main(String[] args) {
		
		int[] counterArray = new int [10];		
		String name = printWelcomeMessage(); //print welcoming message
		int totalPucks = dispensePucks(counterArray); // begin the dispensing process and fill the counterArray
		printResults(counterArray, hockeyTeams, name, totalPucks);
				
	}
	
	
	
	/**
	 * Print the welcoming messages.
	 * @return the name user entered
	 */
	public static String printWelcomeMessage(){
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("o                                                          o");
		System.out.println("o         NHL Miniature Hockey Puck Vending Machine        o");
		System.out.println("o                                                          o");
		System.out.println("============================================================\n");		
		System.out.println("Hello, what is your first name? ");	
		String name = userInput.nextLine();
		System.out.printf("Welcome %s! Let's see how much money you will need to spend to get all of the pucks.\n", name);
		System.out.println("(Press enter to continue)");
		userInput.nextLine();   // Pause the program and continue when the user hit enter.
		userInput.close();
		
		return name;
		
	}
	
	
	
	/**
	 * Dispense NHL miniature pucks until one of each 10 miniature team hockey pucks is dispensed.
	 * @param counterArray
	 * @return an integer representing the total pucks that have been dispensed
	 */
	public static int dispensePucks(int[] counterArray){	
		
		int dispensedTeams = 0;
		int totalPucks = 0;	
		
		while(dispensedTeams < TEAM_NUMBER){
			int randomNum = (int)(Math.random()*10);	
			//if the toonie of the team just dispensed haven't been dispensed before, then its corresponding counting value in the counterArray is 0
			//then increase the dispesedTeam variable by one, by the time the variable dispensedTeams reaches 10, it means 
			//all the teams has been dispensed. 
			if(counterArray[randomNum] == 0){
				dispensedTeams += 1;	
			}
			counterArray[randomNum] += 1;
			totalPucks += 1;		
		}		
		return totalPucks;
		
	}
	
	
	
	/**
	 * Print the details of the dispensing and the total cost.
	 * @param counterArray
	 * @param hockeyTeams
	 * @param name
	 * @param totalPucks
	 */
	public static void printResults(int[] counterArray, String[] hockeyTeams, String name, int totalPucks){
		System.out.println("Here is the breakdown of the pucks dispensed:\n");
		 for( int i = 0; i < counterArray.length; i ++){
			 System.out.printf("%s: %d\n",hockeyTeams[i], counterArray[i] );
		 }
		 
		 System.out.printf("\nWow %s, you bought a total of %d pucks at a total cost of $%d to get a miniature puck of each team."
		 		         + "\nEnjoy them!", name, totalPucks, totalPucks * COST_PER_TOONIE );
	}

}
