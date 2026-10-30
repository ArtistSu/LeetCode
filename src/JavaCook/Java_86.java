package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_86 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in ListNode head
     * @SpaceComplexity O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // In case loop
        large.next = null;

        small.next = largeDummy.next;
        return smallDummy.next;
    }
}