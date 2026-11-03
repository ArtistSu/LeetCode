package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/search-insert-position/description/ Time complexity:O(n) Space complexity: O(1)
 */
public class Java_35 {
    /**
     * Time complexity:O(log(N)) N is the length of Array nums
     * Space complexity: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}