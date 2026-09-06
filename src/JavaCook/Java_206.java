package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag LinkedList Recursion
 * @prb https://leetcode.com/problems/reverse-linked-list/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_206{

    /**
     * But this method will take O(n) as Space Complexity
     */
    public ListNode reverseList(ListNode head) {
        List<ListNode> list = new LinkedList<>();

        // Get all listNode
        while(head.next != null){
            list.add(head);
            head = head.next;
        }

        // Reverse
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        for(int i = list.size()-2; i >=0; i--){
            head.next = list.get(i);
            head = head.next;
        }
        head.next = null;

        return dummyNode.next;
    }

    /**
     * reverseList() will take O(n) Space Complexity, the target should be O(1)
     */
    public ListNode reverseList_google(ListNode head) {
        if(head == null || head.next == null) return head;

        // Declare 3 pointers
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * I assume the sublist starting from head.next has already been reversed. Then I put the current head at the end of that reversed sublist.”
     */
    public ListNode reverseList_google_improvement(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList_google_improvement(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}