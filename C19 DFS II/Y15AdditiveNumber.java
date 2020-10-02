public class Y15AdditiveNumber {

    public boolean isAdditiveNumber (String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        return helper (num, 0, -1, -1, -1);
    }

    private boolean helper (String num, int start, long prev1, long prev2, long prev3) {
        if (start == num.length()) {
            if (prev1 == -1 || prev2 == -1 || prev3 == -1) {
                return false;
            }
            return prev1 + prev2 == prev3;
        }
        if (num.charAt(start) == '0') {
            return helper(num, start+ 1, prev2, prev3, 0);
        }
        boolean ans = false;

        for (int i = start + 1; i <= num.length() && i - start <= 10; i++) {
            long curr = Long.parseLong(num.substring(start, i));
            if (prev2 == -1 || prev3 == -1 || prev2 + prev3 == curr) {
                ans |= helper(num, i, prev2, prev3, curr);
            } else if (prev2 + prev3 < curr) {
                break;
            }
        }
        return ans;
    }
}
