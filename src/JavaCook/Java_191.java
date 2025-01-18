package JavaCook;

/**
 * @author ArtistS
 * @tag BitManipulation
 * @prb https://leetcode.com/problems/number-of-1-bits/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}