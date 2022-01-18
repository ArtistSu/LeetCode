package JavaCode;

import java.util.Arrays;

public class Java561 {
    /**
     * Title: Array Partition I
     * Quick sort
     * Time Complexity : O(n * log n)
     * Space Complexity : O(log n)
     * @param nums
     * @return
     */
    public int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum = nums[i] + sum;
        }
        return sum;
    }
    /**
     * BF method Time limit exceeded
     * Time Compleity : O(n2)
     * Space Complexity : O(1)
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            for (int j = i; j < numsLength; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < numsLength; i += 2) {
            sum = sum + Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }
}
