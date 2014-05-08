public class Stack {

    private Node top;
    
    
    public void push(Node item) {
      
        top = new Node(item.data, true, top);
    }
    
    
    public Node pop() {
      
        Node oldTop = top;
        Node item = peek();
        top = top.next;
        oldTop.next = null;
        
        return item;
    }
    
    
    public Node peek() {
      
        if (isEmpty()) throw new NullPointerException();
        
        return top;
    }
    
    
    public boolean isEmpty() {
      
        return top == null;
      
    }
}