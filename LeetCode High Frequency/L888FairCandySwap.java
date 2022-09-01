import java.util.Arrays;

public class L888FairCandySwap {
    /*
    big - n = small + n
    find the index in both array have difference = n
     */
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();

        if (aliceSum < bobSum) {
            int n = (bobSum - aliceSum) / 2;
            for (int i = 0; i < bobSizes.length; i++) {
                for (int j = 0; j < aliceSizes.length; j++) {
                    if (bobSizes[i] - aliceSizes[j] == n) {
                        return new int[]{aliceSizes[j], bobSizes[i]};
                    }
                }
            }
        } else {
            int n = (aliceSum - bobSum) / 2;
            for (int i = 0; i < aliceSizes.length; i++) {
                for (int j = 0; j < bobSizes.length; j++) {
                    if (aliceSizes[i] - bobSizes[j] == n) {
                        return new int[]{aliceSizes[i], bobSizes[j]};
                    }
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        L888FairCandySwap sol = new L888FairCandySwap();
        int[] aliceSizes = {1, 2, 5};
        int[] bobSizes = {2, 4};
        System.out.println(Arrays.toString(sol.fairCandySwap(aliceSizes, bobSizes)));
    }
}
