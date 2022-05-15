package JavaCode;

public class Java234 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Palindrome Linked List
     * @author ArtistS
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fastPtr = head, slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        // Judge is it even?
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        // Reverse the second half of the linked list
        slowPtr = reverseList(slowPtr);
        fastPtr = head;


        while (slowPtr != null) {
            if (fastPtr.val != slowPtr.val) {
                return false;
            }
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
