package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Stack
 * @prb https://leetcode.com/problems/palindrome-linked-list/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_234{
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode head_cp = head;

        while(head != null){
            stack.push(head);
            head = head.next;
        }

        while(!stack.isEmpty()){
            if(stack.pop().val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}