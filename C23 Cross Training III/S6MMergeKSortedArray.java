import java.util.Comparator;
import java.util.PriorityQueue;

public class S6MMergeKSortedArray {
    /*
    define the average length of each array as n
    iterative reduction
    A1
    A2  -> A12  2n
    A3          -> A13  3n
    A4                  ->  A14  4n
    ...
    Ak                          ... kn
    Time: O(k^2 * n)
    Extra space: O(kn)

    Binary reduction:
    A1
    A2  -> A12 2n
    A3      ->  A14 4n
    A4  -> A34 2n
    A5           -> A18 8n
    A6  -> A56
    A7      ->  A58 4n
    A8  -> A78
    Time: O(kn * log k)
    Space: O(kn)

    Heap:
    k pointers, min heap: stores all the elements pointed by the k pointers
    find the smallest element <i, j> in the min_heap    -O(1)
    result.append (a[i][j])                             -O(1)
    minHeap.pop()                                       -O(log k)
    minHeap.push(<i, j+1>)                              -O(log k)
    Time: O(nk * log k)
    Extra space (k)         online algorithm
     */

    public class Entry {
        int x;
        int y;
        int value;

        Entry (int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public int[] merge (int[][] arrayOfArrays) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0) {
                minHeap.offer(new Entry(i, 0, array[0]));
            }
        }
        int [] result = new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Entry tmp = minHeap.poll();
            result[cur++] = tmp.value;
            if (tmp.y + 1 < arrayOfArrays[tmp.x].length) {
                tmp.y++;
                tmp.value = arrayOfArrays[tmp.x][tmp.y];
                minHeap.offer(tmp);
            }
        }
        return result;
    }
}
