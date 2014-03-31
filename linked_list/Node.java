public class Node {

    String data;
    Node next;
    
    public Node() {
      
        data = "";
        next = null;
    }
    
    public Node(String x, Node node) {
      
        data = x;
        next = node;
    }
}