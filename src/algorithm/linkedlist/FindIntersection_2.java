package algorithm.linkedlist;


public class FindIntersection_2 {
    public Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node curr1 = head1;
        Node curr2 = head2;
        int diff = 0;
        while (curr1.next != null) {
            diff++;
            curr1 = curr1.next;
        }
        while (curr2.next != null) {
            diff--;
            curr2 = curr2.next;
        }
        // If the last node of head1 not equal to the last node of head2,
        // It means no intersection there.
        if (curr1 != curr2) return null;
        curr1 = diff > 0 ? head1 : head2; // long linked list give to curr1
        curr2 = curr1 == head1 ? head2 : head1; // shor linked list give to curr2
        diff = Math.abs(diff);
        while (diff != 0) {
            diff--;
            curr1 = curr1.next;
        }

        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }
}
