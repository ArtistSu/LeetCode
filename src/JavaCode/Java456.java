package JavaCode;

import java.util.Deque;
import java.util.LinkedList;

public class Java456 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic 132 Pattern
     * @author ArtistS
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        queue.push(nums[len -1]);
        int maxIntermediate = Integer.MIN_VALUE;
        for(int i = len - 2; i >= 0; i--){
            if(nums[i] < maxIntermediate){
                return true;
            }
            while(!queue.isEmpty() && nums[i] > queue.peek()){
                maxIntermediate = queue.pop();
            }
            if(nums[i] > maxIntermediate){
                queue.push(nums[i]);
            }
        }
        return false;
    }
}
