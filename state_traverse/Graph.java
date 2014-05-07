import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Graph {

    public Node[] map;

    public void traverse() {
      
        this.map = getMap();
        
        System.out.println("Traversing using DFS:\n");
        DFS(this.map[0]); 
        
        System.out.println("\nTraversing using BFS:\n");
        //BFS(this.map[0]);
    }

    
    public Node[] getMap() {
        /*
         * Builds map by reading in input file using adjacency list
         * representation
        */
      
        // Initialize Adjecency List
        this.map = new Node[48];
        
        try {
            // Read in data line by line
            BufferedReader br = new BufferedReader(new FileReader("map_data.dat"));
            String line;
            for (int i=0; i<this.map.length; i++) {
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
                this.map[i] = head;
            }
            br.close();
            
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
        return this.map;
    }
    
 
    public void DFS(Node p) {
        /*
         * Traverses the graph via Depth First Traversal
        */
        
        // Write the current state name
        StateWriter sw = new StateWriter();
        sw.writeStateName(p.data);
        
        // Set the vertex to visited
        p.visited = true;
        
        // Determine how many adjacent vertices there are
        Node tmp = p;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        // Traverse adjacent vertices
        for (int i=0; i<count; i++) {
            if (p.next != null) {
                int adj = p.next.data;
                //System.out.println(adj);
                Node q = this.map[adj - 1];
                if (q.visited == false) {DFS(q);}
                p = p.next;
            }
        }
    }
}
    
//    public void DFS(Node s) {
//        
//        s.visited = true;
//        
//        Stack stack = new Stack();
//        stack.push(s);
//        
//        while (!stack.isEmpty()) {
//            Node v = stack.pop();
//            if (v.visited == false) {
//                v.visited = true;
//                StateWriter sw = new StateWriter();
//                sw.writeStateName(v.data);
//                
//                Node r = this.map[v.data - 1];
//                stack.push(r);
//                r = r.next; 
//            }
//        }
//    }