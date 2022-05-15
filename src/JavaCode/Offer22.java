package JavaCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Offer22 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method double pointers
     * @topic The kth node from the bottom of the linked list
     * @author ArtistS
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k <0){
            return null;
        }
        ListNode fastPtr= head, slowPtr=head;
        for(int i = 1;i<k;i++){
            if(fastPtr == null && i != k-1){
                return null;
            }
            if(fastPtr != null && fastPtr.next != null){
                fastPtr = fastPtr.next;
            }
        }
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }
}
