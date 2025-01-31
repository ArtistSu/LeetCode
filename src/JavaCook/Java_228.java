package JavaCook;

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
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();

        if (nums.length == 0) {
            return res;
        }

        int start = nums[0];
        StringBuilder partRes = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                res.add(start == nums[i - 1] ? partRes.append(start).toString() : partRes.append(start).append("->").append(nums[i - 1]).toString());
                start = nums[i];
            }
            partRes.setLength(0);
        }
        res.add(start == nums[nums.length - 1] ? partRes.append(start).toString() : partRes.append(start).append("->").append(nums[nums.length - 1]).toString());
        return res;
    }
}