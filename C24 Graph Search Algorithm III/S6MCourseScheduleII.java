import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class S6MCourseScheduleII {
    /*
    Topological sort
    1. Pick a course that has no incoming edges as the first course
    2. remove all outgoing edges from this course
    3. find the next course that has no incoming edges
    4.....

    data Structure:
    1. a workList of nodes that have no incoming edges
    2. a list that represents the topological order

    Algorithm:
    initialize:
    1. compute the number of incoming edges to each node
    2. put nodes that have no incoming edges into the work list

    In each step:
    1. Remove any node from the list and append it to the topological order
    2. Decrement the number of incoming edges of each node Y that X points to
    3. if Y has no incoming edges after the decrement, add Y to the work List

    Termination Condition: the work list is empty, if no all nodes are in the topological order,
    work list is empty, there must be a circular dependency and therefore, no topological order
     */
    public int[] findOrder (int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] dependency : prerequisites) {
            int x= dependency[0];
            int y = dependency[1];
            graph.get(y).add(x);
        }
        return topologicalSort(graph);
    }

    private int[] topologicalSort (List<List<Integer>> graph) {
        int numCourses = graph.size();
        int[] topologicalOrder = new int[numCourses];
        int[] incomingEdges = new int[numCourses];
        for (int x = 0; x < numCourses; x++) {
            for (int y : graph.get(x)) {
                incomingEdges[y]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int x = 0; x < numCourses; x++) {
            if (incomingEdges[x] == 0) {
                queue.offer(x);
            }
        }
        int numExpanded = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            topologicalOrder[numExpanded++] = x;
            for (int y : graph.get(x)) {
                if (--incomingEdges[y] == 0) {
                    queue.offer(y);
                }
            }
         }
        return numExpanded == numCourses ? topologicalOrder : new int[]{};
    }
}
