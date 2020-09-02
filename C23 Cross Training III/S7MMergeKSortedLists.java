import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class S7MMergeKSortedLists {
    /*
    k way merge with minHeap
    put all first nodes into minHeap
    find the smallest element
    tail = tail.next = minHeap.poll
    time: O(n*k log k)
    Extra space (n) creating a new linked list costs O(n) space
     */
    public ListNode merge (List<ListNode> listOfLists) {
        if (listOfLists == null || listOfLists.size() == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listOfLists.size(), new Comparator<ListNode>() {
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

        for (ListNode node : listOfLists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        while (!minHeap.isEmpty()) {
            tail.next = minHeap.poll();
            tail = tail.next;
            if (tail.next != null) {
                minHeap.add(tail.next);
            }
        }
        return dummy.next;
    }
}
