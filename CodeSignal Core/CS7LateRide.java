public class CS7LateRide {

    public int lateRide (int n) {
        int left = n / 60;
        int right = n % 60;
        int left1 = left /10;
        int left2 = left % 10;
        int right1 = right / 10;
        int right2 = right % 10;
        return left1 + left2 + right1 + right2;
    }
}
