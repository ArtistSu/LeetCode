package JavaCode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


public class Java206 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method iteration
     * @topic Reverse Linked List
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while(currNode != null){
            ListNode next = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }
        return preNode;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method recursion
     * @topic Reverse Linked List
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
