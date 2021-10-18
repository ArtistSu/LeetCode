package JavaCode;

public class Java2 {

    // Time Complexity: O(m+n)  Space Complexity: O(max(m,n) + x)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Carry identifier
        int tag = 0;
        int sum = 0;
        ListNode newHead = new ListNode(0);
        ListNode resultNode = newHead;


        // Add two numbers
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + tag;

            if (sum < 10) {
                newHead.next = new ListNode(sum);
                newHead = newHead.next;
                tag = 0;

                l1 = l1.next;
                l2 = l2.next;
                continue;
            } else {
                tag = sum / 10;
                newHead.next = new ListNode(sum % 10);
                newHead = newHead.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        // In case l1.size() != l2.size()
        if (l1 == null) {
            while (l2 != null) {
                if (l2.val + tag < 10) {
                    newHead.next = new ListNode(l2.val + tag);
                    tag = 0;
                    newHead = newHead.next;
                } else {
                    tag = (l2.val + tag) / 10;
                    newHead.next = new ListNode((l2.val + tag) % 10);
                    newHead = newHead.next;
                }
                l2 = l2.next;
            }
        }

        if (l2 == null) {
            while (l1 != null) {
                if (l1.val + tag < 10) {
                    newHead.next = new ListNode(l1.val + tag);
                    tag = 0;
                    newHead = newHead.next;
                } else {
                    tag = (l1.val + tag) / 10;
                    newHead.next = new ListNode((l1.val + tag) % 10);
                    newHead = newHead.next;
                }
                l1 = l1.next;
            }
        }


        if (tag != 0) {
            newHead.next = new ListNode(tag);
        }


        return resultNode.next;

    }


}

