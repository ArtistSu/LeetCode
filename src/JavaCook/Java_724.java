package JavaCook;

/**
 * @author ArtistS
 * @tag Array PrefixSum LC75
 * @prb <a href="https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(1)
 */
public class Java_724 {
    public int pivotIndex(int[] nums) {
        int currSum = 0, totalSum = 0;
        // Get the totalSum
        for (int num : nums) {
            totalSum += num;
        }

        // Try to find the index k that can make leftSum = rightSum
        for (int i = 0; i < nums.length; i++) {
            if (currSum == (totalSum - nums[i] - currSum)) {
                return i;
            }
            currSum += nums[i];
        }
        return -1;
    }
}