package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag SlidingWindow Array
 * @prb https://leetcode.com/problems/contains-duplicate-ii/description/
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class Java_219_2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j <= Math.min(nums.length-1,i+k); j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}