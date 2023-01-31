package JavaCode;

import java.util.Arrays;

public class Java1464 {
    /**
     * Time Complexity: O(nlogn) {@param n} is the length of {@param nums}
     * Space Complexity: O(logn)
     * @topic  Maximum Product of Two Elements in an Array
     * @author ArtistS
     * @method QuickSort
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max((nums[0] - 1) * (nums[1] - 1), (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1));
    }

}
