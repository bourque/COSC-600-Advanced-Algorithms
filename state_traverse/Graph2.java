public class Graph2 {
  
    
    public void buildGraph(Node[] adjList) {
        /*
         * Builds the graph represented by the adjacencyList
         * 
        */
          
        EdgeNode[] graph = new EdgeNode[adjList.length];
        for (int i=0; i<graph.length; i++) {
            graph[i] = new EdgeNode(i+1);
            EdgeNode parent = graph[i];
            while (adjList[i] != null) {
                EdgeNode sibling = new EdgeNode(adjList[i].data);
                Edge connection = new Edge(parent, sibling);
                parent.edge = connection;
                adjList[i] = adjList[i].next;
            }
        }
        
        System.out.println(graph[0].data);
        //System.out.println(graph[0].edge.data);
    }
          
    
    public void addEdge(EdgeNode parent, int sibling) {
        /*
         * Adds an edge to the Node
        */
     
        //parent.edge = new Edge(parent.edge, sibling);
    }
}