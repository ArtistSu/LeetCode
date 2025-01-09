package JavaCook;

/**
 * @author ArtistS
 * @tag ListNode
 * @prb https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Time complexity:O(1)
 * Space complexity: O(1)
 */
public class Java_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode();
        ListNode temp = start;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                temp.next = p1;
                temp = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                temp = p2;
                p2 = p2.next;
            }
        }
        temp.next = (p1 != null) ? p1 : p2;
        return start.next;
    }
}
