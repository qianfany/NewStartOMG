public class L1720DecodeXORedArray {
    /*
    [1, 2, 3]       encode
    [1, 0, 2, 1]    decode
    1 ^ 0 = 1
    1 ^ 1 = 0      exclusive OR apply commutative rule
     */
    public int[] decode (int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];

        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
