/**
 * CET - CS Academic Level 3

 * This is the Lab3BinLinSearchTest class, where it holds all the methods that conduct all the operations such as displaying a random set
 * of arrays, finding specific numbers in them etc..
 * Student Name: Peyton Da Silva
 * Student Number:  041060238
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;



/**
 * The Lab3BinLinSearchTest class is a program that is able to perform recursive and iterative binary/linear searches on a random 32
 * element array. based on the menu option chosen a specific operation is performed, as well it handles any errors that could occur within
 * the selecting of the menu option process
 */

public class Lab3BinLinSearchTest {
	
	
	
	
	/**
     * The main method is is where all the menu options are displayed to the user and when each specific option is chosen a different 
     * operation will occur.
     * @param args The command-line arguments (not used).
     */
	
    public static void main(String[] args) {
        BinaryLinearSearch BinLinSearch = new BinaryLinearSearch(); // creating an object of BinaryLinearSearch class

        int choice = 0, key; // declaring instance variables

        do {
            System.out.println("\nSelect your option in the menu below:");
            System.out.println("1. Initialize and populate an array of 32 random integers.");
            System.out.println("2. Perform a recursive binary and linear search.");
            System.out.println("3. Perform iterative binary and linear search.");
            System.out.println("4. Exit");
            System.out.print("> ");

            try {
                choice = BinLinSearch.scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("*****Input Mismatch Exception*****");	//handles mismatch exception
                BinLinSearch.scanner.nextLine(); // Clear the input buffer
                continue; // Restart the loop
            }

            switch (choice) {
                case 1:
                	BinLinSearch.generateRandomInts();
                    break;

                case 2:
                    System.out.print("Please enter an integer value to search: ");

                    try {
                        key = BinLinSearch.scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("*****Input Mismatch Exception*****");
                        BinLinSearch.scanner.nextLine(); // Clear the input buffer
                        continue; // Restart the loop
                    }

                    
                    Arrays.sort(BinLinSearch.randArray);	// Sort the array before performing searches

                    System.out.println(Arrays.toString(BinLinSearch.randArray));	//prints the sorted array after deciding on the key
                    																//to search for
                    
                    //here is where the recursive binary search occurs
                    long startTime1 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.recursiveBinarySearch(key, 0, BinLinSearch.randArray.length - 1);
                    long endTime1 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.printcurrentTimeMillis(startTime1, endTime1);

                    
                  //here is where the recursive linear search occurs
                    long startTime2 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.recursiveLinearSearch(key, 0);
                    long endTime2 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.printcurrentTimeMillis(startTime2, endTime2);

                    break;

                case 3:
                    System.out.print("Please enter an integer value to search: ");

                    try {
                        key = BinLinSearch.scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("*****Input Mismatch Exception*****");
                        BinLinSearch.scanner.nextLine(); // Clear the input buffer
                        continue; // Restart the loop
                    }

                    
                    Arrays.sort(BinLinSearch.randArray);	// Sort the array before performing searches

                    System.out.println(Arrays.toString(BinLinSearch.randArray));

                    
                  //here is where the iterative binary search occurs
                    long startTime3 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.iterativeBinarySearch(key);
                    long endTime3 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.printcurrentTimeMillis(startTime3, endTime3);

                    
                    
                  //here is where the iterative linear search occurs
                    long startTime4 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.iterativeLinearSearch(key);
                    long endTime4 = BinLinSearch.getCurrentTimeNano();
                    BinLinSearch.printcurrentTimeMillis(startTime4, endTime4);

                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please choose an option from 1 to 4.");
            }
        } while (choice != 4);

        BinLinSearch.scanner.close(); // scanner closes and doesn't allow for any more input
    }
}//end of main method