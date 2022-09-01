import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L1337KWeakestRowsInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[]{-1};
        }
        PriorityQueue<Pair<Integer, int[]>> minHeap = new PriorityQueue<>(k, new Comparator<Pair<Integer, int[]>>() {
            @Override
            public int compare(Pair<Integer, int[]> o1, Pair<Integer, int[]> o2) {
                int index1 = o1.getKey();
                int index2 = o2.getKey();
                int[] array1 = o1.getValue();
                int[] array2 = o2.getValue();
                int counter1 = 0;
                int counter2 = 0;
                for (int i : array1) {
                    if (i == 1) {
                        counter1++;
                    }
                }
                for (int j : array2) {
                    if (j == 1) {
                        counter2++;
                    }
                }
                if (counter1 == counter2) {
                    return index1 < index2 ? -1 : 1;
                } else return Integer.compare(counter1, counter2);
            }
        });

        for (int i = 0; i < mat.length; i++) {
            minHeap.add(new Pair<>(i, mat[i]));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }


    public static void main(String[] args) {
        L1337KWeakestRowsInMatrix sol = new L1337KWeakestRowsInMatrix();
        int[][] array= {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;
        System.out.println(Arrays.toString(sol.kWeakestRows(array, k)));
    }
}
