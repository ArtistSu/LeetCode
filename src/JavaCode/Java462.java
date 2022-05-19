package JavaCode;

import java.util.Arrays;

public class Java462 {
    /**
     * Time Complexity: O(nlogn) {@code n} is the length of {@param nums}
     * Space Complexity: O(1)
     * @topic Minimum Moves to Equal Array Elements II
     * @author ArtistS
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return calculateStep(nums, nums[len / 2]);
    }

    public int calculateStep(int[] nums, int target){
        int res = 0;
        for(int num : nums){
            res += Math.abs(num - target);
        }
        return res;
    }
}
