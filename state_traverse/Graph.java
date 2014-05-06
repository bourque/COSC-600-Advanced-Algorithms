import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Graph {

    public Node[] map;

    public void traverse() {
      
        this.map = getMap();
        DFS(this.map[0]); 
    }

    
    public Node[] getMap() {
        /*
         * Builds map by reading in input file
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
         * Traverses the linked list via Depth First Traversal
        */
        
        StateWriter sw = new StateWriter();
        sw.writeStateName(p.data);
        p.visited = true;
        
        Node tmp = p;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        
        for (int i=0; i<count; i++) {
            int adj = p.next.data;
            //System.out.println("adj node is " + adj);
            //System.out.println("trying " + this.map[adj - 1].data);
            
            Node q = this.map[adj - 1];
            if (q.visited == false) {
                DFS(q);
            }
            p = p.next;
        }
    }
} 