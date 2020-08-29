import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CX2KthSmallestSumFrom2SortedArray {
    /*
    Best First Search

            1       3       5
       4    5       7       9
       8    9       11      13
    Maintain a MinHeap 
    Dedup using a matrix which takes m * n space already
    could use hashSet to dedup minimize to space to k
    Time: O(k log k)
    Space: O(m*n + k)
    Assume k < A.length * B.length
     */
    class Node {
        int i;
        int j;
        int sum;
        public Node (int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public int kthSmallestSum (int[] A, int[] B, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.sum == o2.sum) {
                    return 0;
                }
                return o1.sum < o2.sum ? -1 : 1;
            }
        });
        Node first = new Node(0, 0, A[0] + B[0]);
        boolean[][] visited = new boolean[A.length][B.length];
        visited[0][0] = true;
        minHeap.offer(first);
        for (int index = 1; index < k; index++) {
            Node cur = minHeap.poll();
            if (cur.i + 1 < A.length && !visited[cur.i + 1][cur.j]) {
                minHeap.offer(new Node(cur.i + 1, cur.j, A[cur.i + 1] + B[cur.j]));
                visited[cur.i + 1][cur.j] = true;
            }
            if (cur.j + 1 < B.length && !visited[cur.i][cur.j + 1]) {
                minHeap.offer(new Node(cur.i, cur.j + 1, A[cur.i] + B[cur.j + 1]));
                visited[cur.i][cur.j + 1] = true;
            }
        }
        return minHeap.peek().sum;
    }

    public static void main (String[] args) {
        CX2KthSmallestSumFrom2SortedArray sol = new CX2KthSmallestSumFrom2SortedArray();
        int[] A = {1, 3, 5}; int[] B = {4, 8};
        System.out.println(sol.kthSmallestSum(A, B, 4));
    }

}
