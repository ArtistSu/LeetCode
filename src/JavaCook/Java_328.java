package JavaCook;

/**
 * @author ArtistS
 * @tag LinkedList
 * @prb https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_328 {
    public ListNode oddEvenList(ListNode head) {
        int currIdx = 0;

        ListNode listOddHead = new ListNode();
        ListNode listEvenHead = new ListNode();
        ListNode listOddHeadCopy = listOddHead;
        ListNode listEvenHeadCopy = listEvenHead;

        while (head != null) {
            if (currIdx % 2 == 0) {
                listOddHead.next = head;
                listOddHead = listOddHead.next;
                head = head.next;
                listOddHead.next = null;
            } else {
                listEvenHead.next = head;
                listEvenHead = listEvenHead.next;
                head = head.next;
                listEvenHead.next = null;
            }
            currIdx++;
        }

        // 3. Combination
        listOddHead.next = listEvenHeadCopy.next;
        return listOddHeadCopy.next;
    }

    /**
     * Google L4 L5 Code Improvement
     * @param head
     * @return
     */
    public ListNode oddEvenList_improvement(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

}