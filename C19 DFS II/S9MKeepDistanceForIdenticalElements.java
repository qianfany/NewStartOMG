public class S9MKeepDistanceForIdenticalElements {
    /*
    Many levels tree:
        n levels, each level places one pair of integers
    Branches:
        depending on how many valid places are left
                              X X X X X X
                            /               \
                    3 X X X 3 X             X 3 X X X 3
                        |                       |
                    3 X 2 X 3 2             2 3 X 2 X 3
                        |                       |
                    3 1 2 1 3 2             2 3 1 2 1 3
     Time:      O(() ^ (n))
     Space:     O(n)
     */
    public int[] keepDistance (int k) {
        int[] array = new int[2 * k];
        return helper3 (array, k) ? array : null;
    }

    private boolean helper3 (int[] array, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < array.length - n - 1; i++) {
            if (array[i] == 0 && array[i + n + 1] == 0) {
                array[i] = n;
                array[i + n + 1] = n;
                if (helper3(array, n - 1)) {
                    return true;
                }
                array[i] = 0;
                array[i + n + 1] = 0;
            }
        }
        return false;
    }
}
