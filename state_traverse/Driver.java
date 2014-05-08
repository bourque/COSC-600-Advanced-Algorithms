/* 
Matthew Bourque
5/1/14
Project 6

Algorithm:
    Read in file
    Build graph via adjacency list:
        For line in input file:
            Initialize linked list with new node (node.data = line number)
            Split input line into tokens
            For each token:
                node.next = token
    Ask user for which state to begin with            
    Traverse graph using Depth First Traversal:
        void DFS (node p) {
            print state represented by p.data
            set p to visited
            for all vertices adjacent to p:
                if vertex is unvisited:
                    DFS(vertex)
        }   
    Traverse graph using Breadth First Traversal:
        void BFS (node p) {
            Initialize new queue
            print state represented by p.data
            queue.enq(p)
            set p to visited
            while queue is not empty:
                n = queue.deq()
                for all vertices adjacent to n:
                    if vertex is unvisited:
                        queue.enq(vertex)
                        set vertex to visited
        }

Purpose:
    This program builds a graph representing the map of the continental
    United States and traverses the map using two techniques: (1) Depth
    First Traversal and (2) Breadth First Traversal.  The names of the
    states are printed to the screen as they are met for the first time.
    The input should be a file containing numbers representing adjacent
    states (i.e. the i'th line should contain space-separated numbers
    representing the states adjacent to state i).
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Driver {

    public static void main(String[] args) {
        /*
         * The main method
        */
      
        Node[] mapForDFS = getMap();
        Node[] mapForBFS = getMap();
        
        int beginState = getBeginState();
      
        Graph graphForDFS = new Graph(mapForDFS);
        System.out.println("Traversing map using Depth First Traversal:\n");
        graphForDFS.DFS(mapForDFS[beginState]);
        
        Graph graphForBFS = new Graph(mapForBFS);
        System.out.println("\n\nTraversing map using Breadth First Traversal:\n");
        graphForBFS.BFS(mapForBFS[beginState]);
    }
    
    
    public static Node[] getMap() {
        /*
         * Builds map by reading in input file using adjacency list
         * representation
        */
      
        // Initialize Adjecency List
        Node[] map = new Node[48];
        
        try {
            // Read in data line by line
            BufferedReader br = new BufferedReader(new FileReader("map_data.dat"));
            String line;
            for (int i=0; i<map.length; i++) {
                line = br.readLine();
                
                // Split each line into integer tokens
                StringTokenizer st = new StringTokenizer(line);
                
                // Initialze new node with index
                Node q = new Node(i+1, false, null);
                Node head = q;
                
                // Point node to remaining tokens
                while (st.hasMoreTokens()) {
                    q.next = new Node(Integer.parseInt(st.nextToken()), false, null);
                    q = q.next;
                }
                
                // Add linked list to adjecency list
                map[i] = head;
            }
            br.close();
            
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
        return map;
    }
    
    
    public static int getBeginState() {
        /*
         * Asks user which state to begin with for traversal
        */

        Scanner keyboard = new Scanner(System.in);
        printStateOptions();
        int beginState = keyboard.nextInt();
        
        return beginState - 1;
    }
    
    
    public static void printStateOptions() {
        /*
         * Prints the keyboard input options to the screen
        */

        System.out.println("Please enter a state to use as starting point:");
        
        System.out.println("\t1:Washington");
        System.out.println("\t2:Oregon");
        System.out.println("\t3:Califronia");
        System.out.println("\t4:Nevada");
        System.out.println("\t5:Idaho");
        System.out.println("\t6:Montana");
        System.out.println("\t7:Utah");
        System.out.println("\t8:Arizona");
        System.out.println("\t9:Wyoming");
        System.out.println("\t10:Colorado");
        System.out.println("\t11:New Mexico");
        System.out.println("\t12:Texas");
        System.out.println("\t13:Oklahoma");
        System.out.println("\t14:Kansas");
        System.out.println("\t15:Nebraska");
        System.out.println("\t16:South Dakota");
        System.out.println("\t17:North Dakota");
        System.out.println("\t18:Minnesota");
        System.out.println("\t19:Iowa");
        System.out.println("\t20:Missouri");
        System.out.println("\t21:Arkansas");
        System.out.println("\t22:Louisiana");
        System.out.println("\t23:Mississippi");
        System.out.println("\t24:Tennessee");
        System.out.println("\t25:Kentucky");
        System.out.println("\t26:Illinois");
        System.out.println("\t27:Wisconsin");
        System.out.println("\t28:Michigan");
        System.out.println("\t29:Indiana");
        System.out.println("\t30:Ohio");
        System.out.println("\t31:Pennsylvania");
        System.out.println("\t32:New York");
        System.out.println("\t33:Vermont");
        System.out.println("\t34:New Hampshire");
        System.out.println("\t35:Maine");
        System.out.println("\t36:Massachusetts");
        System.out.println("\t37:Rhode Island");
        System.out.println("\t38:Connecticut");
        System.out.println("\t39:New Jersey");
        System.out.println("\t40:Delaware");
        System.out.println("\t41:Maryland");
        System.out.println("\t42:West Virginia");
        System.out.println("\t43:Virginia");
        System.out.println("\t44:North Carolina");
        System.out.println("\t45:South Carolina");
        System.out.println("\t46:Georgia");
        System.out.println("\t47:Alabama");
        System.out.println("\t48:Florida");
    }
}