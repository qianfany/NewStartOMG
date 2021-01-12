import java.util.*;

public class S2SmartSale {
    /*
    Minimum number of distinct elements after removing m items

    Count the occurrences of elements and store them in the hash
    sort the hash
    start removing elements from the hash
    return the number of values left in the hash
     */
    public int distinctIds (int[] arr, int n, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);

            } else {
                map.put(arr[i], 1);
                size++;
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o1.getValue() < o2.getValue() ? -1 : 1;
            }
        });
        int j = 0;
        while (m > 0) {
            if (list.get(j).getValue() <= m) {
                size--;
                m = m - list.get(j).getValue();
                j++;
            } else {
                m = 0;
            }
        }
        return size;
    }
    public static void main (String[] args) {
        int arr[] = {2, 3, 1, 2, 3, 3};
        int m = 3;
        S2SmartSale sol = new S2SmartSale();
        System.out.println(sol.distinctIds(arr, arr.length, m));
    }



}
