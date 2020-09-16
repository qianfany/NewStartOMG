public class CP11RearrangeLastN {
    /**
     *      1 -> 2 -> 3 -> 4 -> 5 -> null
     *                          f
     *           s
     * @param l
     * @param n
     * @return
     */
    public ListNode rearrange (ListNode l, int n) {
        if (l == null || n == 0) {
            return l;
        }
        ListNode slow = l;
        ListNode fast = l;
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return l;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = l;
        return res;
    }
}
