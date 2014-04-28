public class HeapSort {
  
    public int[] data;

    
    public int[] sort(int[] heapArray) {
      
        this.data = heapArray;
        for (int i = heapArray.length / 2 - 1; i>=0; i--) {
            heapify(i);
        }
        
        for(int i = this.data.length - 1; i>=0; i--) {
        
            int temp = this.data[0];
            this.data[0] = this.data[i];
            this.data[i] = temp;
            heapify(i);
            System.out.println(this.data[0]);
        }
        
        return this.data;
    }
    
    
    public void heapify(int n) {
    
        int index = n;
        int left = 2 * n + 1;
        int right = 2 * n + 2;
        
        if (left < this.data.length && this.data[left] > this.data[index]) {
            index = left;
        }
        if (right < this.data.length && this.data[right] > this.data[index]) {
            index = right;
        }
        
        if (index != n) {
            int temp = this.data[n];
            this.data[n] = this.data[index];
            this.data[index] = temp;
            heapify(index);
        }
    }
}
