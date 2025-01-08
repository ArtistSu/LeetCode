package java;

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
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                int[] res = new int[2];
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                Arrays.sort(res);
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[] {};
    }
}