public class S7MTwoSubsetsWithMinDifference {
    /*
    Recursive solution:
    The recursive approach is to generate all possible sums from all the values of array and to
    check which solution is the most optimal
    to generate sums we either include the i'th item in set 1 or in set 2
                           {3, 1, 4, 2, 2, 1}
                            /         \
    3                     3            {}
                        /   \         /    \
    1                  31    3        1      {}
                     /  \   /  \     /  \    /  \
    4              314  31 34   3   14   1  4    {}

     */
    public int minDifference (int[] array) {
        int sumTotal = 0;
        for (int i = 0; i < array.length; i++) {
            sumTotal += array[i];
        }
        return helper(array, 0, 0, sumTotal);
    }

    private int helper (int[] array, int index, int sumCalculated, int sumTotal) {
        if (index == array.length) {
            return Math.abs(sumTotal - 2 * sumCalculated);
        }
        int add = helper(array, index + 1, sumCalculated + array[index], sumTotal);
        int notAdd = helper(array, index + 1, sumCalculated, sumTotal);
        return Math.min(add, notAdd);
    }
    public static void main(String[] args)
    {
        int arr[] = {3, 1, 4, 2, 2, 1};
        S7MTwoSubsetsWithMinDifference sol = new S7MTwoSubsetsWithMinDifference();
        int n = arr.length;
        System.out.print("The minimum difference"+
                " between two sets is " +
                sol.minDifference(arr));
    }

    public int minDifferenceI (int[] array) { // for size  n/2
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        int[] globalMin = {Integer.MAX_VALUE};
        dfs (0, 0, array, 0, sum, globalMin);
        return globalMin[0];
    }

    private void dfs (int curSum, int count, int[] array, int index, int sum, int[] globalMin) {
        if (index == array.length) {
            return;
        }
        if (count == array.length / 2) {
            int curMin = Math.abs(sum - 2 * curSum);
            if (curMin < globalMin[0]) {
                globalMin[0] = curMin;
            }
            return;
        }

        curSum += array[index];
        dfs(curSum, count + 1, array, index + 1, sum, globalMin);
        curSum -= array[index];
        //add

        dfs(curSum, count, array, index + 1, sum, globalMin);
        // not add
    }



}
