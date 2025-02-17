package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb Time complexity:
 * Space complexity:
 */
public class Java_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        result.add(new ArrayList<>()); // empty set
        subsets(0, nums, numList, result);
        return result;
    }

    private void subsets(int offset, int[] nums, List<Integer> numList, List<List<Integer>> result) {
        if (offset >= nums.length) {
            return;
        }
        int val = nums[offset];
        // pick
        numList.add(val);
        subsets(offset + 1, nums, numList, result);
        // add to result
        result.add(new ArrayList<>(numList));
        // not pick
        numList.remove(numList.size() - 1);
        subsets(offset + 1, nums, numList, result);
    }

    public static void main(String[] args) {
        new Java_90().subsetsWithDup(new int[]{1, 2, 2});
    }
}