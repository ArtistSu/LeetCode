package JavaCook;

/**
 * @author ArtistS
 * @tag LinkedList
 * @prb https://leetcode.com/problems/remove-linked-list-elements/description/
 * Time complexity:O(n)
 * Space complexity: O(1)
 */
public class Java_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(-1, head);
        ListNode res = pre;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }else{
                pre = head;
            }
            head = head.next;
        }
        return res.next;
    }
}
