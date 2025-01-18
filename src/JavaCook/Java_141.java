package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers
 * @prb https://leetcode.com/problems/linked-list-cycle/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_141{
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode pointer = head;
        ListNode pointer_2 = head;

        while(pointer_2 != null && pointer_2.next != null){
            pointer = pointer.next;
            pointer_2 = pointer_2.next.next;
            if(pointer == pointer_2){
                return true;
            }
        }

        return false;
    }
}