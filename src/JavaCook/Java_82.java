package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_82{

    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode deleteDuplicates_google_l4(ListNode head) {
        if(head == null) return null;

        ListNode dummyHead = new ListNode(0,head);
        ListNode prev = dummyHead;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null){
            if(slow.val != fast.val){
                if(slow.next != fast){
                    prev.next = fast;
                    slow = fast;
                    fast = fast.next;
                }else{
                    prev = slow;
                    slow = fast;
                    fast = fast.next;
                }
            }else{
                fast = fast.next;
            }
        }

        if(slow.next != fast){
            prev.next = null;
        }

        return dummyHead.next;
    }

    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode deleteDuplicates_google_l4_2(ListNode head) {
        if(head == null) return null;

        ListNode dummyHead = new ListNode(0,head);
        ListNode prev = dummyHead;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }else{
                prev = prev.next;
            }
            head = head.next;
        }

        return dummyHead.next;
    }
}