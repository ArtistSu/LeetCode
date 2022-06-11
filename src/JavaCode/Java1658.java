package JavaCode;

import java.util.Arrays;

public class Java1658 {
    /**
     * Time Complexity: O(n) {@code n} is the length of{@param nums}
     * Space Complexity: O(1)
     * @method Slide Window
     * @topic  Minimum Operations to Reduce X to Zero
     * @author ArtistS
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int left = 0, right = 0, sub = sum - x, res = 0;
        if (sub < 0) {
            return -1;
        }
        if(sub == 0){
            return nums.length;
        }

        while (right < nums.length) {
            sub -= nums[right];
            while (sub < 0) {
                sub += nums[left++];
            }
            if (sub == 0) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res == 0 ? -1 : nums.length - res;
    }
}
