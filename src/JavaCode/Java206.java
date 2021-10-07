package JavaCode;

public class Java206 {
    public ListNode reverseList(ListNode head) {
        ListNode nsTemp = head;
        ListNode currNode = head;

        // Check for the edge cases
        // The head is null
        if(head == null){
            return null;
        }

        // Only one element
        if(head.next == null){
            return head;
        }

        while(currNode.next != null){
            nsTemp = head;
            head = currNode.next;
            currNode.next = currNode.next.next;
            head.next = nsTemp;
        }
        return head;

    }
}
