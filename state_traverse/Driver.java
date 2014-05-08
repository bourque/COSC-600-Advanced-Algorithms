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
import java.util.StringTokenizer;

public class Driver {

    public static void main(String[] args) {
        /*
         * The main method
        */
      
        Node[] mapForDFS = getMap();
        Node[] mapForBFS = getMap();
      
        Graph graphForDFS = new Graph(mapForDFS);
        System.out.println("Traversing map using Depth First Traversal:\n");
        graphForDFS.DFS(mapForDFS[0]);
        
        Graph graphForBFS = new Graph(mapForBFS);
        System.out.println("\nTraversing map using Breadth First Traversal:\n");
        graphForBFS.BFS(mapForBFS[0]);
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
}