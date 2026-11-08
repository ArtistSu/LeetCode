package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_148{
    /**
     * @TimeComplexity O(N*log(N)) N is the number of nodes in the ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode sortList(ListNode head) {
        // 1. Defensive check
        if(head == null || head.next == null){
            return head;
        }

        // 2. Split it to 2 sub list
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // 3. Sort 2 sub list
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 4. Merge 2 sub list
        return mergeList(l1, l2);
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null &&l2 != null){
            if(l1.val <l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}