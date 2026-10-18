package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers
 * @prb https://leetcode.com/problems/linked-list-cycle/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_141{
    /**
     * Time complexity: O(N) N is the number of the node
     * Space complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}