package algorithm.linkedlist;


import algorithm.common.Node;

public class FindIntersection {
    public Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node curr1 = head1;
        Node curr2 = head2;
        int count = 0;
        // Find total nodes
        while (curr1.next != null) {
            count++;
            curr1 = curr1.next;
        }
        while (curr2.next != null) {
            count--;
            curr2 = curr2.next;
        }

        while(count > 0){
            if(curr1 == curr2) return curr1;
            if(curr1.next != null && curr2.next != null){
                curr1 = curr1.next;
                curr2 = curr2.next;
                count--;
            }else{
                curr1 = curr1.next == null ? head2 : curr1.next;
                curr2 = curr2.next == null ? head1 : curr2.next;
            }
        }
        return null;
    }
}
