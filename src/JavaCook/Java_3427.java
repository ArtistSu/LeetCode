package JavaCook;

/**
 * @author ArtistS
 * @tag Subarray
 * @prb https://leetcode.com/problems/sum-of-variable-length-subarrays/
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class Java_3427 {
    public int subarraySum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            for (int j = start; j <= i; j++) {
                res += nums[j];
            }
        }
        return res;
    }
}