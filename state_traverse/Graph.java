public class Graph {
  
    public Node[] map;
  
    public Graph(Node[] map) {
        /*
         * The constructor method
        */
      
        this.map = map;
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
    
    
    public void BFS(Node p) {
        /*
         * Traverses the graph via Breadth First Traversal
        */
        
        // Print column headers
        System.out.println("State\tLevel\tColor");
      
        // Write first state
        StateWriter sw = new StateWriter();
        sw.writeStateName(p.data);
        p.visited = true;
        p.level = 0;
        System.out.print(p.level + "\n");
        
        // Put first state into the queue
        Queue queue = new Queue();
        queue.enq(p.data);
        
        // Visit adjacent states using Breadth First Traversal
        while (!queue.isEmpty()) {
          
            // Get first node from queue
            int j = (Integer) queue.dnq();
            Node n = this.map[j-1];
            int l = n.level;
            
            while (n.next != null) {
                
                // Get adjacent node
                int adj = n.next.data;
                Node m = this.map[adj -1];
                
                // Visit the adjacent node if necessary
                if (m.visited == false) {
                    m.level = l + 1;
                    queue.enq(m.data);
                    sw.writeStateName(m.data);
                    System.out.println(m.level);
                    m.visited = true;
                }
                n = n.next;
            }
        }      
    }
}