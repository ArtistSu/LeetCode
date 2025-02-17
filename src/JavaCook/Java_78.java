package JavaCook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array Backtracking
 * @prb https://leetcode.com/problems/subsets/solutions/
 * Time complexity: O（n*2^n）
 * Space complexity: O(n)
 */
public class Java_78 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        subsets(0, new LinkedList<>(), nums);
        return res;
    }

    // From start, we choose nums[start] or we don't choose nums[start]
    public void subsets(int start, List<Integer> tempList, int[] nums) {
        if (start >= nums.length) return;

        tempList.add(nums[start]);
        res.add(new ArrayList<>(tempList));
        subsets(start + 1, tempList, nums);

        tempList.remove(tempList.size() - 1);
        subsets(start + 1, tempList, nums);
    }
}