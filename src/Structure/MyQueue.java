import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int qStart;

    public MyQueue(){
        data = new ArrayList<>();
        qStart = 0;
    }

    public boolean enQueue(int element){
        data.add(element);
        return true;
    }

    public boolean deQueue(){
        if(this.isEmpty() == true){
            return false;
        }
        qStart++;
        return true;
    }

    public int getFront(){
        return data.get(qStart);
    }

    public int getFront(int index){
        return data.get(qStart);
    }

    public boolean isEmpty(){
        return data.size()<=this.qStart;
    }

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.enQueue(1);
        mq.enQueue(3);
        mq.enQueue(5);
        mq.enQueue(6);
        if (!mq.isEmpty()){
            System.out.println(mq.getFront());
        }
        mq.deQueue();
        if (!mq.isEmpty()){
            System.out.println(mq.getFront());
        }
        for (int x:
                mq.data) {
            System.out.print(x);
        }
    }


}
