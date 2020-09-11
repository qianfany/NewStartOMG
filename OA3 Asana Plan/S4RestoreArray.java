import java.util.*;

public class S4RestoreArray {
    /**
     *  find head
     *  Map<Integer, >
     */
    public int[] restoreArray (int[][] pairs) {

        int[] num1 = new int[]{0};
        int[] num2 = new int[]{0};
        findUnique(pairs, num1, num2);
        int i = 0;
        for (int[] array : pairs) {
            if (array[0] == num1[0] || array[1] == num1[0]) {
                break;
            }
            i++;
        }

        if (pairs[i][0] != num1[0]) {
            innerSwap(pairs, i);
        }
        swap(pairs, i, 0);
        helper(pairs, 1);
        int[] res = new int[pairs.length + 1];
        res[0] = pairs[0][0];
        int j = 1;
        for (int[] array : pairs) {
            res[j] = array[1];
            j++;
        }
        return res;
    }

    private void helper (int[][] pairs, int index) {
        if (index == pairs.length) {
            return;
        }
        for (int i = index; i < pairs.length; i++) {
            if (canConnect(pairs[index - 1], pairs[i])) {
                swap(pairs, index, i);
            }
            helper (pairs, index + 1);
        }
    }



    private void innerSwap (int[][] array, int i) {
        int i0 = array[i][0];
        array[i][0] = array[i][1];
        array[i][1] = i0;
    }

    private void innerSwap (int[] array) {
        int i0 = array[0];
        array[0] = array[1];
        array[1] = i0;
    }

    private void swap (int[][] pairs, int i, int j) {
        int l0 = pairs[i][0];
        int l1 = pairs[i][1];
        pairs[i][0] = pairs[j][0];
        pairs[i][1] = pairs[j][1];
        pairs[j][0] = l0;
        pairs[j][1] = l1;
    }
    private boolean canConnect (int[] a, int[] b) {
        if (a[1] == b[0]) {
            return true;
        }
        if (a[1] == b[1]) {
            innerSwap(b);
            return true;
        }
        return false;
    }

    private void findUnique (int[][] array, int[] num1, int[] num2) {
        int temp = 0;
        for (int[] list : array) {
            temp = temp ^ list[0] ^ list[1];
        }
        int index = 1;
        while ((index & temp) == 0) {
            index = index << 1;
        }

        for (int[] list : array) {
            for (int val : list) {
                if ((val & index) == 0) {
                    num1[0] ^= val;
                }
                else {
                    num2[0] ^= val;
                }
            }
        }
    }

    public static void main (String[] args) {
        S4RestoreArray sol = new S4RestoreArray();
        int[][] pairs = {
                {3, 5},
                {1, 4},
                {2, 4},
                {1, 5},
        };
        System.out.println(Arrays.toString(sol.restoreArray(pairs)));
        }
}
