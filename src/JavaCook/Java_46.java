package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Array Backtracking
 * @prb https://leetcode.com/problems/permutations/description/
 * Time complexity: O(n!)
 * Space complexity: O(n)
 */
public class Java_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfsPermute(res, new LinkedList<Integer>(), nums);
        return res;
    }

    public void dfsPermute(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempList));
            return;
        } else {
            for (int num : nums) {
                if (!tempList.contains(num)) {
                    tempList.add(num);
                    dfsPermute(res, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}