public class S8MSearchInUnknownSizedSortedArray {
    /*
    follow-up. jump size * 2 or jump size * 10
    jump out ---->  log2(n)   binary search ----> log2(2n)
    jump out ---->  log10(n)  binary search ----> log2(10n)
    jump 10 is faster

    log10 (n) + log2 (10n)     	vs 	log2 (n) + log2 (2n)

    log 10 (n) - log2 (n) + (log2 (10n) - log2 (2n))
    =     log 10 (n) - log2 (n)  + 2.3

     */
    interface Dictionary {
        public Integer get (int index);
    }


    public int search (Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0, right = 1;
        while (dict.get(right) != null) {
            right = right * 2;
        }
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (dict.get(mid) == null) {
                right = mid - 1;
            }
            else if (target == dict.get(mid)) {
                return mid;
            }
            else if (target > dict.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
