import java.io.BufferedReader;
import java.util.StringTokenizer;

public class CommandParser {

    // Line counters
    public int currentLineNumber = 1;
    public int numberOfLines = 0;
    
    
    public Node parseInsert(BufferedReader inputData, Node q, Node head, String[] command) {
        /*
         * Performs operations of the 'input' command.
        */
        
        // Ensure that no additional parameters are passed by user
        if (command.length == 1) {
          
            String line = "";
            System.out.println("Enter text line by line. Enter '$' to stop.");
            
            try {
              
                while (!line.equals("$")) {
                  
                    // Read in data
                    line = inputData.readLine();
                    
                    if (!line.equals("$")) {
                         
                        // Reset to beginning
                        q = head;
                        
                        // Move to one before the current line
                        for (int i=0; i < this.currentLineNumber - 1; i++) {
                            q = q.next;
                        }

                        // Insert line before the current line
                        q.next = new Node(this.currentLineNumber + ":" + line, q.next); 
                        
                        // Increase line counters
                        this.numberOfLines++;
                        this.currentLineNumber++;
                            
                        // Ensure that line numbers are increased for lines after inserted line
                        refreshLineNumbersAfterInsert(q);  
                    }
                }
            
            } catch (Exception e) {
                System.out.println("Error " + e.toString());
            }
        
        // If user passes additional parameters, print error message
        } else {
            System.out.println("Invalid command. Too many parameters passed. Please try again.");
        }
        
        return q;
    }

    
    public void parseDelete(Node q, Node head, String[] command) {
        /*
         * Performs operations of the 'delete' command.
        */
      
        // Ensure two parameters are passed by user
        if (command.length == 3) {
          
            // Determine m and n
            int m = Integer.parseInt(command[1]);
            int n = Integer.parseInt(command[2]);
              
            if (n >= m) {
        
                // Reset to beginning
                q = head.next;
            
                // New node to copy node at n
                Node end = new Node();
            
                // Find node at n, save to Node 'end'
                for (int i=1; i<=this.numberOfLines; i++) {
                    int lineNum = Integer.parseInt(q.data.split(":")[0]);
                
                    if (lineNum == n) {
                        end = q;
                    }
                    q = q.next;
                } 
            
                // Reset to beginning
                q = head.next;

                // Set the node before m to point to the one after n
                for (int i=1; i<=this.numberOfLines; i++) {
                    int lineNum = Integer.parseInt(q.data.split(":")[0]);
                    if (lineNum == m - 1) {
                        q.next = end.next;
                        break;
                    }
                    q = q.next;
                }
                
                int diff = (n - m) + 1;
                this.numberOfLines = this.numberOfLines - diff;
                refreshLineNumbersAfterDelete(q, diff);
            
            } else {
                System.out.println("Invalid command. Please make sure n > m and try again.");
            }
        
        // If user passes less than two parameters, print error message
        } else if (command.length < 3) {
            System.out.println("Invalid command. Please indicated line numbers and try again.");
        
        // If user passes more than two parameters, print error message
        } else {
            System.out.println("Invalid command. Too many parameters were used.  Please try again.");
        }
    }
      
    
    public void parsePrint(Node q, Node head, String[] command) {
        /*
         * Performs operations of the 'print' command.
        */
        
        // If two parameters are passed by user, print lines between (inclusively)
        if (command.length == 3) {
        
            // Determine m and n
            int m = Integer.parseInt(command[1]);
            int n = Integer.parseInt(command[2]);
            
            if (n >= m) {
        
                // Reset to beginning
                q = head.next;
            
                // Print the data
                for (int i=1; i<=this.numberOfLines; i++) {
                    int lineNum = Integer.parseInt(q.data.split(":")[0]);
                    if (lineNum >= m && lineNum <= n) {
                        System.out.println(q.data);
                    }
                    q = q.next;
                }
            
            } else {
                System.out.println("Invalid command. Please make sure n > m and try again.");
            }
           
        // If no parameters are passed by user, print all lines
        } else if (command.length == 1) {
            
            // Reset to begining
            q = head.next;
            
            // Print the data
            while (q != null) {
                System.out.println(q.data);
                q = q.next;
            }
            
        // If only one parameter is passed by user, print error message
        } else if (command.length == 2) {
            System.out.println("Invalid command. Please indicate correct range and try again.");
        
        // If more than two parameters are passed by user, print error message
        } else {
            System.out.println("Invalid command. Too many parameters were used. Please try again.");
        }
    }
    
    
    public void parseLine(Node q, Node head, String[] command) {
        /*
         * Performs the operations of the 'line' command.
        */
        
        // Ensure that only one parameter is passed by user
        if (command.length == 2) {
                
            // Reset to beginning
            q = head.next;
            
            // Determine new current line number
            int newCurrentLineNumber = Integer.parseInt(command[1]);
        
            // Ensure that the new current line exists
            if (1 <= newCurrentLineNumber && newCurrentLineNumber <= this.numberOfLines) {
                
                // Set the new current line number
                this.currentLineNumber = newCurrentLineNumber;
                
                // Print 3 lines surrounding the current line in each direction
                for (int i=1; i<=this.numberOfLines; i++) {
                    int lineNum = Integer.parseInt(q.data.split(":")[0]);
                    if (lineNum >= this.currentLineNumber - 3 && lineNum <= this.currentLineNumber + 3) {
                        System.out.println(q.data);
                    }
                    q = q.next;
                }
                
            // If the line indicated by user does not exist, print error message
            } else {
                System.out.println("Line " + newCurrentLineNumber + " does not exist. Please try again.");
            }
         
        //  If no parameter is passed by user, print error message
        } else if (command.length == 1) {
            System.out.println("Invalid command. Please indicate line nubmer and try again.");
        
        // If more than one parameter is passed by user, print error message
        } else {
            System.out.println("Invalid command. Too many parameters were used. Please try agian.");
        }
    }

    
    public void parseSearch(Node q, Node head, String[] command) {
        /*
         * Performs the operations of the 'search' command.
        */
      
        // Ensure the user passes the string parameter
        if (command.length == 2) {
        
            // Reset to beginnign
            q = head.next;
            
            // Determine string parameter
            String searchString = command[1];
            Boolean found = false;
        
            // Search for string.  If found, print line and break out of all loops
            outerLoop: {
                for (int i=1; i<=this.numberOfLines; i++) {
                    String[] line = q.data.split(":");
                    StringTokenizer st = new StringTokenizer(line[1]);
                    while (st.hasMoreTokens()) {
                        String token = st.nextToken();
                        if (token.equals(searchString)) {
                            System.out.println(q.data);
                            found = true;
                            break outerLoop;
                        }
                    }
                    q = q.next;
                }
            }
            
            // If string not found, print message
            if (found == false) {
                System.out.println("'" + searchString + "' not found.");
            }
         
        // If no search string parameter passed by user, print error message
        } else if (command.length == 1) {
            System.out.println("Invalid command. Please indicate a search string and try again.");
        
        // If more than one search string passed by user, print error message
        } else {
            System.out.println("Invalid command. Too many parameters were used. Please try again.");
        }
    }
    
    
    public int getCurrentLineNumber() {
        /*
         * Returns the current line number.
        */
      
        return this.currentLineNumber;
    }
    
    
    public void refreshLineNumbersAfterInsert(Node q) {
        /*
         * Updates the line numbers after an insertion. 
         */
      
        // Move to line after insertion.
        q = q.next;
        q = q.next;
          
        // Add one to the line number for each line after insertion.
        while (q != null) {
            int lineNum = Integer.parseInt(q.data.split(":")[0]);
            String currentData = q.data.split(":")[1];
            int newLineNum = lineNum + 1;
            String newData = Integer.toString(newLineNum) + ":" + currentData;
            q.data = newData;
            
            q = q.next;
        }
      
    }
    
    
    public void refreshLineNumbersAfterDelete(Node q, int x) {
        /*
         * Updates the line numbers after an insertion. 
         */
      
        // Move to line after deletion.
        q = q.next;
          
        // Subract the number of lines deleted from the line number for each line after deletion.
        while (q != null) {
            int lineNum = Integer.parseInt(q.data.split(":")[0]);
            String currentData = q.data.split(":")[1];
            int newLineNum = lineNum - x;
            String newData = Integer.toString(newLineNum) + ":" + currentData;
            q.data = newData;
            
            q = q.next;
        }
      
    }
}