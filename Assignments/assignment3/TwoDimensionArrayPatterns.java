package assignment3;
import java.util.Scanner;
/**
 * 
 * Assignment 3 Question 2
 * 
 * @author DominicYao
 * @student_ID 40036290
 * @section WA winter 2017
 * @date March 15th 2017
 * 
 * @purpose:
 * This program is to filled 2 2d array with 2 different pattern, and print them out.
 * The size of the array is input by the user and must be greater than or equal to 3.
 * if the size if 5 the output pattern should be like this:
 * 
	Pattern number 1
	   1   2   3   4   5
	  10   9   8   7   6
	  11  12  13  14  15
	  20  19  18  17  16
	  21  22  23  24  25
	
	Pattern number 2
	   1   2   3   4   5
	  10   6   7   8   9
	  14  15  11  12  13
	  18  19  20  16  17
	  22  23  24  25  21

 * 
 */

public class TwoDimensionArrayPatterns {

	public static void main(String[] args) {
		
		int size = welcomeToTheProgram();
		int[][] array1 = new int[size][size];
		int[][] array2 = new int[size][size];
		
		fillWithPattern1(array1, size);
		fillWithPattern2(array2, size);
		System.out.println("\nPattern number 1");
		print2DArray(array1, size);
		System.out.println("\nPattern number 2");
		print2DArray(array2, size);
		
		System.out.println("\nAll done!");

	}
    
	
	
	/**
	 * the start of the program, print welcome message and ask user for the size of the array.
	 * @return the size user entered
	 */
	public static int welcomeToTheProgram(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("[-----------------------]");
		System.out.println("[      Array Pattern    ]");
		System.out.println("[-----------------------]\n");
		
		System.out.println("How many rows/colums do you want your array to have? (must be at least 3)");
		int size = userInput.nextInt();
		while(size < 3){
			System.out.println("Let's try again...");
			System.out.println("How many rows/colums do you want your array to have? (must be at least 3)");
			size = userInput.nextInt();
		}
	    userInput.close();
	    return size;
	}

	
	
	/**
	 * fill a 2D array with pattern 1
	 * @param array
	 * @param size
	 */
	public static void fillWithPattern1(int[][] array, int size){
		int number = 1; 
		for(int row = 0; row < size; row ++){ 
			if(row % 2 == 1){         // if the row is in 1,3,5... fill that row in a reversed order.
				for(int colum = size - 1; colum >= 0; colum --, number ++){
					array[row][colum] = number;
				}
			}
			else{
				for(int colum = 0; colum < size; colum ++, number ++){
					array[row][colum] = number; 
				}			
			}			
		}	
	}
	
	
	
	/**
	 * 
	 * Fill a 2D array with the pattern 2
	 * @param array
	 * @param size
	 */
	public static void fillWithPattern2(int[][] array, int size){
		int number = 1;
		for(int row = 0; row < size; row ++){
			int columStartIndex = row; 
			// this is the variable indicating start from which column to fill the number in each row
			
			for(int colum = 0; colum < size; colum ++, columStartIndex ++, number ++){
				array[row][columStartIndex % size] = number;  
				// this is the core part of the logic, columStartIndex starts from the index the same as the row number, and go around tht row
				// for example, if the size if 3, on the second row, row 1, fill the row starting from index 1, columStartIndex % size is 1%3 = 1, then 2%3 = 2, and then 3%3 = 0!! it goes back to the beginning!!		
			}
		}
	}
	
	
	
	/**
	 * Print a 2D array
	 * @param array
	 */
	public static void print2DArray(int[][] array, int size){
		for(int row = 0; row < size; row ++){
			for(int column = 0; column < size; column ++){
				System.out.printf("%4d", array[row][column]);
			}
			System.out.println();
		}
	}
}
