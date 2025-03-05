package JavaCook;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/count-total-number-of-colored-cells/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_2579_2 {
    public long coloredCells(int n) {
        return 1+(long)2*n*(n-1);
    }
}