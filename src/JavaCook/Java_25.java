package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_25 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode reverseKGroup_google_l4(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;

        // 1. Calculate the nodes
        int nodeCount = 0;
        ListNode curr = head;
        while (curr != null) {
            nodeCount++;
            curr = curr.next;
        }

        // 2. Reverse
        for (int i = 0; i < nodeCount / k; i++) {
            reverseNodes(prev, k);
            for (int j = 0; j < k; j++) {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    public void reverseNodes(ListNode prev, int k) {
        ListNode curr = prev.next;
        ListNode nextTemp = null;
        for (int i = 0; i < k - 1; i++) {
            nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = prev.next;
            prev.next = nextTemp;
        }
    }

    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     * Note: One pass, no need to count the nodes at the beginning
     */
    public ListNode reverseKGroup_google_l5(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode tail = dummyHead;

        while (true) {
            int count = 0;
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }

            if (tail == null) break;

            reverseNodes(prev, k);

            for (int i = 0; i < k; i++) {
                prev = prev.next;
            }
            tail = prev;
        }
        return dummyHead.next;
    }
}