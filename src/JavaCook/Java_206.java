package JavaCook;

/**
 * @author ArtistS
 * @tag LinkedList Recursion
 * @prb https://leetcode.com/problems/reverse-linked-list/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_206{
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}