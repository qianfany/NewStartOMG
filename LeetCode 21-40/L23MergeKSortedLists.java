import java.util.Comparator;
import java.util.PriorityQueue;

public class L23MergeKSortedLists {
    /*
    define n as the average length of array with k linkedList

    sol 1.
    iterative reduction:
    A1
    A2  -> A12  2n +
    A3          -> A13  3n +
    A4                  ->  A14  4n +
    ...
    Ak                          ... kn
    Time: O(k^2 * n)
    Extra space: O(kn)

    sol 2.
    binary reduction:
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

    sol 3.
    k way merge with minHeap
    put all first nodes into minHeap
    merge the sorted LinkedList
    find the smallest element
    tail.next = minHeap.poll
    tail = tail.next
    minheap.add(tail.next)
    time: O(n*k log k)
    Extra space (k) creating a new linked list costs O(k) space online algorithm
     */
    public ListNode mergeKLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                minheap.add(node);
            }
        }

        while (!minheap.isEmpty()) {
            tail.next = minheap.poll();
            tail = tail.next;
            if (tail.next != null) {
                minheap.add(tail.next);
            }
        }
        return dummy.next;
    }
}
