package JavaCode;

public class Java83 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Remove Duplicates from Sorted List
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Remove Duplicates from Sorted List
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode currNode = head.next;
        ListNode prevNode = head;
        while(currNode != null){
            if(prevNode.val == currNode.val){
                currNode = currNode.next;
                prevNode.next = currNode;
            }else{
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
        return head;
    }
}
