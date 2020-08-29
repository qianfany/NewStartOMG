public class S1EClassicalBinarySearch {
    /*
    Binary search return any
    Time: O(log n)
    Space: O(1)
     */
    public int binarySearch (int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (array[mid] == target){
                return mid;
            }
            else if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        S1EClassicalBinarySearch sol = new S1EClassicalBinarySearch();
        int[] array = {1, 2, 2, 2, 3, 4};
        System.out.println(sol.binarySearch(array, 3));
    }
}
