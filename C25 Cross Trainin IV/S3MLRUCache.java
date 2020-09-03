import java.util.HashMap;
import java.util.Map;

public class S3MLRUCache {
    /*
    1. find the corresponding answer / response to a question request: hashMap
    2. adjust the timestamp of a particular entry
    3. find and delete the oldest entry
    4. insert an entry as the newest        doubly linkedList

    Time: O(1)
    Space: O(capacity)
     */
    static class Node {
        Node next;
        Node prev;
        int key;
        int value;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
        void update (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public S3MLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove (node);
        append(node);
        // find and delete the oldest entry
        // insert an entry as the newest
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);
            node.value = value;
            // update the value
        } else if (map.size() < capacity) {
            node = new Node(key, value);
        } else {
            // size reaches the capacity
            // remove the tail node, insert entry to the top
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append (node);
    }
    private Node remove (Node node) {
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.next = node.prev = null;
        return node;
    }

    private Node append (Node node ){
        map.put(node.key, node);
        //update the doubly linkedList
        if (head == null) {
            head = tail = node;
        } else {
            // update head
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
}
