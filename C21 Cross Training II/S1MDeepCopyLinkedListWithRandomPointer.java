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
    Build the 1-1 connection between original node and copy node,
    avoid any original node being copied more than once.
    Using hashmap to avoid copy multiple times for the same location.
    Using dummy node, maintaining the mapping between the node in the
    original list and the corresponding node in the new list
    HashMap<RandomListNode, RandomListNode>
    key = Original Node
    value = copied Node

    N1   →    N2    →    N3    →    N4   →    N5   →   NULL
    --------------------------->
    |	     |	         |		 |	     |
    Dum    N1’  →    N2’   →    N3’   →    N4’   →    N5’ →    NULL
    --------------------------->

     */
    public RandomListNode copy (RandomListNode head) {
        if (head == null) {
            return null;
        }
        // dummy node to help construct the deep copy
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (head != null) {
            // copy current node if necessary
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            // connect the copied node to the deep copy list
            cur.next = map.get(head);
            // copy the random node if necessary
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
