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
        
        // Write first state visited
        StateWriter sw = new StateWriter();
        sw.writeStateName(p.data);
        p.visited = true;
        
        // Put first state into queue
        Queue queue = new Queue();
        queue.enq(p.data);
        
        // Visit adjacent states
        while (!queue.isEmpty()) {
            int j = (Integer) queue.dnq();
            Node n = this.map[j-1];
            n = n.next;
            while (n.next != null) {
                int adj = n.data;
                Node m = this.map[adj -1];
                if (m.visited == false) {
                    queue.enq(m.data);
                    sw.writeStateName(m.data);
                    m.visited = true;
                }
                n = n.next;
            }
        }      
    }
}