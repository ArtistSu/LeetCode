package JavaCode;

import java.util.Arrays;

public class Java209 {
    /**
     * Title : Minimum Size Subarray Sum
     * Sliding Window
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE, startIdx = 0, endIdx = 0, sum = 0;

        while (endIdx < nums.length) {
            sum += nums[endIdx];
            while(sum >= target){
                result = Math.min(result, endIdx - startIdx + 1);
                sum -= nums[startIdx];
                startIdx++;
            }
            endIdx++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }



    /**
     * Title : Minimum Size Subarray Sum
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = nums.length, startIdx = 0, endIdx = 0, sum = nums[0];
        if(Arrays.stream(nums).sum() < target){
            return 0;
        }

        while (startIdx != nums.length) {
            sum = (startIdx == endIdx) ? nums[startIdx] : sum + nums[endIdx];
            if (sum < target) {
                if (endIdx == nums.length - 1) {
                    startIdx++;
                    endIdx = startIdx;
                    continue;
                }
                endIdx++;
            }
            if (sum >= target) {
                result = (endIdx - startIdx + 1) < result ? (endIdx - startIdx + 1) : result;
                startIdx++;
                endIdx = startIdx;
                sum = 0;
            }
        }
        return result;
    }
}
