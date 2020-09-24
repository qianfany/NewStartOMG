import java.util.ArrayDeque;
import java.util.Deque;

public class Y34TernaryExpressionTree {

    public class ExpNode {
        public char symbol;
        public ExpNode left;
        public ExpNode right;
        public ExpNode (char symbol) {
            this.symbol = symbol;
        }
    }

    public ExpNode tree (String exp) {
        if (exp == null || exp.length() == 0) {
            return null;
        }
        char[] array = exp.toCharArray();

        ExpNode root = new ExpNode(array[0]);
        Deque<ExpNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        for (int i = 1; i < array.length; i += 2) {
            ExpNode node = new ExpNode(array[i + 1]);
            if (array[i] == '?') {
                stack.peekFirst().left = node;
            }
            if (array[i] == ':') {
                stack.pollFirst();
                while (stack.peekFirst().right != null) {
                    stack.pollFirst();
                }
                stack.peekFirst().right = node;
            }
            stack.offerFirst(node);
        }
        return root;
    }

    public static void main (String[] args) {
        Y34TernaryExpressionTree sol = new Y34TernaryExpressionTree();
        String exp = "a?b:c";
        System.out.print(sol.tree(exp));
    }
}
