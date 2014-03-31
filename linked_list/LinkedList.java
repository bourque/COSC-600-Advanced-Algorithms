/* 
Matthew Bourque
3/21/2014
Project 4

Algorithm:

    Initialize new node q
    Read in command from user
    Split command by whitespace
    
    while command[0] != '$done':
    
        if command[0] == '$insert':
            if no additional parameters are given by user:
                prompt user to insert a line
                while line != "$stop":
                    read line
                    move q to one before the current line
                    insert line
                    refresh line numbers
            if additional parameters are given by user:
                print error message
    
        if command[0] == '$delete':
            if two parameters are given by user:
                q = head.next
                make newNode with data of line n
                q = head.next
                for each line of text:
                    if line m:
                        q.next = newNode.next
                Refresh line numbers
            if none, one, or more than two parameters are given by user:
                print error message
    
        if command[0] == '$print':
            if two parameters are given by user:
                q = head.next
                for each line of text:
                    determine line number
                    if line number between m and n (inclusively):
                        print line
             if no parameters are given by user:
                 q = head.next
                 for each line of text:
                     print line
             if one or more than two parameters are given by user:
                 print error message
    
        if command[0] == '$line':
            if one parameter is given by user:
                q = head.next
                if m is within valid number of lines:
                    Set current line number to m
                    for each line:
                        if line number within +/- 3 of m:
                            print line
                else:
                    print error message
            if none or more than one parameter is given by user:
                print error message
    
        if command[0] == '$search':
            q = head.next
            'found' flag = false
            for each line:
                use StringTokenizer to split line
                for each word in line:
                    if string == word:
                        print line
                        Set 'found' flag to true
            if 'found' flag still false:
                print message stating the string was not found
    
        Print out current line number
        Prompt user for another command

Purpose:

    This program serves as a simple line editor.  The following operations are
    supported:
    
    $insert
        Inserts a line before the current line (if indicated), otherwise inserts 
        a line at the end of the text.

    $delete m n
        Deletes each line between m and n, inclusively.

    $print m n
        Displays each line between m and n, inclusively, including line numbers.
        If m and n are not indicated, prints all lines.

    $line m
        Makes line m the current line, and display up to three lines before and after m.

    $search 'string'
        Searches for 'string' in the text. If found, displays the line containing the 
        first occurance of 'string'.

    $done
        Terminates the execution.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinkedList {
   
    
    public static void buildList() {
        /*
         * Builds and manages a linked list.
        */
    
        // Initialize nodes
        Node q = new Node("", null);
        Node head = q;
 
        try {
          
            listCommands();
            
            // Read in command from user
            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
            String line = inputData.readLine();
            CommandParser cp = new CommandParser();

            while(!line.equals("$done")) {
                String[] command = line.split("\\s+");
                
                // Call appropriate method based on command supplied by user
                switch(command[0]) {
                    case "$insert":
                        q = cp.parseInsert(inputData, q, head, command);                        
                        break;
                    case "$delete": 
                        cp.parseDelete(q, head, command); 
                        break;
                    case "$print": 
                        cp.parsePrint(q, head, command); 
                        break;
                    case "$line": 
                        cp.parseLine(q, head, command); 
                        break;
                    case "$search": 
                        cp.parseSearch(q, head, command); 
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                        break;
                }

                // Prompt user for next command
                System.out.println("\nThe current line is line " + cp.getCurrentLineNumber());
                System.out.println("Enter a command:");
                line = inputData.readLine();
            }    
            
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }
    }
    
    
    public static void listCommands() {
        /*
         * Lists commands for user input.
        */
    
        System.out.println("Please enter one of the following commands:\n");
        System.out.println("\t$insert");
        System.out.println("\t\tInsert a line before the current line (if indicated), otherwise insert a line at the end of the text.\n");
        System.out.println("\t$delete m n");
        System.out.println("\t\tDelete each line between m and n, inclusively.\n");
        System.out.println("\t$print m n");
        System.out.println("\t\tDisplay each line between m and n, inclusively, including line numbers.");
        System.out.println("\t\tIf m and n are not indicated, prints all lines.\n");
        System.out.println("\t$line m");
        System.out.println("\t\tMake line m the current line, and display up to three lines before and after m.\n");
        System.out.println("\t$search 'string'");
        System.out.println("\t\tSearch for 'string' in the text. If found, displays the line containing the first occurance of 'string'.\n");
        System.out.println("\t$done");
        System.out.println("\t\tTerminates the execution.\n");
    }
        

    public static void main(String args[]) {
        /*
         * The main method.
        */
      
        buildList();
        
    }
}