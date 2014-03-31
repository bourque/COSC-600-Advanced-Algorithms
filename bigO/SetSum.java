/* 
Matthew Bourque
3/2/2014
Project 3 Problem 4

Algorithm:

Purpose:

    Given a set S of real numbers and another number x, this program determines
    if there are two numbers in S whose sum is equal to x.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class SetSum {
 
  
    public static void main(String[] args) {
        /*
         * The main method.
        */
    
        int[] s = getSet();
        int x = getX();
        boolean check = sumInSet(s, x);
        printAnswer(check);
    }
    
    
    public static int[] getSet() {
        /*
         * Reads in set S from keyboard.
        */
        
        // Determine size of array.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the size of the input set: ");
        int size = keyboard.nextInt();
        
        // Read in set.
        int[] s = new int[size];
        System.out.println("Please enter a set of integers (s): ");
        for(int i=0; i<size; i++) {
            s[i] = keyboard.nextInt();
        }
        
        return s;
    }
    
    
    public static int getX() {
        /*
         * Reads in number x from keyboard.
        */
    
        int x;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter an integer number (x):");
        x = keyboard.nextInt();
        
        return x;
    }
    
    
    public static boolean sumInSet(int[] s, int x) {
        /*
         * Determines if there are two numbers in set s whose sum is equal to x.
        */
      
        int end_index = s.length - 1;
        int start_index = 0;
        Arrays.sort(s);
        
        while(start_index < end_index) {
          
            // If sum of endpoints == x, return true.
            if(s[start_index] + s[end_index] == x) {
                return true;
            // if sum of endpoints > x, reduce end index and try again.
            } else if(s[start_index] + s[end_index] > x) {
                end_index--;
            // if sum of endpoints < x, increase start index and try again.
            } else {
                start_index++;
            }
        }

        return false;
    }
    
    
    public static void printAnswer(boolean check) {
        /*
         * Prints result to the screen.
        */
      
        if(check == true) {
            System.out.println("There are two numbers in set s whose sum is equal to x");
        } else {
            System.out.println("There are NO two numbers in set s whose sum is equal to x");
        }
    }
}