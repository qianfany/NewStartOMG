import java.util.ArrayDeque;
import java.util.Deque;

public class S5DequeByThreeStacks {
    private Deque<Integer> left;
    private Deque<Integer> right;
    private Deque<Integer> buffer;
    /*
    we use a buffer stack, stack3 to buffer the elements
    when moving all elements from right part to left part
    make sure number of elements in left and right part are
    roughly 50% of all elements

    input
                ][ 1 2 3 4 5 6 7
      1 2 4     ][  4 5 6 7
            buffer-stack3 [

     */
    public S5DequeByThreeStacks () {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }

    public void offerFirst (int element) {
        left.offerFirst(element);
    }

    public void offerLast (int element) {
        right.offerFirst(element);
    }

    public Integer pollFirst () {
        move(right, left);
        return left.isEmpty() ? null : left.pollFirst();
    }

    public Integer pollLast () {
        move (left, right);
        return right.isEmpty() ? null : right.pollFirst();
    }

    public Integer peekFirst () {
        move(right, left);
        return left.isEmpty() ? null : left.peekFirst();
    }

    public Integer peekLast () {
        move(left, right);
        return right.isEmpty() ? null : right.peekFirst();
    }

    public int size () {
        return left.size() + right.size();
    }

    public boolean isEmpty () {
        return left.isEmpty() && right.isEmpty();
    }

    private void move (Deque<Integer> src, Deque<Integer> dest) {
        if (!dest.isEmpty()) {
            return;
        }
        int halfSize = src.size() /2;
        for (int i = 0; i < halfSize; i++) {
            buffer.offerFirst(src.pollFirst());
        }
        while (!src.isEmpty()) {
            dest.offerFirst(src.pollFirst());
        }
        while (!buffer.isEmpty()) {
            src.offerFirst(buffer.pollFirst());
        }
    }
}
