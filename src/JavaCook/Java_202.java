package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag HashTable
 * @prb https://leetcode.com/problems/happy-number/description/
 * Time complexity:O(logn)
 * Space complexity: O(1)
 */
public class Java_202{
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while (!visit.contains(n)) {
            visit.add(n);
            n = getSquare(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int getSquare(int n) {
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }
}