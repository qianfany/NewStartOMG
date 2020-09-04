public class JZ13OddFirstEvenAfter {
    /*
    move all even elements behind
    j pointer linear scan
    put all even elements -> behind from i + 1  ~  j

    "2 2 1 2 3 4 5 6 7 8 "
         j
     1 2 2
             j
     1 3 2 2 2
    in-place method:
    Time: O(n^2)
    Space: O(1)
     */
    public void reOrderArray (int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 ==1) {
                int tmp = array[j];
                for (int m = j -1; m >= i; m--) {
                    array[m + 1] = array[m];
                }
                array[i++] = tmp;
            }
        }
    }
}
