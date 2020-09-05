import java.util.HashMap;
import java.util.Map;

public class JZ25深度拷贝复杂链表 {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
        RandomListNode (int label) {
            this.label = label;
        }
    }


    public RandomListNode copy (RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (pHead != null) {
            // copy current node if necessary
            if (!map.containsKey(pHead)) {
                map.put(pHead, new RandomListNode(pHead.label));
            }
            // connect the copied node to the deep copy list
            cur.next = map.get(pHead);
            // copy the random node if necessary
            if (pHead.random != null) {
                if (!map.containsKey(pHead.random)) {
                    map.put(pHead.random, new RandomListNode(pHead.random.label));
                }
                cur.next.random = map.get(pHead.random);
            }
            pHead = pHead.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
