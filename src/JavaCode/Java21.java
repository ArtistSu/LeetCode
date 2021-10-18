package JavaCode;

public class Java21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode originalHead = null;
        ListNode operateNode = null;
        // Check for edge cases
        if (l1 == null || l2 == null) {
            if (l1 == null && l2 == null) {
                return null;
            }
            return l1 == null ? l2 : l1;
        }

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                if (operateNode == null) {
                    operateNode = l1;
                    originalHead = operateNode;
                    l1 = l1.next;
                } else {
                    operateNode.next = l1;
                    operateNode = operateNode.next;
                    l1 = l1.next;
                }
            } else {
                if (operateNode == null) {
                    operateNode = l2;
                    originalHead = operateNode;
                    l2 = l2.next;
                } else {
                    operateNode.next = l2;
                    operateNode = operateNode.next;
                    l2 = l2.next;
                }
            }
        }
        if (l1 != null) {
            operateNode.next = l1;
        } else {
            operateNode.next = l2;
        }
        return originalHead;
    }

    // Time Complexity: O(m + n)  Space Complexity: O(1)
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode originalHead = headNode;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                headNode.next = l1;
                l1 = l1.next;
                headNode = headNode.next;
            }else{
                headNode.next = l2;
                l2 = l2.next;
                headNode = headNode.next;
            }
        }
        headNode.next = (l1 != null ? l1 : l2);
        return originalHead.next;
    }

}
