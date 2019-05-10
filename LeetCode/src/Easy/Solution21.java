package Easy;

import java.util.List;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-10 11:05
 * @Description Merge two sorted linked lists and return it as a new list. The new
 * list should be made by splicing together the nodes of the first two lists.
 */
public class Solution21 {
    ListNode result = new ListNode(0);

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }
        if(l1.val>l2.val){
           return mergeTwoLists(l2,l1);
        }
        l1.next = mergeTwoLists(l1.next,l2);
        return l1;
    }
}

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }