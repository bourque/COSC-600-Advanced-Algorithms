/* 
Matthew Bourque
4/17/13
Optional Project 2

Algorithm:

Purpose:

*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;


public class Driver {
 

    public static void main(String args[]) {
        /*
         * The main method
        */
      
        // Generate file of random numbers
        makeNumberFile();
        
        // Initialize nodes
        Node q = new Node(0, null);
        Node head = q;
        
        // Make linked list containing the random numbers
        LinkedList list = new LinkedList();
        //Node insertNode = list.insert(q, head, "random_numbers.txt");
        //Node quickNode = list.insert(q, head, "random_numbers.txt");
        Node mergeNode = list.insert(q, head, "random_numbers.txt");
        //Node heapNode = list.insert(q, head, "random_numbers.txt");
        
        // Perform insertion sort and write result to "insertion.dat"
        //InsertionSort inserstionSort = new InsertionSort();
        //final long insertionSortBegin = System.currentTimeMillis();
        //Node sortedInsertion = inserstionSort.sort(insertNode.next);
        //final long insertionSortEnd = System.currentTimeMillis();
        //final long insertionSortTotal = insertionSortEnd - insertionSortBegin;
        //System.out.println("Insertion sort took: " + insertionSortTotal);
        //writeToFile(sortedInsertion, "insertion.dat");
        
        // Perform quick sort and write result to "quick.dat"
        //QuickSort quickSort = new QuickSort();
        //final long quickSortBegin = System.currentTimeMillis();
        //Node sortedQuick = quickSort.sort(quickNode.next);
        //final long quickSortEnd = System.currentTimeMillis();
        //final long quickSortTotal = quickSortEnd - quickSortBegin;
        //System.out.println("Quick sort took: " + quickSortTotal);
        //writeToFile(sortedQuick, "quick.dat");
        
        // Perform merge sort and write result to "merge.dat"
        MergeSort mergeSort = new MergeSort();
        final long mergeSortBegin = System.currentTimeMillis();
        Node sortedMerge = mergeSort.sort(mergeNode.next);       
        final long mergeSortEnd = System.currentTimeMillis();
        final long mergeSortTotal = mergeSortEnd - mergeSortBegin;
        System.out.println("Merge sort took: " + mergeSortTotal);
        writeToFile(sortedMerge, "merge.dat");
        
        // Perform heap sort and write result to "heap.dat"
        //HeapSort heapSort = new HeapSort();
        //final long heapSortBegin = System.currentTimeMillis();
        //Node sortedHeap = heapSort.sort(heapNode.next);       
        //final long heapSortEnd = System.currentTimeMillis();
        //final long heapSortTotal = heapSortEnd - heapSortBegin;
        //System.out.println("Heap sort took: " + heapSortTotal);
        //writeToFile(sortedHeap, "heap.dat");
    }
    
    
    public static void makeNumberFile() {
        /*
         * Creates a file containing 10,000 random numbers
        */
    
        int count = 0;
        Random random = new Random();
        String outputFile = "random_numbers.txt";
    
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            
            while (count <= 100) {
                int randomNumber = random.nextInt((100 - 0) + 1) + 0;
                writer.write(Integer.toString(randomNumber) + "\n");
                count ++;
            }
        writer.close();
        
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }   
    }
    
    
    public static void writeToFile(Node q, String outputFile) {
        /*
         * Writes the sorted list to the output file
        */
      
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            while (q != null) {
                System.out.println(q.data);
                writer.write(q.data);
                q = q.next;
            }
        writer.close();
        System.out.println("File written to " + outputFile);
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }            
    }
}