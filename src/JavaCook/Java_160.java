package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers
 * @prb https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}