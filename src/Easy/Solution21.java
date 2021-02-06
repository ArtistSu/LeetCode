package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/13 9:09 下午
 * Description:
 */
public class Solution21 {
    ListNode result = new ListNode(0);

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val > l2.val) {
            return mergeTwoLists(l2, l1);
        }
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
}
