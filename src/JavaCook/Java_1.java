package JavaCook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @tag HashTable
 * @prb https://leetcode.com/problems/two-sum/
 * @author ArtistS
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class Java_1{
    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    public int[] twoSum_google_l4(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length;i++){
            int gap = target - nums[i];
            if(map.containsKey(gap)) return new int[]{map.get(gap),i};
            map.put(nums[i],i);
        }

        return new int[0];
    }
}