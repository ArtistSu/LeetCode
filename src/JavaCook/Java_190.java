package JavaCook;

/**
 * @author ArtistS
 * @tag bitManipulation
 * @prb https://leetcode.com/problems/reverse-bits/description/
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class Java_190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int leastBit = n & 1;
            res = (res << 1) | leastBit;
            n = n >>> 1;
        }
        return res;
    }
}