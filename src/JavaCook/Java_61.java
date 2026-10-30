package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_61{
    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode rotateRight_google_l4(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 ) return head;

        // Handle k > the number of nodes in ListNode head
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        // tail.next should be the head
        tail.next = head;

        // Find the new tail node by moving forward len - k - 1 steps.
        ListNode newTail = head;
        for(int i = 0 ; i < len - k - 1; i++){
            newTail =  newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}