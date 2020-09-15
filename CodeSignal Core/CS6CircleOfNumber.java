public class CS6CircleOfNumber {

    public int circleOfNumber (int n, int firstNumber) {
        int mid = n / 2;
        return firstNumber >= mid ? firstNumber - mid : firstNumber + mid;
    }
}
