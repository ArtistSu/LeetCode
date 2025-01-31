package JavaCook;

/**
 * @author ArtistS
 * @tag Loop BitManipulation
 * @prb https://leetcode.com/problems/power-of-two/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int num = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                num++;
            }
            if (num == 2) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
}