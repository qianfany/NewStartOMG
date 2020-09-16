public class CP7IsListPalindrome {
    /**
     * Find middle
     * reverse the second half
     * check one by one until the second half is null
     * @param l
     * @return
     */
    public boolean isListPalindrome (ListNode l) {
        ListNode fast = l;
        ListNode slow = l;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = l;

        while (slow != null) {
            if (fast.value != slow.value) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse (ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main (String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(-1000000000);
        l.next.next = new ListNode(-1000000000);
        l.next.next.next = new ListNode(1);
        CP7IsListPalindrome sol = new CP7IsListPalindrome();
        System.out.println(sol.isListPalindrome(l));
    }
}
