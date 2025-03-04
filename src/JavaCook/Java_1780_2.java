package JavaCook;

/**
 * @author ArtistS
 * @tag Math Backtracting
 * @prb https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/
 * Time complexity: O(log_3(n))
 * Space complexity: O(1)
 */
public class Java_1780_2 {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}