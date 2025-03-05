package JavaCook;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/count-total-number-of-colored-cells/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2579 {
    public long coloredCells(int n) {
        long res = 1;
        while (n > 0) {
            res += (n * 4 - 4);
            n--;
        }
        return res;
    }
}