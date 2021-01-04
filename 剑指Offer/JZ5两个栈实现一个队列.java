import java.util.Stack;

public class JZ5两个栈实现一个队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<>();
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

    private void shuffle () {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public void push (int node){
        stack1.push(node);
    }

    public int pop () {
        shuffle(); // shuffle only when stack2 is empty
        return stack2.pop();
    }
}
