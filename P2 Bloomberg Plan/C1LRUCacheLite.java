import java.util.HashMap;
import java.util.Map;

public class C1LRUCacheLite {

    static class Node {
        Node next;
        Node prev;
        int key;
        Node (int key) {
            this.key = key;
        }
    }

    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public C1LRUCacheLite (int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get (int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        add(node);
        return node.key;
    }

    public void put (int key) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);
        }
        else if (map.size() < capacity) {
            node = new Node(key);
        }
        else {
            node = tail;
            remove(node);
            node = new Node(key);
        }
        add(node);
    }

    private Node add (Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
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


}
