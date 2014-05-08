public class Node {

    Integer data;
    boolean visited;
    Node next;
    Integer level;
    
    public Node() {
      
        data = null;
        visited = false;
        next = null;
        level = null;
    }
    
    public Node(Integer x, boolean v, Node node) {
      
        data = x;
        visited = v;
        next = node;
        level = null;
    }
    
   public Node(Integer x, boolean v, Node node, Integer l) {
      
        data = x;
        visited = v;
        next = node;
        level = l;
    }
}