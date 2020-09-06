import java.util.Arrays;

public class JZ45IsContinuous扑克牌大小王赖子 {
    /*
    check
    1. sort the array
    2. count the number of kings
    3. if array[i] = array[i + 1] false
    4. interval = array[i+1] - array[i] - 1
    5. check if interval > numOfKings

    Time: O(n log n)
    Space: O(1)
     */
    public boolean isContinuous (int[] numbers) {
        int king = 0;
        int interval = 0;
        int length = numbers.length;
        if (length == 0) {
            return false;
        }
        Arrays.sort(numbers);

        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == 0) {
                king++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            interval += numbers[i + 1] - numbers[i] - 1;
        }
        if (king >= interval) {
            return true;
        }
        return false;
    }
}
