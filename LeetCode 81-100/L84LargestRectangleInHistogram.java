import java.util.Deque;
import java.util.LinkedList;

public class L84LargestRectangleInHistogram {
    /*
    use  a stack to store all the indices of the columns that form an ascending order
    stack that stores the indices in ascending order bottom [


    Principle, to maintain the stack to make sure the columns whose indices are stored in the stack
    form an ascending order
    when popped an element out of the stack, the elements right border == the current index - 1,
    the left border of the element = index of the element on top of the stack + 1
    Time: O(n)
     */
    public int largestRectangleArea (int[] heights) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= heights.length; i++) {
            int cur = 0;
            if (i == heights.length) {
                cur = 0;
            } else {
                cur = heights[i];
            }
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= cur) {
                int h = heights[stack.pollFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                result = Math.max(result, h * (i - left));
            }
            // find all the possible histogram
            stack.offerFirst(i);
        }
        return result;
    }
}
