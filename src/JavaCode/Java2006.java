package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java2006 {
    /**
     * BF method
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j< nums.length; j++){
                if(nums[i]-nums[j] == -k || nums[i]-nums[j] == k){
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * Hash
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference2(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            res += cnt.getOrDefault(nums[i]-k,0) + cnt.getOrDefault(nums[i]+k,0);
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
        }
        return res;
    }
 }
