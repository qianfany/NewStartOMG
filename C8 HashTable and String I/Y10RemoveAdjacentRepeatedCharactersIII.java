public class Y10RemoveAdjacentRepeatedCharactersIII {
    /*
    "aaaabbbc" -->  "c"
    sorted in ascending order
     */

    public String deDup (String input) {

        if (input == null || input.length() <= 1) {
            return input;
        }
        int i = 0, j = 0, k = 1;
        char[] array = input.toCharArray();

        while (k < array.length) {
            if (array[k] != array[j] && k - j == 1) {
                array[i] = array[j];
                i++;
                j++;
                k++;
            } else if (array[k] != array[j] && k - j > 1) {
                j = k;
            } else {
                k++;
            }
        }

        if (array[k - 1] != array[k - 2]) {
            array[i] = array[k - 1];
        }

        if (i != 0 || array[i] != array[i + 1]) {
            return new String(array, 0, i + 1);
        } else {
            return new String();
        }


    }
}
