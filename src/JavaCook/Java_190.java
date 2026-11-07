package JavaCook;

/**
 * @author ArtistS
 * @tag bitManipulation
 * @prb https://leetcode.com/problems/reverse-bits/description/
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class Java_190 {
    /**
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int reverseBits_google_l4(int n) {
        int res = 0;
        for(int i = 0; i < 32;i++){
            int lastBit = n & 1;
            n = n >>> 1;
            res = (res << 1) | lastBit;
        }

        return res;
    }
}