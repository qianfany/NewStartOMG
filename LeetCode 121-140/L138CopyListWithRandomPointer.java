import java.util.HashMap;
import java.util.Map;

public class L138CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    /**
    build the 1-1 connection between original node and copy node, avoid any original node was copied
    more than once
    Using HashMap to avoid copy multiple times for the same node
    use dummy node
    maintains the mapping between the node in the original list and the corresponding node in the
    new list
    Time: O(N)
     Space: O(N)
     */
    public Node copyRandomList (Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        Map<Node, Node> map = new HashMap<>();
        // key:     node
        // value:   new Node(node.val)
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
            }
            cur.next = map.get(head);
            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new Node(head.random.val));
                }
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
