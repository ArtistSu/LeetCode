package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Array Backtracking BitManipulation
 * @prb https://leetcode.com/problems/subsets-ii/description/
 * Time complexity: O(nlogn + 2^n)
 * Space complexity: O(n+2^n)
 */
public class Java_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        findAllSubsets(0, nums, new LinkedList<>(), res);
        return res;
    }

    public void findAllSubsets(int start, int[] nums, List<Integer> tempList, List<List<Integer>> res) {
        res.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            findAllSubsets(i + 1, nums, tempList, res);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Java_90().subsetsWithDup(new int[]{1, 2, 2});
    }
}