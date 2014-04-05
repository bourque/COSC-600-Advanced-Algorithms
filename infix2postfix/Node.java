public class Node {

    Object data;
    Node next;
    
    public Node() {
      
        data = "";
        next = null;
    }
    
    
    public Node(Object x, Node node) {
      
        data = x;
        next = node;
    }
}