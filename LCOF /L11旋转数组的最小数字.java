public class L11旋转数组的最小数字 {

    public int minArray (int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[left]) {
                right = mid;
            }
            else {
                right--;
            }
        }
        return numbers[left];
    }
}
