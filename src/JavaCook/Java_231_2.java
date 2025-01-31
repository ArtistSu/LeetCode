package JavaCook;

/**
 * @author ArtistS
 * @tag Math BitManipulation
 * @prb https://leetcode.com/problems/power-of-two/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_231_2 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}