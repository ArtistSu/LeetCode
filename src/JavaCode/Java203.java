package JavaCode;

public class Java203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = this.removeElements(head.next, val);
        if(head.val == val){
            return head.next;
        }
        return head;
    }
}
