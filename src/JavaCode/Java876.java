package JavaCode;

public class Java876 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method fast and slow pointer
     * @topic Middle of the Linked List
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode fastPtr= head, slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Middle of the Linked List
     * @author ArtistS
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode  currNode = head;
        int times = 0;
        while(currNode != null){
            currNode = currNode.next;
            times++;
        }
        times = times /2;

        while(times != 0){
            head = head.next;
            times--;
        }
        return head;
    }
}
