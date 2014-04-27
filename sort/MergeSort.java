public class MergeSort {

  
    public Node sort(Node q) {
        
        if (q == null) {return null;}
        if (q.next == null) {return null;}
        
        Node center = getCenter(q);
        Node l = q;
        Node r = center.next;
        center.next = null;
        
        Node left = sort(l);
        Node right = sort(r);
        center.next = r;
          
        return merge(left, right);
    }
    
    
    public Node getCenter(Node q) {
        
        Node slow = q;
        Node fast = q.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    public Node merge(Node left, Node right) {
        
        Node temp = new Node();
        Node head = new Node();
        temp = temp.next;
        head = head.next;
        
        while (left != null && right != null) {
          if (left.data < right.data) {
              if (temp == null) {
                  temp = left;
                  head = left;
              } else {
                  temp.next = left;
                  temp = temp.next;
              }
              left = left.next;
              
          } else {
              if (temp == null) {
                  temp = right;
                  head = right;
              } else {
                  temp.next = right;
                  temp = temp.next;
              }
              right = right.next;
          }
        }
        
        return head;
    }
}