public class CS8PhoneCall {

    public int phoneCall (int min1, int min2_10, int min11, int s) {
        int res = 0;
        if (s < min1) {
            return res;
        }
        s = s - min1;
        res++;
        if (s < min2_10 * 9) {
            return res + (s / min2_10);
        }
        else {
            return 10 + ((s - (min2_10 * 9)) / min11);
        }
    }
}
