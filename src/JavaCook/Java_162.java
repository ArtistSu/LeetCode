package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity O(log(N))
 * @SpaceComplexity O(1)
 */
public class Java_162{
        public int findPeakElement(int[] nums) {
            // 1. Defensive check
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int left = 0;
            int right = nums.length - 1;

            // 2. Left-closed, right-open / Single-point convergence, binary search
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
}