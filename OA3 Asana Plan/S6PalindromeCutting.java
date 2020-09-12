public class S6PalindromeCutting {

    public String palindromeCutting (String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        while (s.length() > 1) {
            char[] array = s.toCharArray();
            int index = 0;
            int res = 0;
            for (int i = 1; i < array.length; i++) {
                if (Palindrome(array, index, i)) {
                    res = Math.max(res, i - index);
                }
            }
            if (res >= 1) {
                s = s.substring(res + 1, s.length());
            }
            else {
                return s;
            }
        }
        return s;

    }

    private boolean Palindrome (char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main (String[] args) {
        S6PalindromeCutting sol = new S6PalindromeCutting();
        String s = "aaabba";
        System.out.println(sol.palindromeCutting(s));
    }
}
