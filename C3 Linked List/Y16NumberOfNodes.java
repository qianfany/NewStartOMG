public class Y16NumberOfNodes {

    public int numberOfNodes (ListNode head) {
        if (head == null) {
            return 0;
        }
        int num = 0;
        while (head != null) {
            head = head.next;
            num++;
        }
        return num;
    }
}
