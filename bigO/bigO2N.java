/* 
Matthew Bourque
3/2/2014
Project 3 Problem 8

Algorithm:

    Define list of integers for function input
    For each input:
        startTIme = current time
        call function
            Perform O(2^n) code
        endTime = current time
        totalTime = endTime - startTime
        print out totalTime

Purpose:

    This program serves as an example of O(2^n) running time program.
    It calculates the running time of the program for various inputs.
*/

class BigO_2 {
  
    public static void main(String args[]) { 
     
        int[] inputs = {1, 10, 20, 30, 40, 50, 60, 61};
        for(int i=0; i<inputs.length; i++){
            final long startTime = System.currentTimeMillis();
            func(inputs[i]);
            final long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            
            String outputTime = "";
            if (totalTime/1000 <= 1) {
                outputTime = Long.toString(totalTime) + " milliseconds";
            } else {
                outputTime = Long.toString(totalTime/1000) + " seconds";
            }
            
            System.out.println(String.format("Execution time for n=%d is %s", inputs[i], outputTime));
        }
    }
    
    public static int func(int n) {
    
        if (n <=1) return n;
        else return func(n-1) + func(n-2);
        }
    }