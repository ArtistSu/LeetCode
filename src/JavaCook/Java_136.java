package JavaCook;

/**
 * @author ArtistS
 * @tag Xor
 * @prb https://leetcode.com/problems/single-number/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_136 {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}