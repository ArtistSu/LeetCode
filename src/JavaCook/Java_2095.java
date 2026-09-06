package JavaCook;

/**
 * @author ArtistS
 * @tag LinkedList TwoPointers
 * @prb https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/2133002798/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity O(N)
 * @SpaceComplexity O(1)
 */
public class Java_2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode headCopy = head;

        // Get the total node number
        int listNodeSize = 0;
        while (head.next != null) {
            listNodeSize++;
            head = head.next;
        }
        listNodeSize++;

        // Get the middle index
        int middleIdx = listNodeSize / 2;

        // Del the node
        int currIdx = 0;
        head = headCopy;
        while (currIdx != (middleIdx - 1)) {
            head = head.next;
            currIdx++;
        }

        if (head.next != null) {
            head.next = head.next.next;
        }

        return headCopy;
    }

    // deleteMiddle need twice traversal, but this method will use two pointers, only need 1 traversal.
    public ListNode deleteMiddle_improvement(ListNode head) {
        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = slow.next;

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        new Java_2095().deleteMiddle(head);
    }
}