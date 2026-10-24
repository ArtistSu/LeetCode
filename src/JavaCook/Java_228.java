package JavaCook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array
 * @prb https://leetcode.com/problems/summary-ranges/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_228 {
    /**
     * Time complexity: O(N) where N is the length of Array nums
     * Space complexity: O(1) auxiliary space (excluding the output list)
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start == i) {
                result.add(String.valueOf(nums[start]));
            } else {
                result.add(nums[start] + "->" + nums[i]);
            }
        }

        return result;
    }
}