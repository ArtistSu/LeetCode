package JavaCook;

/**
 * @author ArtistS
 * @tag ListNode
 * @prb https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Time complexity:O(N)
 * Space complexity: O(1)
 */
public class Java_21 {
    /**
     * Time complexity:O(M+N) M is the number of nodes in list1, and N is the number of nodes in list2.
     * Space complexity: O(1)
     */
    public ListNode mergeTwoLists_google_l4(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1 == null ? list2 : list1;
        return dummyHead.next;
    }
}
