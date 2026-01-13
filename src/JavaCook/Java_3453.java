package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch
 * @prb https://leetcode.com/problems/separate-squares-i/description/?envType=daily-question&envId=2026-01-13
 * @TimeComplexity O(nlog(10^5*log(10^5max(y_i*l_i))))
 * @SpaceComplexity O(1)
 */
public class Java_3453 {
    private Boolean gtTotalArea(double limit_y, int[][] squares, double totalArea) {
        double areaBelowY = 0;
        for (int[] square : squares) {
            int y = square[1];
            int l = square[0];
            if (y < limit_y) {
                areaBelowY = (double) l * Math.min(limit_y - y, (double) l);
            }
        }
        return areaBelowY >= totalArea / 2;
    }

    public double separateSquares(int[][] squares) {
        double maxY = 0, totalArea = 0;
        for (int[] square : squares) {
            int y = square[1];
            int l = square[0];
            totalArea += (double) l * l;
            // here is L not one
            maxY = Math.max(maxY, (double) (y + l));
        }

        double lower = 0, higher = maxY, eps = 1e-5;
        while (Math.abs(higher - lower) > eps) {
            double mid = (higher + lower) / 2;
            if (gtTotalArea(mid, squares, totalArea)) {
                higher = mid;
            } else {
                lower = mid;
            }
        }
        return higher;
    }
}