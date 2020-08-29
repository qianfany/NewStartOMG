import java.util.ArrayDeque;
import java.util.Queue;

public class S4MStackByQueues {
    private Queue<Integer> q1;

    public S4MStackByQueues () {
        q1 = new ArrayDeque<>();
    }
    /*
    keep track of the size of queue
    poll the last element of the queue
     */

    public void push (int x) {
        q1.offer(x);
    }

    public Integer pop () {
        if (q1.isEmpty()) {
            return null;
        }
        int size = q1.size();
        while (--size != 0) {
            q1.offer(q1.poll());
        }
        return q1.poll();
    }

    public Integer top () {
        if (q1.isEmpty()) {
            return null;
        }
        int ret = pop();
        q1.offer(ret);
        return ret;
    }

    public boolean isEmpty () {
        return q1.isEmpty();
    }
}
