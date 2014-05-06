public class Stack {

    private Node top;
    
    
    public void push(Object item) {
      
        top = new Node(item, top);
    }
    
    
    public Object pop() {
      
        Node oldTop = top;
        Object item = peek();
        top = top.next;
        oldTop.next = null;
        
        return item;
    }
    
    
    public Object peek() {
      
        if (isEmpty()) throw new NullPointerException();
        
        return top.data;
    }
    
    
    public boolean isEmpty() {
      
        return top == null;
      
    }
}