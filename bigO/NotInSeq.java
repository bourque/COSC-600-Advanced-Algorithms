/* 
Matthew Bourque
3/2/2014
Project 3 Problem 4

Algorithm:

Read in sequence of integers from keyboard
For each number in sequence:
    if number != first number in sequence + index:
         result = first number in sequence + index:
Print out result

Purpose:

    This program identifies a number that is not in a given sequence of n
    real numbers.
*/

import java.util.ArrayList;
import java.util.Scanner;


class NotInSeq {
 
  
    public static void main(String[] args) {
        /*
         * The main method.
        */
    
        ArrayList<Integer> sequence = getSequence();
        notInSequence(sequence);
    }
    
    
    public static ArrayList<Integer> getSequence() {
        /*
         * Reads in sequence of integers from keyboard.
        */
    
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a sequence of integers. Enter 'q' to quit.");
        while (keyboard.hasNextInt()) {
            sequence.add(keyboard.nextInt());
        }
        
        return sequence;
    }
    
    
    public static void notInSequence(ArrayList<Integer> sequence) {
        /*
         * Identifies a number that is not in the sequence. If sequence
         * has no "holes", a message is printed stating that all possible
         * integers are in the given sequence.
        */
      
        int notInSeq = -99999999;
        for (int i=0; i<sequence.size(); i++) {
            if (sequence.get(i) != sequence.get(0) + i){
                notInSeq = sequence.get(0) + i;
                break;
            }
        }
        
        // If notInSeq has not changed, there were no numbers that were not
        // in the sequence.
        if (notInSeq != -99999999) {
            System.out.println(notInSeq + " is not in the given sequence.");
        } else {
            System.out.println("All possible integers are in the given sequence.");
        }
    }
}