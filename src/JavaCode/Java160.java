package JavaCode;

public class Java160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int sizeOfA = 0;
        int sizeOfB = 0;

        ListNode aPoint = headA;
        ListNode bPoint = headB;

        // Get the size of ListA and ListB
        while (aPoint != null || bPoint != null) {
            if (aPoint != null) {
                aPoint = aPoint.next;
                sizeOfA++;
            }
            if (bPoint != null) {
                bPoint = bPoint.next;
                sizeOfB++;
            }
        }

        // Initial the head point of each list.
        aPoint = headA;
        bPoint = headB;

        if (sizeOfA > sizeOfB) {
            int difference = sizeOfA - sizeOfB;
            while (difference-- > 0) {
                aPoint = aPoint.next;
            }
        } else if (sizeOfB > sizeOfA) {
            int difference = sizeOfB - sizeOfA;
            while (difference-- > 0) {
                bPoint = bPoint.next;
            }
        }

        while (aPoint != null) {
            if (aPoint == bPoint) {
                return aPoint;
            }
            aPoint = aPoint.next;
            bPoint = bPoint.next;
        }
        return null;


    }
}
