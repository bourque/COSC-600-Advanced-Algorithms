public class InsertionSort {
  
  
    public Node sort(Node q) {
         
         Node sorted = q;
         q = q.next;
         sorted.next = null;
         
         while (q != null) {
             final Node temp = q;
             q = q.next;
             
             if (temp.data < sorted.data) {
                 temp.next = sorted;
                 sorted = temp;
             } else {
                 Node r = sorted;
                 while (r.next != null && temp.data > r.next.data) {
                     r = r.next;
                 }
                 
                 temp.next = r.next;
                 r.next = temp;
             }
         }
         
         return sorted;
      }
}