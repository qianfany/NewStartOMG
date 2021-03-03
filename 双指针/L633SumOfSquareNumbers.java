public class L633SumOfSquareNumbers {
    /*
    two pointer
    find the sqrt first
     */
    public boolean judgeSquareSum (int c) {
        if (c < 0) return false;
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
