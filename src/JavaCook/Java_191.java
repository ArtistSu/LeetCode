package JavaCook;

/**
 * @author ArtistS
 * @tag BitManipulation
 * @prb https://leetcode.com/problems/number-of-1-bits/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_191 {
    /**
     * Time complexity: O(N) N is the number of bits of n
     * Space complexity: O(1)
     */
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += (n & 1);
            n >>>= 1;
        }

        return res;
    }

    /**
     * Time complexity: O(N) N is the number of bits of n
     * Space complexity: O(1)
     */
    public int hammingWeight_google_l4(int n) {
        int res = 0;
        while(n != 0){
            n &= (n-1);
            res++;
        }

        return res;
    }
}