package JavaCode;

public class Java160 {
    /**
     * Time Complexity: O(m+n) {@code m} is the length of {@param headA}, {@code n} is the length of {@param headB}
     * Space Complexity: O(1)
     * @method Two Pointers
     * @topic Intersection of Two Linked List
     * @author ArtistS
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;

        while(ptrA != ptrB){
            if(ptrA == null && ptrB == null){
                return null;
            }
            ptrA = (ptrA == null ? headB : ptrA.next);
            ptrB = (ptrB == null ? headA : ptrB.next);
        }
        return ptrA;
    }
}
