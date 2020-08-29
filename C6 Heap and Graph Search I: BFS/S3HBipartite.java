import java.util.*;

public class S3HBipartite {
    public class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode (int key) {
            this.key = key;
            this.neighbors = new ArrayList<>();
        }
    }
    /*
    1(u)  --  2(v)  --  4(u)
      |        |
    3(v)  --  5(u)
    Coloring problem

    Data Structure:     FIFO queue
    Algorithm: Breath First Search
    Initialize: enqueue 1, color 1 with u
    for each step:
    Expand: dequeue the first element (x) of the queue
    Generate: enqueue all the neighbor(y) and color them with the other color
        case 1: y is generated before
            case 1.1: y's color is different from x's color, ignore
            case 1.2: y's color is same as x's, conflict
        case 2: y is not generated before
            color y with the other color than x
    Termination: queue is empty or when there is conflict
    Deduplication: record each node's color (empty, u, v)
    Time: O(n + E)
    Space: O(n)
     */

    public boolean isBipartite (List<GraphNode> graph) {
        Map<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node: graph) {
            if (!BFS (node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS (GraphNode node, Map<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup ^ 1;
            for (GraphNode nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    return false;
                }
            }
        }
        return true;
    }
}
