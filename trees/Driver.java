/* 
Matthew Bourque
4/5/14
Project 5

Algorithm:
        

Purpose:
*/

import java.util.ArrayList;

class Driver {

  
    public static void main(String args[]) {
        /*
         * The main method.
        */
        
        int[] sequence1 = new int[] {60, 20, 100, 35, 15, 200, 75, 150, 6, 17, 40};
        int[] sequence2 = new int[] {60, 100, 20, 15, 35, 75, 200, 6, 17, 40, 150};
    
        Tree t1 = new Tree(sequence1);

        printInorder(t1);
        printPostorder(t1);
    }
    
    
    public static void printInorder(Tree t) {
        /*
         * Prints the sequence using inorder method
        */

        System.out.println("Inorder:");
        System.out.print("\t");
        t.inorder(t.root);
        System.out.println("");
    }
    
       
    public static void printPostorder(Tree t) {
        /*
         * Prints the sequence using postorder method
        */
      
        System.out.println("Postorder:");
        System.out.print("\t");
        t.postorder(t.root);
        System.out.println("");
    }
}