package JavaCook;

/**
 * @author ArtistS
 * Time complexity: O(n), n is how many digits does the number have?
 * Space complexity: O(1)
 * @tag math
 * @prb https://leetcode.com/problems/palindrome-number/description/
 */
public class Java_9_2 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int revertNbr = 0;
        int x_cp = x;
        while (x > 0) {
            revertNbr = revertNbr * 10 + x % 10;
            x /= 10;
        }
        return x_cp == revertNbr;
    }
}