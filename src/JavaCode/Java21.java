package JavaCode;

public class Java21 {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Merge Two Sorted Lists
     * @author ArtistS
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode point1=l1;
        ListNode point2=l2;
        ListNode ln = new ListNode(0);
        ListNode currNode = ln;
        while(point2 != null){
            if(point1 != null && point1.val<=point2.val){
                currNode.next = point1;
                currNode = point1;
                point1 = point1.next;
            }else{
                currNode.next = point2;
                currNode = point2;
                point2 = point2.next;
            }
        }
        currNode.next = point1;

        return ln.next;
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
