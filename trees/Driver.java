/* 
Matthew Bourque
4/5/14
Project 5

Algorithm:
        

Purpose:
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Driver {

  
    public static void main(String args[]) {
    /*
     * The main method.
    */
        
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        Tree tree = new Tree();
        TreeNode t = new TreeNode();
        
        try {
          
            listCommands();
            
            // Read in command from user
            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
            String line = inputData.readLine().toLowerCase();
            CommandParser cp = new CommandParser();
        
            while (!line.equals("done")) {
          
                switch (line) {
              
                    case "enter":
                        sequence = cp.parseEnter();
                        t = tree.build(t, sequence);
                        break;
                    case "inorder":
                        tree.inorder(t);
                        break;
                    case "postorder":
                        tree.postorder(t);
                        break;
                    case "count":
                        cp.parseCount();
                        break;
                    case "swap":
                        cp.parseSwap();
                        break;
                    case "compare":
                        cp.parseCompare();
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }
                  
                System.out.println("Enter another command:");
                line = inputData.readLine().toLowerCase();
                }
                
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }   
    } 
    
    public static void listCommands() {
    /*
     * Lists commands for user
    */
      
        System.out.println("Please enter a command.  Valid commands are:");
        System.out.println("\tEnter:");
        System.out.println("\tinorder:");
        System.out.println("\tpostorder:");
        System.out.println("\tcount:");
        System.out.println("\tswap:");
        System.out.println("\tcompare:");
        System.out.println("\tdone:");
    }
}