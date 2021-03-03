public class L88MergeSortedArray {

    public void merge (int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n -1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
            finished--;
        }
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }

    /*
    merge, from the end, otherwise, numbers in nums1 will be overwritten
    more clear version
     */

    public void merge2 (int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}
