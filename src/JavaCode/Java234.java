package JavaCode;

public class Java234 {
    ListNode left = null;
    Boolean value = true;
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        left = head;
        check(head);
        return value;

    }

    public void check(ListNode right){
        if(right == null){
            return;
        }

        check(right.next);

        if(left.val != right.val){
            value = false;
            return;
        }

        left = left.next;

    }
}
