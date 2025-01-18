package JavaCook;

/**
 * @author ArtistS
 * @tag Counting
 * @prb https://leetcode.com/problems/majority-element/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_169 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int freq = 0;
        for (int num : nums) {
            if (freq == 0) {
                res = num;
            }
            freq += (res == num) ? 1 : -1;
        }
        return res;
    }
}