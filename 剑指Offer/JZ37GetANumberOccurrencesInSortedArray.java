public class JZ37GetANumberOccurrencesInSortedArray {
    /*
    binary search
    find the first occurrence of the number
    then, linear scan right to find the number
    Time: O(log n + k)
    Space: O(1)
     */
    public int GetNumberOfK (int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = 0;
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) /2;
            if (array[mid] < k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (array[left] == k) {
            first = left;
            return getNum(array, first);
        }
        if (array[right] == k) {
            first = right;
            return getNum(array, first);
        }
        return 0;
    }

    private int getNum (int[] array, int index) {
        int count = 1;
        while (index < array.length - 1 && array[index + 1] == array[index]) {
            count++;
            index++;
        }
        return count;
    }
}
