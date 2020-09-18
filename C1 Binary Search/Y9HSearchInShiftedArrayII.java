public class Y9HSearchInShiftedArrayII {
    /**
     Time: O(log n)						Space: O(1)
     Binary Search
     case 1:     array[left] < array[mid]	(left - mid  is sorted )
     1.1	array[mid] > target && target >= array[left]
     target  in [left, mid -1]
     1.2 	otherwise
     target in [mid + 1, right]
     case 2:    array[left] > array[mid]	(mid - right is sorted )
     2.1 	array[mid] < target && target <= array[right]
     target in [mid + 1, right]
     2.2 	otherwise
     target in [left, mid - 1]
     case 3:   array[left] == array[mid]
     start++
     */
    public int search (int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) /2;
            if (array[mid] == target) {
                return mid;
            }
            // if left part is sorted
            if (array[left] < array[mid]) {
                if (array[mid] > target && target >= array[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (array[left] > array[mid]) {
                if (target > array[mid] && target <= array[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            else {
                left++;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        int[] nums = {3, 1, 3, 3, 3, 3};
        int target = 1;
        Y9HSearchInShiftedArrayII sol = new Y9HSearchInShiftedArrayII();
        System.out.println(sol.search(nums, target));
    }
}
