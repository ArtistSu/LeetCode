package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java141 {

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * @topic Linked List Cycle
     * @author ArtistS
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }
}

