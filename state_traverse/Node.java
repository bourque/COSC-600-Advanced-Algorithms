public class Node {

    Integer data;
    boolean visited;
    Node next;
    Integer level;
    Integer color;
    
    public Node() {
      
        data = null;
        visited = false;
        next = null;
        level = null;
        color = null;
    }
    
    public Node(Integer c) {
      
        data = null;
        visited = false;
        next = null;
        level = null;
        color = c;
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
   
   public Node(Integer x, boolean v, Node node, Integer l, Integer c) {
      
        data = x;
        visited = v;
        next = node;
        level = l;
        color = c;
    }
}