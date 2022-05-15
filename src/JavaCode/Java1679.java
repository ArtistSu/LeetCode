package JavaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Java1679 {
    /**
     * Time Complexity: O(n) n is the length of nums[]
     * Space Complexity: O(m) m is the number of distinct value in nums[]
     * @method count sort
     * @topic Max Number of K-Sum Pairs
     * @author ArtistS
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            Integer times = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], times+1);
        }
        int res = 0;
        Set<Integer> keys = hashMap.keySet();
        for(Integer key : keys){
            int differ = k - key;
            if(differ == key){
                res += hashMap.get(key) / 2;
                hashMap.put(key, -1);
                continue;
            }
            if(hashMap.containsKey(differ) && hashMap.get(differ) != -1){
                res += Math.min(hashMap.get(differ), hashMap.get(key));
                hashMap.put(differ, -1);
                hashMap.put(key,-1);
            }
        }
        return res;
    }
}
