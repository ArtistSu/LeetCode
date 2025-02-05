package JavaCook;

/**
 * @author ArtistS
 * @tag Array Math TwoPointers
 * @prb https://leetcode.com/problems/rotate-array/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_189_2 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right){
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }
}