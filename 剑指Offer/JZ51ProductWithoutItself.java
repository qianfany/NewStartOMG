public class JZ51ProductWithoutItself {
    /*
    B[i] = A[0] * A[1] *...* A[i-1] * A[i+1] *...* A[n-1]
    from left to right B[i] = A[0] * A[1] *...* A[i-1]
    from right to left B[i]*= A[i+1] *...* A[n-1]
     */
    public int[] multiply (int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (A == null || A.length <= 1) {
            return null;
        }
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i -1];
        }
        int tmp = 1;
        for (int i = length - 1; i >= 0; i--) {
            B[i] = tmp * B[i];
            tmp = A[i] * tmp;
        }
        return B;
    }
}
