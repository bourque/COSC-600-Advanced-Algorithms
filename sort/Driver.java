/* 
Matthew Bourque
4/17/13
Optional Project 2

Algorithm:

Generate file of random integers
Build linked list from random integers
Build integer array from random integers

Grab current clock time
Perform insertion sort on linked list:
Grab current clock time
Compute and display total time it took for insertion sort
Write sorted linked list to a file

Grab current clock time
Perform quick sort on linked list:
Grab current clock time
Compute and display total time it took for quick sort
Write sorted linked list to a file

Grab current clock time
Perform merge sort on linked list:
Grab current clock time
Compute and display total time it took for merge sort
Write sorted linked list to a file

Grab current clock time
Perform heap sort on linked list:
Grab current clock time
Compute and display total time it took for heap sort
Write sorted array to a file

Purpose:
    This program serves to quantify the time complexity of four
    different sorting algorithms (1) Insertion sort, (2) Quick sort,
    (3) Merge sort, and (4) Heap sort.  An array of random integers
    are read in from a file and sorted using the four different
    techniques.  The execution time of each technique is clocked and
    printed to the screen for easy comparison between the four.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Driver {
 

    public static void main(String args[]) {
        /*
         * The main method
        */
      
        // Generate file of random numbers
        //makeNumberFile();
        
        // Initialize nodes
        Node q = new Node(0, null);
        Node head = q;
        
        // Make data structures containing the random numbers
        //LinkedList insertList = new LinkedList();
        //LinkedList quickList = new LinkedList();
        //LinkedList mergeList = new LinkedList();

        //Node insertNode = insertList.insert(q, head, "random_numbers.txt");
        //Node quickNode = quickList.insert(q, head, "random_numbers.txt");
        //Node mergeNode = mergeList.insert(q, head, "random_numbers.txt");
        int[] heapArray = getHeapArray("random_numbers.txt");
        
        // Perform insertion sort and write result to "insertion.dat"
        //InsertionSort inserstionSort = new InsertionSort();
        //final long insertionSortBegin = System.currentTimeMillis();
        //Node sortedInsertion = inserstionSort.sort(insertNode.next);
        //final long insertionSortEnd = System.currentTimeMillis();
        //final long insertionSortTotal = insertionSortEnd - insertionSortBegin;
        //System.out.println("Insertion sort took: " + insertionSortTotal + " ms");
        //writeToFile(sortedInsertion, "insertion.dat");
        
        // Perform quick sort and write result to "quick.dat"
        //QuickSort quickSort = new QuickSort();
        //final long quickSortBegin = System.currentTimeMillis();
        //Node sortedQuick = quickSort.sort(quickNode.next);
        //final long quickSortEnd = System.currentTimeMillis();
        //final long quickSortTotal = quickSortEnd - quickSortBegin;
        //System.out.println("Quick sort took: " + quickSortTotal + " ms");
        //writeToFile(sortedQuick, "quick.dat");
        
        // Perform merge sort and write result to "merge.dat"
        //MergeSort mergeSort = new MergeSort();
        //final long mergeSortBegin = System.currentTimeMillis();
        //Node sortedMerge = mergeSort.sort(mergeNode.next);       
        //final long mergeSortEnd = System.currentTimeMillis();
        //final long mergeSortTotal = mergeSortEnd - mergeSortBegin;
        //System.out.println("Merge sort took: " + mergeSortTotal + " ms");
        //writeNodeToFile(sortedMerge, "merge.dat");
        
        // Perform heap sort and write result to "heap.dat"
        HeapSort heapSort = new HeapSort();
        final long heapSortBegin = System.currentTimeMillis();
        int[] sortedHeap = heapSort.sort(heapArray);       
        final long heapSortEnd = System.currentTimeMillis();
        final long heapSortTotal = heapSortEnd - heapSortBegin;
        System.out.println("Heap sort took: " + heapSortTotal + " ms");
        writeArrayToFile(sortedHeap, "heap.dat");
    }
    
    
    public static void makeNumberFile() {
        /*
         * Creates a file containing random numbers
        */
    
        int count = 0;
        Random random = new Random();
        String outputFile = "random_numbers.txt";
    
        try {
            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            while (count <= 5000) {
                int randomNumber = random.nextInt();
                writer.println(Integer.toString(randomNumber));
                count ++;
            }
        writer.close();
        
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }   
    }
    
    
    public static void writeArrayToFile(int[] array, String outputFile) {
        /*
         * Writes the sorted array to the output file
        */
      
        try {
            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            for (int i = array.length - 1; i >= 0; i--) {
                writer.println(array[i]);
            }
        writer.close();
        System.out.println("File written to " + outputFile);
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }            
    }
    
    
    public static void writeNodeToFile(Node q, String outputFile) {
        /*
         * Writes the sorted node to the output file
        */
      
        try {
            PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
            while (q != null) {
                writer.println(q.data);
                q = q.next;
            }
        writer.close();
        System.out.println("File written to " + outputFile);
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }            
    }
    
    
    public static int[] getHeapArray(String inputFile) {
        /*
         * Constructs an integer array with the random numbers
         * read in from the input file
        */
      
        int[] heapArray = new int[5000];
     
        try {
            Scanner input = new Scanner(new File(inputFile));
            for (int i=0; i<heapArray.length; i++) {
                heapArray[i] = input.nextInt(); 
            }
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        return heapArray;
    }
}