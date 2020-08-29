import java.util.ArrayList;
import java.util.List;

public class S13LowestCommonAncestorV {
    /*
    base case
    case 1: if all of them are null, return null
    case 2: if only one of them is not null, return the non-null
    case 3: if more than one of them are not null, return root
     */
    public class KnaryTreeNode {
        int key;
        List<KnaryTreeNode> children;
        public KnaryTreeNode (int key) {
            this.key = key;
            this.children = new ArrayList<>();
        }
    }

    public KnaryTreeNode lowestCommonAncestor (KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        if (root == null || root == a || root == b) {
            return root;
        }
        KnaryTreeNode found = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode node = lowestCommonAncestor(child, a, b);
            if (node == null) {
                continue;
            }
            if (found == null) {
                found = node;
            } else {
                return root;
            }
        }
        return found;
    }
}
