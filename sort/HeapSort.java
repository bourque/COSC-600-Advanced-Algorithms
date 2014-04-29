public class HeapSort {
  
    public int[] data;
    public int index;
    public int arraySize;
    
    public int[] sort(int[] heapArray) {
      
        this.data = heapArray;
        this.arraySize = heapArray.length;
        
        for (int i = this.arraySize - 1 / 2; i>=0; i--) {
            heapify(this.data, i);
        }
        
        for(int i = this.arraySize - 1; i>0; i--) {
        
            int temp = this.data[0];
            this.data[0] = this.data[i];
            this.data[i] = temp;
            this.arraySize = this.arraySize - 1;
            heapify(this.data, 0);
        }
        
        return this.data;
    }
    
    
    public void heapify(int[] heapArray, int i) {
    
        int left = 2 * i;
        int right = 2 * i + 1;
        
        if (left <= this.arraySize - 1 && this.data[left] > this.data[i]) {
            this.index = left;
        } else {
            this.index = i;
        }
        
        if (right <= this.arraySize - 1 && this.data[right] > this.data[this.index]) {
            this.index = right;
        }
        
        if (index != i) {
            int temp = this.data[i];
            this.data[i] = this.data[index];
            this.data[index] = temp;
            heapify(this.data, index);
        }
    }
}