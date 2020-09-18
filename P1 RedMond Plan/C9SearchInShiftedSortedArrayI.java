public class C9SearchInShiftedSortedArrayI {
    /*
    Binary Search
    case 1:     array[left] <= array[mid]
        1.1	array[mid] > target && target >= array[left]
                target  in [left, mid -1]
    1.2 	otherwise
    target in [mid + 1, right]
    case 2:    array[left] > array[mid]
        2.1 	array[mid] < target && target <= array[right]
                target in [mid + 1, right]
        2.2 	otherwise
                target in [left, mid - 1]

    Time: O(log n)
    Space: O(1)
     */
    public int search (int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        C9SearchInShiftedSortedArrayI sol = new C9SearchInShiftedSortedArrayI();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(sol.search(nums, target));
    }
}
