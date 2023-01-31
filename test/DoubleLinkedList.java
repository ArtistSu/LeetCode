import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertFirst(10);
        System.out.println(doubleLinkedList.readFirst());
        doubleLinkedList.insertLast(20);
        doubleLinkedList.insertLast(60);
        System.out.println(doubleLinkedList.readLast());
        DoubleLinkedList dll = new DoubleLinkedList();
        DoubleLinkedList.Node node = dll.new Node(100);
        doubleLinkedList.insertFirst(node);
        System.out.println(doubleLinkedList.readFirst());
        doubleLinkedList.deleteNode(node);
        System.out.println(doubleLinkedList.readFirst());
    }
    private class Node {
        private Object val;
        private Node prev;
        private Node next;

        public Node(Object value) {
            this.val = value;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    private Node first;
    private Node last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(Object value) {
        Node node = new Node(value);

        if (isEmpty()) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    public void insertFirst(Node node) {
        if (isEmpty()) {
            last = node;
        }
        node.next = first;
        first = node;
    }

    public void insertLast(long value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }

        last = node;
    }

    public void deleteNode(Node node){
        if(node == first){
            if(first.next != null){
                first = first.next;
                first.prev = null;
                last.next = first;
            }
        }else if(node == last){
            last = node.prev;
            node.next = null;
            first.prev = last;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }


    public Object readFirst(){
        return first.getVal();
    }

    public Object readLast(){
        return last.getVal();
    }

    public boolean isEmpty() {
        return first == null;
    }
}
