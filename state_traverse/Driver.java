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