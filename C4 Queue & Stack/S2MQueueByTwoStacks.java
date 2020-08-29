import java.util.LinkedList;

public class S2MQueueByTwoStacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public S2MQueueByTwoStacks () {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    /*
    stack1: is the only stack to store new elements when adding a new element into the queue
    stack2: is the only stack to pop old element out of the queue
            case 1: if stack2 is not empty, then we can just pop
            case 2: if stack2 is empty, we move all data from stack1 to stack2 one by one, and then
            pop out the top element from stack2
     Time: O(1) amortize
        Queue 5 6 7 8
        stack1 [  5678
        stack2 [  8765
     */
    private void Shuffle () {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.poll());
            }
        }
    }

    public Integer poll() {
        Shuffle();
        if (out.isEmpty()) {
            return null;
        }
        return out.pop();
    }

    public void offer (int element) {
        in.push(element);
    }

    public Integer peek() {
        Shuffle();
        if (out.isEmpty()) {
            return null;
        }
        return out.peek();
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean inEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

}
