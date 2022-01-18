package JavaCode;

public class Java498 {

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        // Upper right ->  true  left bottom -> false
        boolean direction = true;
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        result[0] = mat[0][0];

        // coordinate
        int x = 0;
        int y = 0;
        for (int i = 1; i < m * n; i++) {

            if (direction) {
                x -= 1;
                y += 1;

                if (x < 0 && y <= n - 1) {
                    x += 1;
                    direction = false;
                }

                if (x <= m - 1 && y > n - 1) {
                    x += 2;
                    y -= 1;
                    direction = false;
                }

                if (x < 0 && y > n - 1) {
                    x += 2;
                    y -= 1;
                    direction = false;
                }
                result[i] = mat[x][y];
            } else {
                x += 1;
                y -= 1;
                if (x <= m - 1 && y < 0) {
                    y += 1;
                    direction = true;
                }

                if (x > m - 1 && y >= 0) {
                    x -= 1;
                    y += 2;
                    direction = true;
                }
                if (x > m - 1 && y < 0) {
                    x -= 1;
                    y += 2;
                    direction = true;
                }
                result[i] = mat[x][y];
            }

        }
        return result;
    }
}
