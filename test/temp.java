

public class temp {
    static int count = 0;

    public static void main(String[] args) {
        temp.f(1024, 0);
    }

    public static void f(int n, int d) {
        System.out.println(temp.space(d) + "n=" + n + " begins");
        count++;
        if (n > 1) {
            f(n / 2, d + 1);
            System.out.println(space(d + 1) + "hi");
            count++;
            f(n / 2, d + 1);
        }
        System.out.println(space(d) + "n=" + n + " ends");
        count++;
        System.out.println(count);
    }

    public static StringBuffer space(int d) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < d; i++) {
            sb.append(" ");
        }
        return sb;
    }

    // Java Code

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param arr
     * @return
     * @author: AllenS
     */
    public int[] InsertionSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        if(arr.length == 2){
            if(arr[1] > arr[0]){
                return arr;
            }else{
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
                return arr;
            }
        }

        for(int i=2; i < arr.length; i++){
            int curr = arr[i];
            int j = i -1;
            while(j > 0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j = j -1;
            }
            arr[j+1] = curr;
        }
        return arr;
    }


}
 class LinkedStack<T> {

    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }
}

class Queue<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }
    private Node<T> head = new Node<T>();
    private Node<T> tail = new Node<T>();
    public void enqueue(T x) {
        if(head == null){
            head = new Node<T>(x,null);
        }else{
            tail.next = new Node<T>(x,null);
            tail = tail.next;
        }
    }
    T dequeue() {
        T x = head.item;
        head = head.next;
        return x;
    }
}
