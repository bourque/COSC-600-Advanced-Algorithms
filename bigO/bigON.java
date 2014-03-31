/* 
Matthew Bourque
3/2/2014
Project 3 Problem 8

Algorithm:

    Define list of integers for function input
    For each input:
        startTIme = current time
        call function
            Perform O(n) code
        endTime = current time
        totalTime = endTime - startTime
        print out totalTime

Purpose:

    This program serves as an example of O(n) running time program.
    It calculates the running time of the program for various inputs.
*/

class BigO_1 {
  
    public static void main(String args[]) { 
     
        int[] inputs = {10, 100, 1000, 10000, 100000};
        for(int i=0; i<inputs.length; i++){
            final long startTime = System.nanoTime();
            func(inputs[i]);
            final long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(String.format("Execution time for n=%d is %d nanoseconds", inputs[i], totalTime));
        }
    }
    
    public static int func(int n) {
    
        int sum = 0;
        for(int j=0; j<n; j++) {
            sum = sum + j;
        }
        return sum;
    }
}
 