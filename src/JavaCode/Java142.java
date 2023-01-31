package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java142 {
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param head}
     * Space Complexity: O(1)
     * @topic Linked List Cycle II
     * @author ArtistS
     * @method Fast and Slow pointers
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        // Edge Case
        if(head == null){
            return null;
        }

        // Find the meeting point
        ListNode slow = head, fast = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                fast = null;
            }

            if(fast == null){
                return null;
            }
            if(fast == slow){
                break;
            }
        }
        ListNode newNode = head;
        while(newNode != slow){
            newNode=newNode.next;
            slow=slow.next;
        }
        return newNode;
    }
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

