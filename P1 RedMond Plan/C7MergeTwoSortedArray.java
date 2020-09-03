public class C7MergeTwoSortedArray {
    public int[] merge (int[] A, int m, int[] B, int n) {
        /*
        Merge two sorted array
        Time: O(m + n)
        Space: O(m + n)
         */
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                result[k] = A[i];
                i++;
            }
            else {
                result[k] = B[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            result[k] = A[i];
            k++; i++;
        }
        while (j < n) {
            result[k] = B[j];
            k++; j++;
        }
        return result;
    }
}
