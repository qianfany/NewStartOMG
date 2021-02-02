public class L66PlusOne {
    /*
    won't have zero at digits[0]
    special Case: 9999
    Time: O(n)
    Space: O(1)  O(N) special case
     */
    public int[] plusOne (int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
