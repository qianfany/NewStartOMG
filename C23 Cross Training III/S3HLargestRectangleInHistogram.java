import java.util.Deque;
import java.util.LinkedList;

public class S3HLargestRectangleInHistogram {
    /*
    use  a stack to store all the indices of the columns that form an ascending order
    stack that stores the indices in ascending order bottom [ 1 2 3 4
    when scanning the element with index = 5, M[5] = 2 < M[4] == 5, so we keep checking left column
    of index 5, and calculate the area of index 4, 3, 2 and pop them out of the stack, after this step
    bottom [1 5

    Principle, to maintain the stack to make sure the columns whose indices are stored in the stack
    form an ascending order
    when popped an element out of the stack, the elements right border == the current index - 1,
    the left border of the element = index of the element on top of the stack + 1
    Time: O(n)
     */
    public int largest (int[] array) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= array.length; i++) {
            int cur = 0;
            if (i == array.length) {
                cur = 0;
            } else {
                cur = array[i];
            }
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int h = array[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                result = Math.max(result, h * (i - left));
            }
            // find all the possible histogram
            stack.offerFirst(i);
        }
        return result;
    }
    public static void main (String[] args) {
        int[] array = {2, 1, 3, 4, 5, 2, 6};
        S3HLargestRectangleInHistogram sol = new S3HLargestRectangleInHistogram();
        System.out.println(sol.largest(array));
    }
}
