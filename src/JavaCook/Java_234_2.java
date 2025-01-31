package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Recursion
 * @prb https://leetcode.com/problems/palindrome-linked-list/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_234_2 {
    ListNode curr;

    public boolean isPalindrome(ListNode head) {
        curr = head;
        return traceBack(curr);
    }

    public boolean traceBack(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean ans = traceBack(head.next) && head.val == curr.val;
        curr = curr.next;
        return ans;
    }
}