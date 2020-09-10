import java.util.Deque;
import java.util.LinkedList;

public class L71SimplifyPath {
    /*
    1. Initialize a stack
    2. split the input string using /
    if the current component is not "" or "."
        stack.push
    else if ".."
        pop the stack

    post process, add "/" before convert to string

    Time: O(n)
    Space: O(n)
     */
    public String simplifyPath (String path) {
        Deque<String> stack = new LinkedList<>();
        for(String s: path.split("/")){
            if(s.equals("..") ) {
                stack.poll();
            }
            else if(!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.size() == 0) {
            return "/";
        }
        while(stack.size() != 0) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }
}
