package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_19 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode removeNthFromEnd_google_l4(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;


        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;
    }
}