import java.util.Arrays;

public class S1EfficientJanitor {

    /*
    Greedy Approach
    since each weights more than 1.01
    Janitor can at most carry two weights
     */
    public int efficientJanitor (float[] weight, int limit) {
        Arrays.sort(weight);
        int i, j;
        for (i = 0, j = weight.length - 1; i <= j; --j) {
            if (weight[i] + weight[j] <= limit) {
                i++;
            }
        }
        return weight.length - 1 - j;
    }
}
