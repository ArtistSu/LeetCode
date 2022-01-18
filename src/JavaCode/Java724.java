package JavaCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Java724 {
    /**
     *Time Complexity : O(n^2)
     *Space Complexity: O(n)
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }

    /**
     *Time Complexity : O(n^2)
     *Space Complexity: O(n)
     */
    public int pivotIndex2(int[] nums) {
        int sumLeft = 0;
        int sumRight = 0;
        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            for (int j = 0; j < i; j++) {
                sumLeft = sumLeft + nums[j];
            }
            for (int j = i + 1; j < numsLength; j++) {
                sumRight = sumRight + nums[j];
            }
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft = 0;
            sumRight = 0;
        }
        return -1;
    }


}
