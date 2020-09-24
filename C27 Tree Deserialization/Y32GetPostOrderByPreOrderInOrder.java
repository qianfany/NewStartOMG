import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Y32GetPostOrderByPreOrderInOrder {

    public int[] postOrder (int[] pre, int[] in) {
        // Write your solution here
        int len = pre.length;
        //store key-index pairs of inOrder array into HashMap for quick-search
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(in[i], i);
        }
        List<Integer> res = new ArrayList<>();
        //use array to pass preIndex (the root of each subtree) down
        int[] preIndex = new int[]{0};
        postOrder(in, 0, len-1, pre, preIndex, map, res);
        int[] post = new int[res.size()];
        //convert it to int[] for output
        for(int i = 0; i < len; i++){
            post[i] = res.get(i);
        }
        return post;
    }
    private void postOrder(int[] in, int inLeft, int inRight, int[] pre, int[] preIndex,
                           Map<Integer, Integer> map, List<Integer> res){
        if(inLeft > inRight){
            return;
        }
        //find the root node of each subtree in inOrder array for tree division
        //Note: increment preIndex[0] to update the function in preOrder array
        int index = map.get(pre[preIndex[0]++]);
        //left subtree
        postOrder(in, inLeft, index-1, pre, preIndex, map, res);
        //right subtree
        postOrder(in, index+1, inRight, pre, preIndex, map,res);
        //classic postOrder traversal, add the root
        res.add(in[index]);
    }

    public static void main (String[] args) {
        Y32GetPostOrderByPreOrderInOrder sol = new Y32GetPostOrderByPreOrderInOrder();
        int[] pre = {10, 5, 2, 7, 15, 12};
        int[] in = {2, 5, 7, 10, 12, 15};
        System.out.print(Arrays.toString(sol.postOrder(pre, in)));
    }
}
