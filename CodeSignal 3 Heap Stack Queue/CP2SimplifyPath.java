import java.util.ArrayDeque;
import java.util.Deque;

public class CP2SimplifyPath {
    /**
     *  /./  will not make any difference
     *  /../ will return to the previous directory
     *  otherwise, add to the stack
     * @param path
     * @return
     */
    public String simplifyPath (String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!s.isEmpty() && !".".equals(s)) {
                stack.offerLast(s);
            }
        }
        return "/" + String.join("/", stack);
    }
}
