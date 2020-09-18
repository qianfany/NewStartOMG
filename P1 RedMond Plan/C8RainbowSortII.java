import java.util.Arrays;

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
    public int[] rainbowSort(int[] array) {
        if(array == null || array.length < 2) {
            return array;
        }
        int zero = 0;
        int one = 0;
        int two = array.length - 1;
        int three = array.length - 1;
        while(one <= two) {
            int cur = array[one];
            if(cur == 0) {
                swap(array, one, zero);
                one++;
                zero++;
            } else if(cur == 1) {
                one++;
            } else if(cur == 2) {
                swap(array, one, two);
                two--;
            } else {
                swap(array, one, three);
                three--;
                if(two > three) {
                    two = three;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        C8RainbowSortII solution = new C8RainbowSortII();
        int[] array = {1, 3, 1, 2, 0};
        System.out.println(Arrays.toString(solution.rainbowSort(array)));
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
