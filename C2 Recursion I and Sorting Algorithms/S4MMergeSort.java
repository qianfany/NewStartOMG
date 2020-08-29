public class S4MMergeSort {
    /*
                        52741386
                  /                 \
                5274               1386                     Time = O(2)
               /    \              /   \
              52     74           13    86                  Time = O(4)
             /  \    / \          / \   / \
            5   2    7  4        1   3  8   6               Time = O(n/2)
            5   2    7  4        1   3  8   6          total Time: O(n)
            \   /    \  /         \  /   \ /
              25      47           13     68                Time = O(n)
                \     /              \   /
                  2457                1368                  Time = O(n)
                      \               /
                          12345678                          Time = O(n)
                                                       total Time: O(n log n)
                                                       SPace:   O(n + log n)
     */
    public int[] mergeSort (int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);

    }

    private int[] mergeSort (int[] array, int left, int right) {
        if (left == right) {
            return new int[] {array[left]};
        }
        int mid = left + (right - left) /2;
        int[] one = mergeSort(array, left, mid);
        int[] two = mergeSort(array, mid + 1, right);
        return merge (one, two);
    }

    private int[] merge (int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[k] = array1[i];
                i++;
            }
            else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < array1.length) {
            result[k] = array1[i];
            k++; i++;
        }
        while (j < array2.length) {
            result[k] = array2[j];
            k++; j++;
        }
        return result;
    }
}
