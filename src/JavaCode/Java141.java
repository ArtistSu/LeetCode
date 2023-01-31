package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java141 {
    /**
     * Time Complexity : O(n) {@param n} is the number of nodes in {@param head}
     * Space Complexity : O(1)
     * @topic Linked List Cycle
     * @author ArtistS
     * @method fast and slow pointer
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        // Edge case
        if(head == null){
            return false;
        }

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

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

