public class CS2LargestNumber {

    public int largestNumber (int n) {
        int result = 1;
        while (n >= 1) {
            result = result * 10;
            n--;
        }
        return result - 1;
    }
}
