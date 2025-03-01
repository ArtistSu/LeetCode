package JavaCook;

/**
 * @author ArtistS
 * @tag Array TwoPointers Simulation
 * @prb https://leetcode.com/problems/apply-operations-to-an-array/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2460 {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int point = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] == nums[index + 1]) {
                nums[index] = 2 * nums[index];
                nums[index + 1] = 0;
            }
            if (nums[index] != 0) {
                res[point++] = nums[index];
            }
        }
        res[point] = nums[nums.length - 1];
        return res;
    }
}