package JavaCook;

/**
 * @author ArtistS
 * @tag Array
 * @prb https://leetcode.com/problems/maximum-ascending-subarray-sum/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_1800 {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }
            res = Math.max(currSum, res);
        }
        return res;
    }
}