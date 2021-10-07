package JavaCode;

public class Java142 {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;

        if(head == null){
            return null;
        }

        // Whether there is a cycle
        while(fast != null){
            slow = slow.next;

            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }

            if(fast==slow){
                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;

    }
}
