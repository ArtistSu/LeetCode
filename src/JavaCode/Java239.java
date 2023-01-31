package JavaCode;

import java.util.*;
import java.util.function.ToIntFunction;

public class Java239 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Sliding Window Maximum
     * @author ArtistS
     * @method monotonic queue
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int len = nums.length;

        // Create monotonic queue
        Deque<Integer> deque = new LinkedList<>();

        // Put nums[0]-nums[k] into deque
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && nums[i]>= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        //traverse
        int[] res = new int[len-k+1];
        res[0] = nums[deque.peekFirst()];
        for(int i = k;i < len; i++){
            while(!deque.isEmpty() && nums[i]>= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            res[i-k+1] = nums[deque.peekFirst()];
        }
        return res;
    }
    /**
     * Time Complexity: O(nlogn) {@param n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Sliding Window Maximum
     * @author ArtistS
     * @method PriorityQueue
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;

        // Create pq in increasing order
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] m, int[] n){
                return m[0] != n[0] ?n[0]-m[0] : n[1]-m[1];
            }
        });

        // Put nums[0]-nums[k] into pq
        for(int i = 0; i < k; i++){
            pq.offer(new int[]{nums[i],i});
        }

        //traverse
        int[] res = new int[len-k+1];
        res[0] = pq.peek()[0];
        for(int i = k;i < len; i++){
            pq.offer(new int[]{nums[i], i});
            while(pq.peek()[1] < (i-k+1)){
                pq.poll();
            }
            res[i-k+1] = pq.peek()[0];
        }

        return res;
    }
    /**
     * Time Complexity: O(nk-k) {@param n} is the length of {@params nums} {@pram k}
     * Space Complexity: O(n-k)
     * @topic Sliding Window Maximum
     * @author AtrtisS
     * @method Stream + BF
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = (left + k - 1);
        List<Integer> temp = new LinkedList<>();
        while(right < nums.length){
            int max = nums[left];
            for(int i = left; i <= right; i++){
                max = Math.max(nums[i], max);
            }
            temp.add(max);
            left++;
            right++;
        }
        int[] res = temp.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {

                return Integer.valueOf(value);
            }
        }).toArray();

        return res;
    }
}
