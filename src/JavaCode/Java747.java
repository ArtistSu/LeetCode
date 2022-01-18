package JavaCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class Java747 {
    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && (nums[i] * 2 > nums[maxIndex])) {
                return -1;
            }
        }
        return maxIndex;
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * @param nums
     * @return
     */
    public int dominantIndex2(int[] nums) {

        int maxDigit = 0;
        int maxIndex = 0;
        int secondDigit = 0;
        int secondIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxDigit) {
                maxDigit = nums[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxDigit) {
                continue;
            }
            if (nums[i] > secondDigit) {
                secondDigit = nums[i];
                secondIndex = i;
            }
        }

        if (maxDigit >= 2 * secondDigit) {
            return maxIndex;
        }
        return -1;
    }
}
