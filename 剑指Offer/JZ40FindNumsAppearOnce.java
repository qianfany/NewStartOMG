public class JZ40FindNumsAppearOnce {
    /*
    use bit operation
    A ^ A = 0   0 ^ A = A
    after exclusive OR everything
    we get result1 ^ result2
    find the first bit that they differ     1 is 0 & 2 is 1
    we ^  back to get the number
     */
    public void findNums (int[] array, int num1[], int num2[]) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        int index = 1;
        while ((index & temp) == 0) {
            index = index << 1;
        }

        for (int val : array) {
            if ((val & index) == 0) {
                num1[0] ^= val;
            }
            else {
                num2[0] ^= val;
            }
        }
    }
}
