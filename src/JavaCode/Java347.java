package JavaCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Java347 {
    /**
     * Time Complexity: O(nlogK) {@param n} is the length of {@param nums} {@param k}
     * Space Complexity: O(n)
     * @topic Top K Frequent Elements
     * @author ArtistS
     * @method PriorityQueue
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Get the occurrences
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // Priority Queue with increasing order
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] m, int[]n){
                return m[1] - n[1];
            }
        });

        // Traverse
        for(int key: map.keySet()){
            if(pq.size()==k){
                if(pq.peek()[1] < map.get(key)){
                    pq.poll();
                    pq.offer(new int[]{key, map.get(key)});
                }
            }else{
                pq.offer(new int[]{key, map.get(key)});
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
