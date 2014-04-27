public class QuickSort {
 
  
   public Node sort(Node q) {
        
        if (q == null) {return q;}
        int pivot = q.data;
        Node smaller = sort(smaller(q.next, pivot));
        Node bigger = sort(bigger(q.next, pivot));
        Node pivotNode = new Node(pivot, null);
        
        return merge(merge(smaller, pivotNode), bigger);
    }

   
    public Node smaller(Node q, int pivot) {
      
        if (q == null) {return null;}
        if (q.data <= pivot) {return new Node(q.data, smaller(q.next, pivot));}
       
        return smaller(q.next, pivot);
    }

    
    public Node bigger(Node q, int pivot) {
      
        if (q == null) {return null;}
        if (pivot < q.data) {return new Node(q.data, bigger(q.next, pivot));}

        return bigger(q.next, pivot);
    }

    
    public Node merge(Node q, Node r) {
      
        if (q == null) {return r;}
        if (r == null) {return q;}
        Node begin = q;
        while (q.next != null) {q = q.next;}
        q.next = r;
        
        return begin;
    }
}