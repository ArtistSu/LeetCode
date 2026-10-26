package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_92{
    /**
     * @TimeComplexity O(right-left)
     * @SpaceComplexity O(1)
     */
    public ListNode reverseBetween_google_l4(ListNode head, int left, int right) {
        if(head == null) return null;

        ListNode dummyHead = new ListNode(0,head);
        ListNode prev = dummyHead;

        for(int i = 0; i < left-1; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode nextTemp = null;
        for(int i = 0; i < right-left;i++){
            nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = prev.next;
            prev.next = nextTemp;
        }

        return dummyHead.next;
    }
}