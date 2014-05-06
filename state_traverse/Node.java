public class Node {

    Integer data;
    boolean visited;
    Node next;
    
    public Node() {
      
        data = null;
        visited = false;
        next = null;
    }
    
    public Node(Integer x, boolean v, Node node) {
      
        data = x;
        visited = v;
        next = node;
    }
}