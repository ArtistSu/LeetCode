package JavaCook;

/**
 * @author ArtistS
 * @tag Math Backtracting
 * @prb https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/
 * Time complexity: O(2^(log_3(n)))
 * Space complexity: O(log_3(n))
 */
public class Java_1780 {
    public boolean checkPowersOfThree(int n) {
        return helper(n, 0, 0);
    }

    public boolean helper(int n, int tempRes, int power) {
        if (tempRes >= n) {
            if (tempRes == n) return true;
            else return false;
        }
        if(Math.pow(3, power) > n) return false;

        return helper(n, tempRes+(int)Math.pow(3,power), power + 1) || helper(n, tempRes, power+1);
    }

    public static void main(String[] args) {
        System.out.println(new Java_1780().checkPowersOfThree(12));
    }
}