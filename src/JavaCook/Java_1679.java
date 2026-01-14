package JavaCook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag TwoPointers Array HashTable SortingLC75
 * @prb https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 * @TimeComplexity: O(nlogn)
 * @SpaceComplexity: O(1)
 */
public class Java_1679 {
    // TimeComplexity:O(n) SpaceComplexity:O(1)
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // 1. Save pair with (num,count)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. Try to find whether the difference (k-num) exists or not
        int target = 0;
        for (int num : nums) {
            target = k - num;
            if (!map.containsKey(target)) continue;
            if (map.get(target) <= 0 || map.get(num) <= 0) continue;

            if (num * 2 == k && map.get(num) < 2) continue;

            map.put(target, map.get(target) - 1);
            map.put(num, map.get(num) - 1);
            count++;
        }
        return count;
    }

    public int maxOperationsV2(int[] nums, int k) {
        int start = 0, end = nums.length - 1, count = 0;
        Arrays.sort(nums);

        while (start < end) {
            if(nums[start]+nums[end] == k){
                count++;
                start++;
                end--;
            } else if (nums[start] + nums[end] < k) {
                start++;
            }else{
                end--;
            }
        }
        return count;
    }
}