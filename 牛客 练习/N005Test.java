import java.util.*;

public class N005Test {
    /**
     * Use Hashset to deduplicate
     * Use recursion
     * for the 4 number    (1,2,3,4)
     * (1,2,3,4) (1,3,4,2) (1,3,2,4) ....
     * for each combination
     * get all the combination
     * use depth first search to get all the results check if they are all in 1-100
     * @param array
     * @return
     */
    /*
            1                           1
                    +           -               *           /
            2   3              -1               2           0
               + - * /
            3 (6 0 9 1)
              + - * /
            4
     */
    public int maxPossibleRes (int[] array) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> list = permutations(array);
        for (List<Integer> list1: list) {
            List<Integer> tmp = fourWayCalculation(list1);
            result.add(tmp);
        }
        for (List<Integer> list2 : result) {
            for (int num : list2) {
                if (num >=1 && num <= 100){
                    set.add(num);
                }
            }
        }
        return set.size();
    }

    private List<List<Integer>> permutations (int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null) {
            return result;
        }
        helper (array, 0, result);
        return result;
    }
    private void helper (int[] array, int index, List<List<Integer>> result) {
        if (index == array.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : array) {
                list.add(i);
            }
            result.add(list);
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, i, index);
                helper(array, index + 1, result);
                swap(array, i, index);
            }
        }
    }

    private void swap (int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public List<Integer> fourWayCalculation (List<Integer> list) {
        int[] array = list.stream().mapToInt(i->i).toArray();
        int cur = array[0];
        List<Integer> res = new ArrayList<>();
        helper1 (array, 0, res, cur);
        return res;
    }

    private void helper1 (int[] array, int index, List<Integer> res, int cur) {
        if (index == array.length-1) {
            res.add(cur);
            return;
        }
        cur = cur + array[index + 1];
        helper1(array, index + 1, res, cur);
        cur = cur - array[index];
        cur = cur - array[index +1];
        helper1(array, index + 1, res, cur);
        cur = cur + array[index];
        cur = cur * array[index + 1];
        helper1(array, index + 1, res, cur);
        cur = cur / array[index];
        cur = cur / array[index + 1];
        helper1(array, index + 1, res, cur);
        cur = cur * array[index];
    }





    public static void main (String[] args) {

    }
}

//        N005Test sol = new N005Test();
//        int[] array = {1, 2, 3, 3};
//        System.out.println(sol.permutations(array));