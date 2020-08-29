public class S11MCheckIfLinkedListIsPalindrome {
    /*
    in place way
    find middle point,
    split into two, reverse the second
    check one by one
     */
    public boolean isPalindrome (ListNode head) {
        if (head == null || head.next ==null){
            return true;
        }
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        while (head2 != null){
            if (head.value != head2.value){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;

    }
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if (head == null || head.next ==null){
            return head;
        }
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
