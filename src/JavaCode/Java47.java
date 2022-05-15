package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Java47 {

    boolean[] visited;

    /**
     * Time Complexity: O(n * n!) {@code n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Permutations II
     * @author ArtistS
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> perm = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        traceBack(nums, perm, res, 0);
        return res;

    }

    public void traceBack(int[] nums, List<Integer> perm, List<List<Integer>> res, int currIdx) {
        if (currIdx == nums.length) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            perm.add(nums[i]);
            visited[i] = true;
            traceBack(nums, perm, res, currIdx + 1);
            visited[i] = false;
            perm.remove(currIdx);
        }
    }
}

