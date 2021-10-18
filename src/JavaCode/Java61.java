package JavaCode;

public class Java61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = head;
        int sizeOfList = 1;

        if (head == null || head.next == null) {
            return head;
        }
        while (curr.next != null) {
            curr = curr.next;
            sizeOfList++;
        }

        for (int i = 0; i < k % sizeOfList; i++) {
            curr = head;
            prev = head;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            curr.next = head;
            head = curr;
        }
        System.out.println(head.val);
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        new Java61().rotateRight(a, 6);


    }
}
