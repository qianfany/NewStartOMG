import java.util.LinkedList;

public class S2MQueueByTwoStacks {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public S2MQueueByTwoStacks () {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    /*
    Stack 1: is the only stack to store new elements when adding a new element into the queue
    Stack 2: is the only stack to pop old element out of the queue
        case 1: if the stack2 is not empty, we can just pop
        case 2: if the stack2 is empty, we move all elements elements from stack1 to stack2 one by one,
        and then pop out the top element from stack2

    {5, 6, 7, 8}
    stack1 [5 6 7 8
    stack2 [

    stack1 [
    stack2 [8 7 6 5 ->
    Time: O(1) amortize
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
