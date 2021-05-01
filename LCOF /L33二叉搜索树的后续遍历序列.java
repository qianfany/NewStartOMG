public class L33二叉搜索树的后续遍历序列 {

    /*
    postorder       left right root
    last element is root
    binary search tree
    everything in the left are smaller than root
    everything in the right are larger than root
     */
    public boolean verifyPostorder (int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return splitCheck(postorder, 0, postorder.length - 1);
    }

    private boolean splitCheck (int[] post, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = post[end];
        int i;
        for (i = start; i < end; i++) {
            if (post[i] > root) {
                break;
            }
        }
        int j = i;
        while (j < end) {
            if (post[j] < root) {
                return false;
            }
            j++;
        }
        return splitCheck(post, start, i - 1) && splitCheck(post, i, end - 1);
    }
}
