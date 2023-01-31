package JavaCode;

public class Java19 {
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param head}
     * Space Complexity: O(1)
     * @topic Remove Nth Node From End of List
     * @author ArtistS
     * @method Two Pointer
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode res = new ListNode(0,head);
        ListNode first = head, second = res;

        while(n - 1 > 0){
            first = first.next;
            n--;
        }

        while(first.next != null){
            second = second.next;
            first = first.next;
        }

        second.next = second.next.next;
        return res.next;
    }
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param head}
     * Space Complexity: O(1)
     * @topic Remove Nth Node From End of List
     * @author ArtistS
     * @method Stimulate
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;

        // Statistic the number of nodes in the listNode
        int sz = 0;
        while(head != null){
            head = head.next;
            sz++;
        }
        head = res;

        int difference = sz - n;

        // Edge Case
        if(head == null || sz == 1){
            return null;
        }

        if(sz == n){
            return head.next;
        }

        while(difference > 1){
            head = head.next;
            difference--;
        }
        head.next = head.next.next;
        return res;
    }
}
