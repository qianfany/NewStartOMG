import java.util.HashMap;
import java.util.Map;

public class L35复杂链表的复制 {

    public Node copyRandomList (Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node cur = dummy;
        Map<Node, Node> map = new HashMap<>();
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
}
