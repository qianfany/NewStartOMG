import java.util.HashMap;
import java.util.Map;

public class S1MDeepCopyLinkedListWithRandomPointer {
    class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;
        public RandomListNode (int value) {
            this.value = value;
        }
    }
    /*
    build the 1-1 connection between original node and copy node, avoid any original node was copied
    more than once
    Using HashMap to avoid copy multiple times for the same node
    use dummy node
    maintains the mapping between the node in the original list and the corresponding node in the
    new list
     */
    public RandomListNode copy (RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            cur.next = map.get(head);
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new RandomListNode(head.random.value));
                }
                // connect the copied node to the random pointer
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
