package JavaCook;

/**
 * @author ArtistS
 * @tag LinkedList TwoPointers
 * @prb https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_2130 {
    public int pairSum(ListNode head) {

        int maxSum = 0;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode reverseHead = reverseListNode(slow);

        // Here must be reverseHead, otherwise will report nullPointer
        while (reverseHead != null) {
            maxSum = Math.max(maxSum, reverseHead.val + head.val);
            head = head.next;
            reverseHead = reverseHead.next;
        }

        return maxSum;

    }

    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode res = reverseListNode(head.next);

        head.next.next = head;
        head.next = null;

        return res;
    }

}