public class S5CountArithmeticMeans {
    /**
     * corner case: length <= 1 return 0
     *  pre process
     *  normal process
     *  post process
     * @param a
     * @return
     */
    public int countArithmeticMeans (int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0] == 0 ? 1 : 0;
        }
        int res = 0;
        if ( (a[1] / 2.0) == (double) a[0]) {
            res++;
        }

        for (int i = 1; i < a.length - 1; i++) {
            if ((double) ((a[i - 1] + a[i + 1])/2.0) == (double) a[i]) {
                res++;
            }
        }
        if ((double) (a[a.length -1]) ==  (a[a.length - 2] /2.0)) {
            res++;
        }
        return res;
    }

    public static void main (String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        S5CountArithmeticMeans sol = new S5CountArithmeticMeans();
        System.out.println(sol.countArithmeticMeans(a));
    }
}
