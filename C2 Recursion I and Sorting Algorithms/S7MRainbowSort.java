import java.util.Arrays;

public class S7MRainbowSort {
    /*
    two wall three region
    aaaaaaa bbbbb xxxxx ccccc
            i     j   l
    i = 0 -> : all letter to the left-hand side of i (not including i) are all "a"
    j = 0 -> : all letters in [i, j) are all b's, j is the current index
    [j, k] unexplored area (including j and k)
    k = n - 1 ->: all letters to the right-hand side of k (not including k) are all "c"s

    Time = O(n)
     */
    public int[] rainbowSort (int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int neg = 0;
        int zero = 0;
        int one = array.length - 1;

        while (zero <= one) {
            if (array[zero] == -1) {
                swap(array, neg, zero);
                neg++;
                zero++;
            }
            else if (array[zero] == 0) {
                zero++;
            }
            else {
                swap(array, zero, one);
                one--;
            }
        }
        return array;
    }

    private void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main (String[] args) {
        int[] array = {1, 1, 0, -1, 0, 1, -1};
        S7MRainbowSort sol = new S7MRainbowSort();
        System.out.println(Arrays.toString(sol.rainbowSort(array)));
    }
}
