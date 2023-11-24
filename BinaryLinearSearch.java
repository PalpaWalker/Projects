/** CET - CS Academic Level 3

 * This is the driver class and it contains the main method, along with the displayMainmenu method
 * Student Name: Peyton Da Silva
 * Student Number:  041060238
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
  

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



/**
 * The BinaryLinearSearch class includes methods for performing binary and linear search operations on a random 32 element array, as well
 * as the time it takes to search for the selected element by the user from the array.
 */

public class BinaryLinearSearch {
    int[] randArray; // Array to store randomly generated integers
    Scanner scanner;

    
    
    
    /**
     * Creates a BinaryLinearSearch object. Initializes the randomArr array with a size of 32 and creates a Scanner object for user input.
     */
    
    public BinaryLinearSearch() {
        randArray = new int[32];	//the randArr is setting its value to 32, to be able to display the random set of 32 numbers
        scanner = new Scanner(System.in);
    }

    
    
    
    
    
    /**
     * This method is where the values in the 32 element array are generated randomly.
     * it then prints the unsorted and sorted arrays.
     */
    
    public void generateRandomInts() {
        Random rand = new Random();
        for (int i = 0; i < randArray.length; i++) {	// Generate random numbers and store them in the randomArr array
            randArray[i] = rand.nextInt(90) + 11; // Generate random numbers between 10 and 100 (exclusive)
        }
        System.out.println("Unsorted array: " + Arrays.toString(randArray));
        Arrays.sort(randArray);	// Sort the array in ascending order
        System.out.println("Sorted array: " + Arrays.toString(randArray));
    }

    
    
    
    /**
     * Performs a recursive binary search on the randomArr array, based off of the key value inputted by the user.
     * 
     * @param key  The integer value to search for.
     * @param low  The lower bound index for the search.
     * @param high The upper bound index for the search.
     * @return The index position where the key was found, or -1 if not found.
     */
    
    public int recursiveBinarySearch(int key, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (randArray[mid] == key) {
                System.out.println(key + " was found at index position " + mid + ": Recursive Binary Search");	// Key found at mid index using recursive binary search
                return mid;
            } else if (randArray[mid] < key) {
                return recursiveBinarySearch(key, mid + 1, high);	// Key is greater than the element at mid index, search in the right half of the array
            } else {
                return recursiveBinarySearch(key, low, mid - 1);	// Key is smaller than the element at mid index, search in the left half of the array
            }
        }
        System.out.println(key + " was not found: Recursive Binary Search");	// Key not found using recursive binary search
        return -1;
    }
    
    
    
    
    /**
     * Performs a recursive linear search on the randomArr array, based off of the key value inputted by the user.
     * 
     * @param key   The integer value to search for.
     * @param index The current index position for the search.
     * @return The index position where the key was found, or -1 if not found.
     */

    public int recursiveLinearSearch(int key, int index) {
        if (index >= randArray.length) {
            System.out.println(key + " was not found: Recursive Linear Search");	// Key not found using recursive linear search
            return -1;
        }
        if (randArray[index] == key) {
            System.out.println(key + " was found at index position " + index + ": Recursive Linear Search");	// Key found at index position using recursive linear search
            return index;
        }
        return recursiveLinearSearch(key, index + 1);	// Continue searching in the remaining elements using recursive linear search
    }

    
    
    
    
    
    
    /**
     * Performs an iterative binary search on the randomArr array, based off of the key value inputted by the user.
     * 
     * @param key The integer value to search for.
     * @return The index position where the key was found, or -1 if not found.
     */
    
    public int iterativeBinarySearch(int key) {
        int low = 0;
        int high = randArray.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (randArray[mid] == key) {
                System.out.println(key + " was found at index position " + mid + ": Iterative Binary Search");	// Key found at mid index using iterative binary search
                return mid;
            } else if (randArray[mid] < key) {
                low = mid + 1;	// Key is greater than the element at mid index, search in the right half of the array
            } else {
                high = mid - 1;	// Key is smaller than the element at mid index, search in the left half of the array
            }
        }
        System.out.println(key + " was not found: Iterative Binary Search");	// Key not found using iterative binary search
        return -1;
    }

    
    
    
    
    
    
    
    /**
     * Performs an iterative linear search on the randomArr array, based off of the key value inputted by the user.
     * 
     * @param key The integer value to search for.
     * @return The index position where the key was found, or -1 if not found.
     */
    
    public int iterativeLinearSearch(int key) {
        for (int i = 0; i < randArray.length; i++) {
            if (randArray[i] == key) {
                System.out.println(key + " was found at index position " + i + ": Iterative Linear Search");	// Key found at index position using iterative linear search
                return i;
            }
        }
        System.out.println(key + " was not found: Iterative Linear Search");	// Key not found using iterative linear search
        return -1;
    }

    
    
    
    
    /**
     * Gets the current time taken for the search in nanoseconds.
     * 
     * @return The current time in nanoseconds.
     */
    
    long getCurrentTimeNano() {	//getting current time in Nano-seconds
        return System.nanoTime();
    }
    
    
    
    
    
    /**
     * Prints the time taken for the search to find the value selected in both nanoseconds and milliseconds.
     * 
     * @param startTime The start time of the operation in nanoseconds.
     * @param endTime   The end time of the operation in nanoseconds.
     */

    void printcurrentTimeMillis(long startTime, long endTime) {	//printing the start and end times
        long elapsedTimeNano = endTime - startTime;	//calculating the time taken in Nano-seconds
        long elapsedTimeMillis = elapsedTimeNano / 1_000_000;	//convert that to milliseconds
        System.out.println("Time taken in nanoseconds: " + elapsedTimeNano);
        System.out.println("Time taken in milliseconds: " + elapsedTimeMillis);
    }
}//end of BinaryLinearSearch class