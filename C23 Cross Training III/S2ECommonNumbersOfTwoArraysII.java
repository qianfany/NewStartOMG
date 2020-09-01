import java.util.*;

public class S2ECommonNumbersOfTwoArraysII {

    public List<Integer> common (int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        for (int j = 0; j < B.length; j++) {
            if (set.contains(B[j])) {
                result.add(B[j]);
            }
        }
        Collections.sort(result);
        return result;
    }
}
