package JavaCook;

/**
 * @author ArtistS
 * @tag CharacterComparison
 * @prb https://leetcode.com/problems/palindrome-number/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_9 {
    /**
     * Time complexity: O(log10(x)) - proportional to the number of digits in x
     * Space complexity: O(1)
     */
    public boolean isPalindrome_google_l4(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while(x > reversedHalf){
            reversedHalf = reversedHalf*10 + x % 10;
            x /= 10;
        }

        return reversedHalf == x || reversedHalf / 10 == x;
    }
}