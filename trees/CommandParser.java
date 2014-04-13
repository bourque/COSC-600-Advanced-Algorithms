import java.util.*;

public class CommandParser {
 
    public ArrayList<Integer> parseEnter() {
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
    
    
    public void parseInorder() {
      
    }
    
    
    public void parsePostorder() {
      
    }
    
    
    public void parseCount() {
      
    }
    

    public void parseSwap() {
      
    }
    
    
    public void parseCompare() {
      
    } 
}