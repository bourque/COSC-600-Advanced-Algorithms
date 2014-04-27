public class Node {

    int data;
    Node next;
    
    public Node() {
      
        data = 0;
        next = null;
    }
    
    public Node(int x, Node node) {
      
        data = x;
        next = node;
    }
}