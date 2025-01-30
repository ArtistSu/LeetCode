package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag Sorting
 * @prb https://leetcode.com/problems/contains-duplicate/description/
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Java_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}