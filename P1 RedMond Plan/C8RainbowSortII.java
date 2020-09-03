public class C8RainbowSortII {
    /*
    sort between 4 colors
    algorithm: in combination of quickSort and mergeSort
    use quickSort to do partition
    mergeSort to get the middle number, (not the middle index)
    divide into two equal parts.
    go from both side

    Time: O(n log k) k is the number of color
    SPace: O(log k)
     */
    public int[] rainbowSortII (int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        rainbowSort (array, 0, array.length - 1, 0, 3);
        return array;
    }

    private void rainbowSort (int[] colors, int start, int end, int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        if (start == end) {
            return;
        }
        int colorMid = (colorFrom + colorTo) / 2;
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && colors[left] <= colorMid) {
                left++;
            }
            while (left <= right && colors[right] > colorMid) {
                right--;
            }
            if (left <= right) {
                int tmp = colors[left];
                colors[left] = colors[right];
                colors[right] = tmp;
                left++;
                right--;
            }
        }
        rainbowSort(colors, start, right, colorFrom, colorMid);
        rainbowSort(colors, left, end, colorMid + 1, colorTo);
    }
}
