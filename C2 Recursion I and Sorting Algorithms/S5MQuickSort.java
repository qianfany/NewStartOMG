public class S5MQuickSort {
    /*
        two wall divide into 3 regions
        [0 - i]     left of i   -> all number smaller than pivot
        [i - j]     unknown region
        [j - n - 1] right of j  -> all number bigger than pivot
        Do it recursively
        Time: worst case (O(n^2))   Average case: O(n log n)
     */
    public int[] quickSort (int[] array) {
        if (array == null) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort (int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition (array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int pivotIndex (int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private int partition (int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            }
            else if (array[rightBound] >= pivot) {
                rightBound--;
            }
            else {
                swap (array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }
    private void swap (int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
