package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/10 9:24 上午
 * Description:
 */
public class Solution119 {
    public static void main(String[] args) {
        Solution119 s = new Solution119();
        s.getRow(3);
    }
    public List<Integer> getRow(int rowIndex) {
        //1. If the rowIndex less than 0, return an empty list.
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        //2. Create a result list and a queue which is used to save temp element;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //3. Initial the first queue
        queue.offer(1);
        //4. Calculate the mid elements
        for (int rowNum = 1; rowNum <= rowIndex; rowNum++) {
            int temp = 0;
            for (int i = 1; i <= rowNum; i++) {
                queue.offer(temp + queue.element());
                temp = queue.poll();
            }
            queue.offer(1);
        }
        //5. Add the elements of queue into the list.
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
