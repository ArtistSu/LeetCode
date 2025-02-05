package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag Counting
 * @prb https://leetcode.com/problems/majority-element/description/
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Java_169_2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}