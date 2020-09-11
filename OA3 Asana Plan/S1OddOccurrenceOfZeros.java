public class S1OddOccurrenceOfZeros {
    public int OddOccur (int[] a) {
        int sum = 0;

        for (int i : a) {
            int count = 0;
            if (i == 0) {
                count = 1;
            }
            while (i != 0) {
                if (i % 10 == 0) {
                    count++;
                }
                i /= 10;
            }
            if ((count & 1) == 1) {
                sum++;
            }
        }
        return sum;
    }
    public static void main (String[] args) {
        S1OddOccurrenceOfZeros sol = new S1OddOccurrenceOfZeros();
        int[] a = {20, 11, 10, 10070, 7};
        System.out.println(sol.OddOccur(a));
    }
}
