package JavaCook;

/**
 * @author ArtistS
 * @tag Array StoreMaximumValue
 * @prb https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2342_2 {
        public int maximumSum(int[] nums) {
            int result = -1;
            int[] digitMapping = new int[82];

            for (int element : nums) {
                int digitSum = 0;
                for (int currValue = element; currValue != 0; currValue /= 10) {
                    int currDigit = currValue % 10;
                    digitSum += currDigit;
                }

                if (digitMapping[digitSum] > 0) {
                    result = Math.max(result, digitMapping[digitSum] + element);
                }
                digitMapping[digitSum] = Math.max(digitMapping[digitSum], element);
            }

            return result;
        }
}