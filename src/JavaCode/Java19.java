package JavaCode;

public class Java19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 1;
        ListNode point = head;
        int difference;

        // Get the size of the list
        while(point.next != null){
            point = point.next;
            sz++;
        }
        System.out.println(sz);

        // Check for edge cases
        if(sz == 1){
            return null;
        }
        if(sz == n){
            return head.next;
        }

        point = head;
        difference = sz - n;

        while(difference > 0){
            point = point.next;
            difference --;

        }
        point.next = point.next.next;
        return head;
    }
}
