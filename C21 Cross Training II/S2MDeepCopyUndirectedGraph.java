import java.util.*;

public class S2MDeepCopyUndirectedGraph {

    public class GraphNode {
        public int key;
        public List<GraphNode> neighbors;
        public GraphNode (int key) {
            this.key = key;
            this.neighbors = new ArrayList<>();
        }
    }
    /*
    BFS Iterative:
    N1      -     N2
        \       /
            N3
    Step 1: expanding N1:   insert <N1 -N1> into hash table
     generate N2 and N3 insert <N1>   insert <N2 - N2> <n3 - N3> into hash table
    step 2: expanding N2:
     generate N3, since N3 already in the hashtable, we do not need to new(N3),
     we only need to find the 1:1 mapping between N3 and N3'
    step 3: expanding N3: generate nothing
     */
    public List<GraphNode> copy (List<GraphNode> graph) {
        List<GraphNode> newNodes = new ArrayList<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        Map<GraphNode, GraphNode> oldToNew = new HashMap<>();
        for (GraphNode node : graph) {
            oldToNew.put(node, new GraphNode(node.key));
            queue.offer(node);
            newNodes.add(oldToNew.get(node));
        }

        while (!queue.isEmpty()) {
            GraphNode old = queue.poll();
            for (GraphNode neighbor : old.neighbors) {
                if (oldToNew.get(neighbor) == null) {
                    oldToNew.put(neighbor, new GraphNode(neighbor.key));
                    queue.offer(neighbor);
                }
                oldToNew.get(old).neighbors.add(oldToNew.get(neighbor));
            }
        }
        return newNodes;
    }

    /*
    DFS Recursion
    recursive manner. use map to store whether a node has been copied before
    for every single recursion function call, we make a copy of the input node.
    leave all other copies of the successors to the recursion functions
     */
    public List<GraphNode> copyDFS (List<GraphNode> graph) {
        if (graph == null) {
            return null;
        }
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
                DFS(node, map);
            }
        }
        return new ArrayList<>(map.values());
    }

    private void DFS (GraphNode seed, Map<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(seed);
        for (GraphNode nei : seed.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new GraphNode(nei.key));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }
    }


}
