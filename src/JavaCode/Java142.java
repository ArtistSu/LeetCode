package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java142 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Linked List Cycle II
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set set = new HashSet<>();
        if(head == null || head.next == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode resPtr = head;
        int times = 0;
        while(fastPtr.next != null && fastPtr.next.next != null && times <= 50001){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                while(resPtr != fastPtr){
                    resPtr = resPtr.next;
                    fastPtr = fastPtr.next;
                }
                return fastPtr;
            }
            times+=1;
        }
        return null;
    }
}

