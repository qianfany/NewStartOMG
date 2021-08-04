public class L1486XOROperationInAnArray {

    public int xorOperation (int x, int start) {
        int res = start;
        for (int i = 1; i < x; i++) {
            res = res ^ (start + i * 2);
        }
        return res;
    }
}
