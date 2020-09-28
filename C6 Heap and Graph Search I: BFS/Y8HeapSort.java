public class Y8HeapSort {
    /**
     * create a MaxHeap tree and then extra the max and do heapify
     * for the array, swap the largest element from front to end then do
     * heapify until is sorted
     * @param array
     * @return
     */
    public int[] sort (int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

        for (int i = size - 1; i >= 0; i--) {
            int x = array[0];
            array[0] = array[i];
            array[i] = x;

            heapify(array, i, 0);
        }
        return array;
    }


    public void heapify (int[] array, int heapSize, int i) {
        int largest = i;
        int leftChildIdx = 2 * i + 1;
        int rightChildIdx = 2 * i + 2;

        if (leftChildIdx < heapSize && array[leftChildIdx] > array[largest]) {
            largest = leftChildIdx;
        }
        if (rightChildIdx < heapSize && array[rightChildIdx] > array[largest]) {
            largest = rightChildIdx;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, heapSize, largest);
        }
    }
}
