import java.util.ArrayDeque;
import java.util.Queue;

public class StackByQueues {
    /*
    keep track the size of queue
    poll the last element of queue

    [ 3 1 7 6 8
    [ -> 1 7 6 8 (3)

    1 2 6 7 9
    i       j

                    1 2 6 7 9
               []  []  [] []  [] [] []  []

                  1
                /
               2



            1   2   3   4   5
            6   7   8   9   10
            11  12  13  14  15
            16  17  18   19  20
            21  22  23   24  25


            row = index / nun. col
            col =  index % num. col

     */

    private Queue<Integer> q1;

    public StackByQueues () {
        q1 = new ArrayDeque<>();
    }

    public Integer pop() {
        if (q1.isEmpty()) {
            return null;
        }
        int size = q1.size();
        while (--size != 0) {
            q1.offer(q1.poll());
        }
        return q1.poll();
    }

    public void push (int x) {
        q1.offer(x);
    }

    public Integer peek () {
        if (q1.isEmpty()) {
            return null;
        }
        int ret = pop();
        q1.offer(ret);
        return ret;
    }
}
