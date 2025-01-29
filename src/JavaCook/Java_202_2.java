package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag TwoPointers
 * @prb https://leetcode.com/problems/happy-number/description/
 * Time complexity:O(logn)
 * Space complexity: O(1)
 */
public class Java_202_2 {
    class Solution {
        public boolean isHappy(int n) {
            int slow = getNextNumber(n);
            int fast = getNextNumber(getNextNumber(n));

            while (slow != fast) {
                if (fast == 1) return true;
                slow = getNextNumber(slow);
                fast = getNextNumber(getNextNumber(fast));
            }

            return slow == 1;
        }

        private int getNextNumber(int n) {
            int output = 0;

            while (n > 0) {
                int digit = n % 10;
                output += digit * digit;
                n = n / 10;
            }

            return output;
        }
    }
}