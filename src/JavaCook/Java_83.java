package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.next.val == curNode.val) {
                if (curNode.next.next != null) {
                    curNode.next = curNode.next.next;
                } else {
                    curNode.next = null;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }
}