import java.util.*;

public class S4MKthSmallestWithOnly357AsFactors {
    /*
    1. Initial state <x=1, y=1, z=1>
    2. Expansion / generation rule: expand <x, y, z>
            a. generate <x+1, y, z>
            b. generate <x, y+1, z>
            c. generate <x, y, z+1>
    3. Termination condition: when the k-th element is popped out of the heap
    4. Must do duplication when generating a new state
    Time = O(k log k)
     */
    public long kth (int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long product1 = product(o1);
                long product2 = product(o2);
                if (product1 == product2) {
                    return 0;
                }
                return product1 < product2 ? -1 : 1;
            }
        });
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> cur = Arrays.asList(1, 1, 1);
        visited.add(cur);
        minHeap.offer(cur);
        while (k > 0) {
            cur = minHeap.poll();
            List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (visited.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (visited.add(n)) {
                minHeap.offer(n);
            }
            n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (visited.add(n)) {
                minHeap.offer(n);
            }
            k--;
        }
        List<Integer> list = Arrays.asList(cur.get(0), cur.get(1), cur.get(2));
        return product(list);

    }


    private long product (List<Integer> list) {
        long res = 1;
        int num3 = list.get(0);
        int num5 = list.get(1);
        int num7 = list.get(2);
        while (num3 >= 1) {
            res = res * 3;
            num3--;
        }
        while (num5 >= 1) {
            res = res * 5;
            num5--;
        }
        while (num7 >= 1) {
            res = res * 7;
            num7--;
        }
        return res;
    }
}
