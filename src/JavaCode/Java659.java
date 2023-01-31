package JavaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Java659 {
    /**
     * Time Complexity: O(nlogn) {@param n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic
     * @author ArtistS
     * @method Hash + Min Heap
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, new PriorityQueue<>());
            }
            if(map.containsKey(num-1)){
                int prevLength = map.get(num-1).poll();
                if(map.get(num-1).isEmpty()){
                    map.remove(num-1);
                }
                map.get(num).offer(prevLength+1);
            }else{
                map.get(num).offer(1);
            }
        }
        PriorityQueue[] pq = map.values().toArray(new PriorityQueue[0]);
        for(PriorityQueue temp : pq){
            if((int)temp.peek() < 3){
                return false;
            }
        }
        return true;
    }
}
