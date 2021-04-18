public class JZ11NumberOf1In32Bits {
    /*
    use 1 left shift & with n
        if n & flag == 0
            means the bit at that position is 0
        otherwise
            bit at that position is 1
            count++;
    Time: O(N)
    Space: O(1)


    << left shift
    000001 << 3 == 001000
     */
    public int numberOf1 (int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) !=  0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
