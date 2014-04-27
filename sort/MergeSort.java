public class MergeSort {

  
    public Node sort(Node q) {
        
        if (q == null || q.next == null) {return q;}
        
        Node center = getCenter(q);
        Node half = center.next;
        center.next = null;
          
        return merge(sort(q), sort(half));
    }
    
    
    public Node getCenter(Node q) {
        
        Node slow;
        Node fast;
        slow = fast = q;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public Node merge(Node left, Node right) {
        
        Node temp;
        Node head;
        head = new Node();
        temp = head;
        
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        
        if (left == null) {temp.next = right;}
        else {temp.next = left;}
        
        return head.next;
    }
}