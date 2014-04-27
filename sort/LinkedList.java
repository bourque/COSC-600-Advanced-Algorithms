import java.io.File;
import java.util.Scanner;

public class LinkedList {
  
  
    public Node insert(Node q, Node head, String inputFile) {
        /*
         * Reads in integers from inputFile and inserts the numbers
         * into the linked list
        */
            
        q = head;
        
        try {
            Scanner input = new Scanner(new File(inputFile));
            while (input.hasNextInt()) {
                int num = input.nextInt();
                q.next = new Node(num, q.next);
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
        return q;
    }
}