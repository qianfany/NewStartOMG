import java.util.Arrays;

public class S1Zigzag {
    public int[] zigzag (int[] number) {
        for (int i = 0; i < number.length-2; i++) {
            if ((number[i] < number[i + 1] && number[i + 1] > number[i + 2])
            || (number[i] > number[i + 1] && number[i + 2] > number[i + 1])) {
                number[i] = 1;
            }
            else {
                number[i] = 0;
            }
        }
        return Arrays.copyOfRange(number, 0, number.length - 2);
    }

    public static void main (String[] args) {
        S1Zigzag sol = new S1Zigzag();
        int[] number = {1, 2, 1, 3, 4};
        System.out.println(Arrays.toString(sol.zigzag(number)));
    }
}
