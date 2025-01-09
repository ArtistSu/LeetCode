package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/search-insert-position/description/
 * Time complexity:O(n)
 * Space complexity: O(1)
 */
public class Java_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if ((nums[i] < target) && (i != nums.length - 1) && (nums[i + 1] > target)) {
                return i + 1;
            }
        }
        return nums.length;
    }
}